package PROJECT_SCRS;

import java.util.Objects;

/**
 * EnrollmentRecord identifies a Student⇄Course relation and tracks status.
 * equals/hashCode are based on studentId+courseId to prevent duplicates.
 */
public class EnrollmentRecord {
    private final Student student;
    private final Course course;
    private enrollmentStatus status;

    public EnrollmentRecord(Student student, Course course, enrollmentStatus status) {
        this.student = Objects.requireNonNull(student);
        this.course = Objects.requireNonNull(course);
        this.status = status;
    }

    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public enrollmentStatus getStatus() { return status; }
    public void setStatus(enrollmentStatus status) { this.status = status; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnrollmentRecord)) return false;
        EnrollmentRecord that = (EnrollmentRecord) o;
        return student.getStudentId().equals(that.student.getStudentId())
                && course.getCourseId().equals(that.course.getCourseId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(student.getStudentId(), course.getCourseId());
    }

    @Override
    public String toString() {
        return "Enrollment[" + student.getStudentId() + "->" + course.getCourseId() + ":" + status + "]";
    }
}
