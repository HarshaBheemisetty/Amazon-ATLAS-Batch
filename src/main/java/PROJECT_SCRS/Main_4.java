package PROJECT_SCRS;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.time.LocalDate;
import java.util.Scanner;

public class Main_4 {
    public static void main(String[] args) {
        DynamoDbClient client = DynamoDBConfig.getClient();

        StudentDAO studentDAO = new StudentDAO(client);
        CourseDAO courseDAO = new CourseDAO(client);
        EnrollmentDAO enrollmentDAO = new EnrollmentDAO(client);

        // Sample data
        Student s1 = new Student("S100", "Alice", "alice@example.com", "pass1");
        studentDAO.saveStudent(s1);
        Student s2 = new Student("S101", "Bob", "bob@example.com", "pass2");
        studentDAO.saveStudent(s2);

        Course c1 = new Course("C101", "DSA", 2, LocalDate.now(), LocalDate.now().plusMonths(3));
        courseDAO.saveCourse(c1);

        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("\n--- Day 4 Enrollment ---");
            System.out.println("1. Enroll Student");
            System.out.println("2. Show Student");
            System.out.println("3. Show Course");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            String choice = sc.nextLine();

            if(choice.equals("1")) {
                System.out.print("Student ID: ");
                String sid = sc.nextLine();
                System.out.print("Course ID: ");
                String cid = sc.nextLine();

                Student st = studentDAO.getStudent(sid);
                Course co = courseDAO.getCourse(cid);

                if(st == null || co == null) {
                    System.out.println("Invalid Student or Course ID.");
                    continue;
                }

                // Seat availability check
                if(co.getEnrolledCount() < co.getMaxCapacity()) {
                    co.incrementEnrolledCount();
                    enrollmentDAO.saveEnrollment(new EnrollmentRecord(st, co, enrollmentStatus.ENROLLED));
                    System.out.println("Enrolled " + st.getName() + " in " + co.getCourseName());
                } else {
                    System.out.println("Course full! Cannot enroll " + st.getName());
                }

            } else if(choice.equals("2")) {
                System.out.print("Student ID: ");
                String sid = sc.nextLine();
                System.out.println(studentDAO.getStudent(sid));
            } else if(choice.equals("3")) {
                System.out.print("Course ID: ");
                String cid = sc.nextLine();
                System.out.println(courseDAO.getCourse(cid));
            } else {
                break;
            }
        }
        sc.close();
    }
}
