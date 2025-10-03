package PROJECT_SCRS;

import java.time.LocalDate;
import java.util.Scanner;

public class Main_3 {
    public static void main(String[] args) {

        // Initialize Enrollment Service
        EnrollmentService enrollmentService = new EnrollmentService();

        // Create students
        enrollmentService.createStudent("S1", "Alice", "alice@example.com", "pwd123");
        enrollmentService.createStudent("S2", "Bob", "bob@example.com", "pwd456");
        enrollmentService.createStudent("S3", "Charlie", "charlie@example.com", "pwd789");

        // Create courses
        enrollmentService.createCourse("C1", "Data Structures", 2,
                LocalDate.now(), LocalDate.now().plusDays(30));
        enrollmentService.createCourse("C2", "Algorithms", 1,
                LocalDate.now(), LocalDate.now().plusDays(30));

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- COURSE ENROLLMENT SYSTEM (DAY 3) ---");
            System.out.println("1. Enroll Student");
            System.out.println("2. Drop Student");
            System.out.println("3. View Student Enrollments");
            System.out.println("4. View Course Status");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Student ID: ");
                    String sid = sc.nextLine();
                    System.out.print("Enter Course ID: ");
                    String cid = sc.nextLine();
                    try {
                        EnrollmentRecord record = enrollmentService.enroll(sid, cid);
                        System.out.println("Enrollment Successful: " + record.getStatus());
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                case 2 -> {
                    System.out.print("Enter Student ID: ");
                    String sid = sc.nextLine();
                    System.out.print("Enter Course ID: ");
                    String cid = sc.nextLine();
                    boolean dropped = enrollmentService.drop(sid, cid);
                    if (dropped) System.out.println("Student dropped successfully.");
                    else System.out.println("Drop failed.");
                }

                case 3 -> {
                    System.out.print("Enter Student ID: ");
                    String sid = sc.nextLine();
                    System.out.println("Enrollments:");
                    for (EnrollmentRecord rec : enrollmentService.listEnrollmentsForStudent(sid)) {
                        System.out.printf("Course: %s, Status: %s%n",
                                rec.getCourse().getCourseName(), rec.getStatus());
                    }
                }

                case 4 -> {
                    System.out.print("Enter Course ID: ");
                    String cid = sc.nextLine();
                    enrollmentService.printCourseStatus(cid);
                }

                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }

                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
