package PROJECT_SCRS;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import java.time.LocalDate;
import java.util.List;

public class Main_5 {

    public static void main(String[] args) {
        DynamoDbClient client = DynamoDBConfig.getClient();

        // DAOs
        StudentDAO studentDAO = new StudentDAO(client);
        CourseDAO courseDAO = new CourseDAO(client);
        EnrollmentDAO enrollmentDAO = new EnrollmentDAO(client);
        WaitlistDAO waitlistDAO = new WaitlistDAO();

        // Sample students
        studentDAO.saveStudent(new Student("S6", "Yeshu", "yeshu@email.com", "pass1"));
        studentDAO.saveStudent(new Student("S7", "Vandana", "vandana@email.com", "pass2"));
        studentDAO.saveStudent(new Student("S8", "Pravallika", "pravallika@email.com", "pass3"));
        studentDAO.saveStudent(new Student("S9", "Harsha", "harsha@email.com", "pass4"));

        // Sample courses with start and end dates
        LocalDate start1 = LocalDate.now();
        LocalDate end1 = start1.plusMonths(3);
        Course c101 = new Course("C4", "Java Full Stack", 2, 0, start1, end1);

        LocalDate start2 = LocalDate.now();
        LocalDate end2 = start2.plusMonths(3);
        Course c102 = new Course("C5", "OOPS", 1, 0, start2, end2);

        courseDAO.saveCourse(c101);
        courseDAO.saveCourse(c102);

        // Enroll students
        enrollStudent("S6", "C4", studentDAO, courseDAO, enrollmentDAO, waitlistDAO);
        enrollStudent("S7", "C4", studentDAO, courseDAO, enrollmentDAO, waitlistDAO);
        enrollStudent("S8", "C4", studentDAO, courseDAO, enrollmentDAO, waitlistDAO);
        enrollStudent("S9", "C4", studentDAO, courseDAO, enrollmentDAO, waitlistDAO);

        enrollStudent("S7", "C5", studentDAO, courseDAO, enrollmentDAO, waitlistDAO);
        enrollStudent("S8", "C5", studentDAO, courseDAO, enrollmentDAO, waitlistDAO);

        // Print current enrollments
        printStatus(enrollmentDAO, waitlistDAO);

        // Drop a student → triggers waitlist promotion
        System.out.println("\n--- Dropping S6 from Java Full Stack ---");
        dropStudent("S6", "C4", studentDAO, courseDAO, enrollmentDAO, waitlistDAO);

        // Print final enrollments and waitlists
        printStatus(enrollmentDAO, waitlistDAO);

        client.close();
    }

    private static void enrollStudent(String studentId, String courseId,
                                      StudentDAO studentDAO,
                                      CourseDAO courseDAO,
                                      EnrollmentDAO enrollmentDAO,
                                      WaitlistDAO waitlistDAO) {
        Student student = studentDAO.getStudent(studentId);
        Course course = courseDAO.getCourse(courseId);

        if (student == null || course == null) {
            System.out.println("Invalid student or course ID!");
            return;
        }

        if (course.getEnrolledCount() < course.getMaxCapacity()) {
            course.incrementEnrolledCount();
            enrollmentDAO.saveEnrollment(new EnrollmentRecord(student, course, enrollmentStatus.ENROLLED));
            System.out.println("Enrolled " + student.getName() + " in " + course.getCourseName());
        } else {
            waitlistDAO.addToWaitlist(studentId, courseId);
            System.out.println(student.getName() + " added to waitlist for " + course.getCourseName());
        }
    }

    private static void dropStudent(String studentId, String courseId,
                                    StudentDAO studentDAO,
                                    CourseDAO courseDAO,
                                    EnrollmentDAO enrollmentDAO,
                                    WaitlistDAO waitlistDAO) {
        Student student = studentDAO.getStudent(studentId);
        Course course = courseDAO.getCourse(courseId);

        if (student == null || course == null) return;

        EnrollmentRecord record = enrollmentDAO.getEnrollment(studentId + "#" + courseId, student, course);

        if (record != null && record.getStatus() == enrollmentStatus.ENROLLED) {
            record.setStatus(enrollmentStatus.DROPPED);
            course.decrementEnrolledCount();
            System.out.println("Dropped " + student.getName() + " from " + course.getCourseName());

            // Promote first student from waitlist
            List<WaitlistEntry> waitlist = waitlistDAO.getWaitlistForCourse(courseId);
            if (!waitlist.isEmpty()) {
                WaitlistEntry promoted = waitlist.get(0);
                waitlistDAO.removeFromWaitlist(promoted.getStudentId(), promoted.getCourseId());
                enrollStudent(promoted.getStudentId(), promoted.getCourseId(),
                        studentDAO, courseDAO, enrollmentDAO, waitlistDAO);
                System.out.println("Promoted " + promoted.getStudentId() + " from waitlist to enrolled in " + course.getCourseName());
            }
        } else {
            waitlistDAO.removeFromWaitlist(studentId, courseId);
            System.out.println("Removed " + student.getName() + " from waitlist for " + course.getCourseName());
        }
    }

    private static void printStatus(EnrollmentDAO enrollmentDAO, WaitlistDAO waitlistDAO) {
        System.out.println("\n--- Current Enrollments ---");
        enrollmentDAO.printAllEnrollments();

        System.out.println("\n--- Current Waitlists ---");
        waitlistDAO.printAllWaitlists();
    }
}
