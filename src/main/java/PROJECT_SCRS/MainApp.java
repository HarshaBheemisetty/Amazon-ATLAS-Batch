package PROJECT_SCRS;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        // ✅ Connect to DynamoDB (Local)
        DynamoDbClient client = DynamoDBConfig.getClient();

        // ✅ Initialize DAO and Services
        StudentDAO studentDAO = new StudentDAO(client);
        CourseDAO courseDAO = new CourseDAO(client);
        EnrollmentDAO enrollmentDAO = new EnrollmentDAO(client);
        WaitlistDAO waitlistDAO = new WaitlistDAO();
        EnrollmentService enrollmentService = new EnrollmentService();

        // ✅ Student Login Service
        StudentLoginService loginService = new StudentLoginService(studentDAO);

        Scanner sc = new Scanner(System.in);
        Student loggedInStudent = null;

        System.out.println("🎓=== Student Course Registration System (Day 10) ===");

        while (true) {
            if (loggedInStudent == null) {
                System.out.println("\n1. Register Student");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Choose: ");
                int ch = sc.nextInt(); sc.nextLine();

                switch (ch) {
                    case 1 -> {
                        System.out.print("Enter Student ID: ");
                        String id = sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();
                        System.out.print("Enter Password: ");
                        String pwd = sc.nextLine();
                        loginService.register(id, name, email, pwd);
                    }
                    case 2 -> {
                        System.out.print("Enter Student ID: ");
                        String id = sc.nextLine();
                        System.out.print("Enter Password: ");
                        String pwd = sc.nextLine();
                        loggedInStudent = loginService.login(id, pwd);
                        if (loggedInStudent != null) {
                            System.out.println("✅ Welcome " + loggedInStudent.getName() + "!");
                        } else {
                            System.out.println("❌ Invalid credentials");
                        }
                    }
                    case 3 -> {
                        System.out.println("👋 Exiting...");
                        sc.close();
                        client.close();
                        return;
                    }
                    default -> System.out.println("Invalid choice!");
                }
            } else {
                // ✅ Logged-in menu
                System.out.println("\n===== DASHBOARD =====");
                System.out.println("1. Create Course");
                System.out.println("2. Enroll in Course");
                System.out.println("3. Drop from Course");
                System.out.println("4. View My Enrollments");
                System.out.println("5. View All Courses");
                System.out.println("6. Logout");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter Course ID: ");
                        String cid = sc.nextLine();
                        System.out.print("Enter Course Name: ");
                        String cname = sc.nextLine();
                        System.out.print("Enter Max Capacity: ");
                        int cap = sc.nextInt();
                        sc.nextLine();
                        LocalDate start = LocalDate.now();
                        LocalDate end = start.plusMonths(3);
                        Course course = new Course(cid, cname, cap, start, end);
                        courseDAO.saveCourse(course);
                        System.out.println("✅ Course Created: " + cname);
                    }
                    case 2 -> {
                        System.out.print("Enter Course ID: ");
                        String cid = sc.nextLine();
                        Course course = courseDAO.getCourse(cid);
                        if (course == null) {
                            System.out.println("❌ Course not found.");
                            break;
                        }
                        if (course.getEnrolledCount() < course.getMaxCapacity()) {
                            course.incrementEnrolledCount();
                            enrollmentDAO.saveEnrollment(
                                    new EnrollmentRecord(loggedInStudent, course, enrollmentStatus.ENROLLED)
                            );
                            System.out.println("✅ Enrolled in " + course.getCourseName());
                        } else {
                            waitlistDAO.addToWaitlist(loggedInStudent.getStudentId(), course.getCourseId());
                            System.out.println("⚠️ Course full, added to waitlist.");
                        }
                    }
                    case 3 -> {
                        System.out.print("Enter Course ID: ");
                        String cid = sc.nextLine();
                        Course course = courseDAO.getCourse(cid);
                        if (course == null) {
                            System.out.println("❌ Course not found.");
                            break;
                        }
                        EnrollmentRecord record = enrollmentDAO.getEnrollment(
                                loggedInStudent.getStudentId() + "#" + cid, loggedInStudent, course
                        );
                        if (record != null && record.getStatus() == enrollmentStatus.ENROLLED) {
                            record.setStatus(enrollmentStatus.DROPPED);
                            course.decrementEnrolledCount();
                            System.out.println("✅ Dropped from " + course.getCourseName());

                            // Promote first from waitlist
                            List<WaitlistEntry> waitlist = waitlistDAO.getWaitlistForCourse(cid);
                            if (!waitlist.isEmpty()) {
                                WaitlistEntry promoted = waitlist.get(0);
                                waitlistDAO.removeFromWaitlist(promoted.getStudentId(), promoted.getCourseId());
                                Student promotedStudent = studentDAO.getStudent(promoted.getStudentId());
                                course.incrementEnrolledCount();
                                enrollmentDAO.saveEnrollment(
                                        new EnrollmentRecord(promotedStudent, course, enrollmentStatus.ENROLLED)
                                );
                                System.out.println("🎉 Promoted " + promotedStudent.getName() + " from waitlist!");
                            }
                        } else {
                            waitlistDAO.removeFromWaitlist(loggedInStudent.getStudentId(), cid);
                            System.out.println("⚠️ Removed from waitlist.");
                        }
                    }
                    case 4 -> {
                        System.out.println("\n--- Your Enrollments ---");
                        enrollmentDAO.printEnrollmentsForStudent(loggedInStudent.getStudentId());
                    }
                    case 5 -> {
                        System.out.println("\n--- Available Courses ---");
                        courseDAO.printAllCourses();
                    }
                    case 6 -> {
                        loggedInStudent = null;
                        System.out.println("👋 Logged out successfully.");
                    }
                    default -> System.out.println("Invalid choice!");
                }
            }
        }
    }
}
