package PROJECT_SCRS;

import java.util.*;

public class WaitlistManager {
    private final Map<String, Queue<String>> waitlists = new HashMap<>();

    public void addToWaitlist(String courseId, String studentId) {
        waitlists.computeIfAbsent(courseId, k -> new LinkedList<>()).add(studentId);
        System.out.println("Student " + studentId + " added to waitlist for course " + courseId);
    }

    public boolean removeFromWaitlist(String courseId, String studentId) {
        Queue<String> q = waitlists.get(courseId);
        if (q == null) return false;
        boolean removed = q.remove(studentId);
        if (removed) System.out.println("Student " + studentId + " removed from waitlist for course " + courseId);
        return removed;
    }

    public String pollWaitlist(String courseId) {
        Queue<String> q = waitlists.get(courseId);
        if (q == null) return null;
        return q.poll();
    }

    public List<String> getWaitlist(String courseId) {
        Queue<String> q = waitlists.get(courseId);
        if (q == null) return Collections.emptyList();
        return new ArrayList<>(q);
    }

    public void printWaitlist() {
        System.out.println("\n--- Waitlists ---");
        for (String courseId : waitlists.keySet()) {
            System.out.println("Course " + courseId + ": " + waitlists.get(courseId));
        }
    }
}
