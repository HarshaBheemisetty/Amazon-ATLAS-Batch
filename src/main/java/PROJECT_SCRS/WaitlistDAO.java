package PROJECT_SCRS;

import java.util.ArrayList;
import java.util.List;

public class WaitlistDAO {
    private List<WaitlistEntry> waitlist = new ArrayList<>();

    public void addToWaitlist(String studentId, String courseId) {
        waitlist.add(new WaitlistEntry(studentId, courseId));
        System.out.println("Student " + studentId + " added to waitlist for course " + courseId);
    }

    public void removeFromWaitlist(String studentId, String courseId) {
        waitlist.removeIf(entry -> entry.getStudentId().equals(studentId)
                && entry.getCourseId().equals(courseId));
        System.out.println("Student " + studentId + " removed from waitlist for course " + courseId);
    }

    public List<WaitlistEntry> getWaitlistForCourse(String courseId) {
        List<WaitlistEntry> courseWaitlist = new ArrayList<>();
        for (WaitlistEntry entry : waitlist) {
            if (entry.getCourseId().equals(courseId)) {
                courseWaitlist.add(entry);
            }
        }
        return courseWaitlist;
    }

    public void printAllWaitlists() {
        if (waitlist.isEmpty()) {
            System.out.println("No students are on the waitlist.");
        } else {
            System.out.println("Waitlist entries:");
            for (WaitlistEntry entry : waitlist) System.out.println(entry);
        }
    }
}
