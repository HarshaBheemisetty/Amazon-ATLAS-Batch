package PROJECT_SCRS;

public class WaitlistEntry {
    private String studentId;
    private String courseId;

    public WaitlistEntry(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public String getStudentId() { return studentId; }
    public String getCourseId() { return courseId; }

    @Override
    public String toString() {
        return "WaitlistEntry{" + "studentId='" + studentId + '\'' +
                ", courseId='" + courseId + '\'' + '}';
    }
}
