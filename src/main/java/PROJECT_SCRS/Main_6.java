package PROJECT_SCRS;

import java.time.LocalDate;

public class Main_6 {
    public static void main(String[] args) {
        EnrollmentService service = new EnrollmentService();

        // ---------------- Create Students ----------------
        service.createStudent("S1", "Alice", "alice@example.com", "pass123");
        service.createStudent("S2", "Bob", "bob@example.com", "pass123");
        service.createStudent("S3", "Charlie", "charlie@example.com", "pass123");
        service.createStudent("S4", "David", "david@example.com", "pass123");

        // ---------------- Create Courses ----------------
        service.createCourse("C101", "DSA", 2, LocalDate.now(), LocalDate.now().plusMonths(3));
        service.createCourse("C102", "OOP", 1, LocalDate.now(), LocalDate.now().plusMonths(3));

        // ---------------- Enroll Students ----------------
        service.enroll("S1", "C101"); // Alice → enrolled
        service.enroll("S2", "C101"); // Bob → enrolled
        service.enroll("S3", "C101"); // Charlie → waitlist
        service.enroll("S4", "C101"); // David → waitlist

        service.enroll("S2", "C102"); // Bob → enrolled
        service.enroll("S3", "C102"); // Charlie → waitlist

        // ---------------- Print Course Status ----------------
        System.out.println("\n--- Course Status Before Drop ---");
        service.printCourseStatus("C101");
        service.printCourseStatus("C102");

        // ---------------- Drop a Student ----------------
        System.out.println("\n--- Dropping Bob from DSA ---");
        service.drop("S2", "C101"); // Should promote first waitlisted student

        // ---------------- Print Course Status After Drop ----------------
        System.out.println("\n--- Course Status After Drop ---");
        service.printCourseStatus("C101");
        service.printCourseStatus("C102");
    }
}
