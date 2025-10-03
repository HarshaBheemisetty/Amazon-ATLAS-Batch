package PROJECT_SCRS;

import java.time.LocalDate;

//test the simpler waitlist logic without a queue/DS
public class Main5_Optional {
    public static void main(String[] args) {
        // Initialize service
        EnrollmentService service = new EnrollmentService();

        /* ------------------ Step 1: Create Students ------------------ */
        Student s1 = service.createStudent("S101", "Alice", "alice@example.com", "pass123");
        Student s2 = service.createStudent("S102", "Bob", "bob@example.com", "pass456");
        Student s3 = service.createStudent("S103", "Charlie", "charlie@example.com", "pass789");

        /* ------------------ Step 2: Create Course ------------------ */
        LocalDate start = LocalDate.of(2025, 10, 1);
        LocalDate end = LocalDate.of(2025, 12, 15);
        Course c1 = service.createCourse("CSE101", "Data Structures", 2, start, end);

        /* ------------------ Step 3: Enroll Students ------------------ */
        System.out.println("\n--- ENROLLMENT PHASE ---");
        service.enroll("S101", "CSE101");  // Enrolled (Seat 1)
        service.enroll("S102", "CSE101");  // Enrolled (Seat 2)
        service.enroll("S103", "CSE101");  // Waitlisted (Full)

        /* Print status after enrollment */
        System.out.println("\n--- COURSE STATUS AFTER ENROLLMENT ---");
        service.printCourseStatus("CSE101");

        /* ------------------ Step 4: Drop Student ------------------ */
        System.out.println("\n--- DROPPING A STUDENT ---");
        service.drop("S101", "CSE101");  // Frees a seat, promotes waitlisted student

        /* Print status after drop */
        System.out.println("\n--- COURSE STATUS AFTER DROP ---");
        service.printCourseStatus("CSE101");

        /* ------------------ Step 5: Re-enroll Dropped Student ------------------ */
        System.out.println("\n--- RE-ENROLLING DROPPED STUDENT ---");
        service.enroll("S101", "CSE101"); // Now waitlisted since course full again

        /* Print status after re-enroll */
        System.out.println("\n--- FINAL COURSE STATUS ---");
        service.printCourseStatus("CSE101");

        /* ------------------ Step 6: Show Student Records ------------------ */
        System.out.println("\n--- STUDENT ENROLLMENT RECORDS ---");
        for (Student s : new Student[]{s1, s2, s3}) {
            System.out.println("Student: " + s.getName());
            for (EnrollmentRecord rec : service.listEnrollmentsForStudent(s.getStudentId())) {
                System.out.printf("  Course: %s | Status: %s%n",
                        rec.getCourse().getCourseName(),
                        rec.getStatus());
            }
        }
    }
}
