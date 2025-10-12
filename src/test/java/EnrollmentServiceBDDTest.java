import PROJECT_SCRS.EnrollmentService;
import PROJECT_SCRS.Student;
import PROJECT_SCRS.Course;
import PROJECT_SCRS.EnrollmentRecord;
import PROJECT_SCRS.enrollmentStatus;
import PROJECT_SCRS.StudentDAO;
import PROJECT_SCRS.CourseDAO;
import PROJECT_SCRS.EnrollmentDAO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EnrollmentServiceBDDTest {

    private EnrollmentService enrollmentService;
    private StudentDAO studentDAO;
    private CourseDAO courseDAO;
    private EnrollmentDAO enrollmentDAO;

    @BeforeEach
    void setUp() {
        // Mock the DAOs
        studentDAO = Mockito.mock(StudentDAO.class);
        courseDAO = Mockito.mock(CourseDAO.class);
        enrollmentDAO = Mockito.mock(EnrollmentDAO.class);

        // Initialize EnrollmentService with mocks
        enrollmentService = new EnrollmentService(studentDAO, courseDAO, enrollmentDAO);

        // Create Students
        enrollmentService.createStudent("S101", "Alice", "alice@example.com", "pwd123");
        enrollmentService.createStudent("S102", "Bob", "bob@example.com", "pwd456");
        enrollmentService.createStudent("S103", "Charlie", "charlie@example.com", "pwd789");

        // Create Courses
        enrollmentService.createCourse("C101", "Oops", 2,
                LocalDate.now(), LocalDate.now().plusDays(30));
        enrollmentService.createCourse("C102", "Algorithms", 1,
                LocalDate.now(), LocalDate.now().plusDays(30));
    }

    @Test
    void testSuccessfulEnrollment() {
        EnrollmentRecord record = enrollmentService.enroll("S101", "C101");

        assertThat(record.getStatus(), is(enrollmentStatus.ENROLLED));
        assertThat(record.getCourse().getCourseId(), is("C101"));
    }

    @Test
    void testCourseFullWaitlistEnrollment() {
        enrollmentService.enroll("S101", "C102"); // fills the course
        EnrollmentRecord record = enrollmentService.enroll("S102", "C102"); // waitlisted

        assertThat(record.getStatus(), is(enrollmentStatus.WAITLISTED));
    }

    @Test
    void testDropStudentPromotesWaitlist() {
        enrollmentService.enroll("S101", "C101");
        enrollmentService.enroll("S102", "C101");
        enrollmentService.enroll("S103", "C101"); // waitlisted

        boolean dropped = enrollmentService.drop("S101", "C101");
        assertThat(dropped, is(true));

        // Check that S3 got promoted from waitlist
        List<EnrollmentRecord> courseEnrollments = enrollmentService.listEnrollmentsForCourse("C101");
        EnrollmentRecord promoted = courseEnrollments.stream()
                .filter(r -> r.getStudent().getStudentId().equals("S103"))
                .findFirst()
                .orElse(null);

        assertThat(promoted, is(notNullValue()));
        assertThat(promoted.getStatus(), is(enrollmentStatus.ENROLLED));
    }

    @Test
    void testDropWaitlistedStudent() {
        enrollmentService.enroll("S101", "C102"); // fills the course
        enrollmentService.enroll("S102", "C102"); // waitlisted

        boolean dropped = enrollmentService.drop("S102", "C102");
        assertThat(dropped, is(true));

        EnrollmentRecord rec = enrollmentService.getEnrollment("S102", "C102");
        assertThat(rec.getStatus(), is(enrollmentStatus.DROPPED));
    }

    @Test
    void testInvalidStudentOrCourse() {
        IllegalArgumentException ex1 = assertThrows(IllegalArgumentException.class, () ->
                enrollmentService.enroll("INVALID", "C101"));
        assertThat(ex1.getMessage(), containsString("Student not found"));

        IllegalArgumentException ex2 = assertThrows(IllegalArgumentException.class, () ->
                enrollmentService.enroll("S101", "INVALID"));
        assertThat(ex2.getMessage(), containsString("Course not found"));
    }

    @Test
    void testReEnrollDroppedStudent() {
        enrollmentService.enroll("S101", "C101");
        enrollmentService.drop("S101", "C101");

        EnrollmentRecord rec = enrollmentService.enroll("S101", "C101");
        assertThat(rec.getStatus(), is(enrollmentStatus.ENROLLED));
    }
}
