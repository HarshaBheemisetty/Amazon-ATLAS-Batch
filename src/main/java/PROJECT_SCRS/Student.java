package PROJECT_SCRS;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentId;
    private String name;
    private String email;
    private String password;
    private List<EnrollmentRecord> enrollments;

    public Student(String studentId, String name, String email, String password) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.enrollments = new ArrayList<>();
    }

    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public List<EnrollmentRecord> getEnrollments() { return enrollments; }

    public void addEnrollment(EnrollmentRecord e) {
        if (!enrollments.contains(e)) {
            enrollments.add(e);
        }
    }

    public void removeEnrollment(EnrollmentRecord e) {
        enrollments.remove(e);
    }

    public void viewDashboard() {
        System.out.println("\nDashboard for student: " + studentId + " - " + name);
        if (enrollments.isEmpty()) {
            System.out.println("  No enrollments yet.");
            return;
        }
        for (EnrollmentRecord e : enrollments) {
            System.out.printf("  Course: %s (%s) - Status: %s%n",
                    e.getCourse().getCourseName(),
                    e.getCourse().getCourseId(),
                    e.getStatus());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId.equals(student.studentId);
    }

    @Override
    public int hashCode() { return studentId.hashCode(); }

    @Override
    public String toString() {
        return "Student{" + studentId + ", " + name + "}";
    }
}
