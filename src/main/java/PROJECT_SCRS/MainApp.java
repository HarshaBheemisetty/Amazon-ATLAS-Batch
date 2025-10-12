package PROJECT_SCRS;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        DynamoDbClient client = DynamoDBConfig.getClient();
        StudentDAO studentDAO = new StudentDAO(client);
        CourseDAO courseDAO = new CourseDAO(client);
        EnrollmentDAO enrollmentDAO = new EnrollmentDAO(client);

        EnrollmentService service = new EnrollmentService(studentDAO, courseDAO, enrollmentDAO);

        // ---------------- Load Students ----------------
        try {
            for (Map<String, AttributeValue> item : client.scan(builder -> builder.tableName("Students")).items()) {
                String studentId = item.get("studentId").s();
                String name = item.get("name").s();
                String email = item.get("email").s();
                String password = item.get("password").s();
                service.createStudent(studentId, name, email, password);
            }
        } catch (Exception e) {
            System.err.println("Error loading students: " + e.getMessage());
        }

        // ---------------- Load Courses ----------------
        try {
            for (Map<String, AttributeValue> item : client.scan(builder -> builder.tableName("Courses")).items()) {
                String courseId = item.get("courseId").s();
                String name = item.get("courseName").s();
                int capacity = Integer.parseInt(item.get("capacity").n());
                int enrolledCount = Integer.parseInt(item.get("enrolledCount").n());
                LocalDate start = LocalDate.parse(item.get("startDate").s());
                LocalDate end = LocalDate.parse(item.get("endDate").s());

                Course c = service.createCourse(courseId, name, capacity, start, end);
                // Set enrolled count from DB
                c.setEnrolledCount(enrolledCount);
            }
        } catch (Exception e) {
            System.err.println("Error loading courses: " + e.getMessage());
        }

        // ---------------- Load Enrollments ----------------
        // ---------------- Load Enrollments ----------------
        try {
            for (Map<String, AttributeValue> item : client.scan(builder -> builder.tableName("Enrollments")).items()) {
                String studentId = item.get("studentId").s();
                String courseId = item.get("courseId").s();
                enrollmentStatus status = enrollmentStatus.valueOf(item.get("status").s());

                Student student = service.findStudent(studentId).orElse(null);
                Course course = service.findCourse(courseId).orElse(null);
                if (student != null && course != null) {
                    EnrollmentRecord record = new EnrollmentRecord(student, course, status);

                    // Add to service map
                    service.getEnrollmentsMap().computeIfAbsent(studentId, k -> new HashMap<>())
                            .put(courseId, record);

                    // Add to student
                    student.addEnrollment(record);

                    // ---------------- FIX ----------------
                    if (status == enrollmentStatus.ENROLLED) {
                        course.enrollStudent(student);  // add to enrolled students list
                        course.incrementEnrolledCount(); // increase count
                    }

                    // Add to waitlist if WAITLISTED
                    if (status == enrollmentStatus.WAITLISTED) {
                        service.getWaitlistManager().addToWaitlist(courseId, studentId);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error loading enrollments: " + e.getMessage());
        }

        System.out.println("✅ Data loaded successfully!");

        // ---------------- Interactive Console ----------------
        Scanner sc = new Scanner(System.in);
        Student loggedInStudent = null;

        System.out.println("\n🎓=== Student Course Registration System ===");

        while (true) {
            if (loggedInStudent == null) {
                System.out.println("\n1. Register Student");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Choose: ");
                int ch = sc.nextInt(); sc.nextLine();

                switch (ch) {
                    case 1 -> {
                        System.out.print("Student ID: "); String id = sc.nextLine();
                        System.out.print("Name: "); String name = sc.nextLine();
                        System.out.print("Email: "); String email = sc.nextLine();
                        System.out.print("Password: "); String pwd = sc.nextLine();
                        service.createStudent(id, name, email, pwd);
                        System.out.println("✅ Student registered!");
                    }
                    case 2 -> {
                        System.out.print("Student ID: "); String id = sc.nextLine();
                        System.out.print("Password: "); String pwd = sc.nextLine();
                        Student s = service.findStudent(id).orElse(null);
                        if (s != null && s.getPassword().equals(pwd)) {
                            loggedInStudent = s;
                            System.out.println("Welcome " + s.getName() + "!");
                        } else {
                            System.out.println("Invalid credentials");
                        }
                    }
                    case 3 -> {
                        System.out.println("Exiting...");
                        sc.close();
                        client.close();
                        return;
                    }
                    default -> System.out.println("Invalid choice!");
                }
            } else {
                System.out.println("\n===== DASHBOARD =====");
                System.out.println("1. Create Course");
                System.out.println("2. Enroll in Course");
                System.out.println("3. Drop from Course");
                System.out.println("4. View My Enrollments");
                System.out.println("5. View All Courses");
                System.out.println("6. Logout");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt(); sc.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Course ID: "); String cid = sc.nextLine();
                        System.out.print("Course Name: "); String cname = sc.nextLine();
                        System.out.print("Max Capacity: "); int cap = sc.nextInt(); sc.nextLine();
                        LocalDate start = LocalDate.now();
                        LocalDate end = start.plusMonths(3);
                        service.createCourse(cid, cname, cap, start, end);
                        System.out.println("✅ Course created: " + cname);
                    }
                    case 2 -> {
                        System.out.print("Course ID: "); String cid = sc.nextLine();
                        try {
                            EnrollmentRecord rec = service.enroll(loggedInStudent.getStudentId(), cid);
                            System.out.println("Enrollment status: " + rec.getStatus());
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    case 3 -> {
                        System.out.print("Course ID: "); String cid = sc.nextLine();
                        boolean dropped = service.drop(loggedInStudent.getStudentId(), cid);
                        if (dropped) System.out.println("Successfully dropped/removed from waitlist");
                        else System.out.println("Not enrolled or not on waitlist");
                    }
                    case 4 -> {
                        System.out.println("=== My Enrollments ===");
                        for (EnrollmentRecord r : service.listEnrollmentsForStudent(loggedInStudent.getStudentId())) {
                            System.out.println(r.getCourse().getCourseName() + " | Status: " + r.getStatus());
                        }
                    }
                    case 5 -> {
                        System.out.println("=== All Courses ===");
                        for (Course c : service.listAllCourses()) {
                            service.printCourseStatus(c.getCourseId());
                        }
                    }
                    case 6 -> {
                        loggedInStudent = null;
                        System.out.println("Logged out successfully");
                    }
                    default -> System.out.println("Invalid choice!");
                }
            }
        }
    }
}
