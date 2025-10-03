package PROJECT_SCRS;

import java.time.LocalDate;
import java.util.*;

/**
 * Thread-safe Course class.
 * Combines simple Day3 fields with advanced Day4 features like enrolled students and waitlist.
 */
public class Course {
    private final String courseId;
    private String name;
    private final int capacity;
    private int enrolledCount; // keeps Day3 compatibility
    private LocalDate startDate;
    private LocalDate endDate;

    private final Set<Student> enrolledStudents = new LinkedHashSet<>();
    private final Queue<Student> waitlist = new ArrayDeque<>();

    public Course(String courseId, String name, int capacity, LocalDate startDate, LocalDate endDate) {
        this.courseId = Objects.requireNonNull(courseId);
        this.name = name;
        this.capacity = Math.max(0, capacity);
        this.enrolledCount = 0;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // --- Day3 getters ---
    public String getCourseId() { return courseId; }
    public String getCourseName() { return name; }
    public int getMaxCapacity() { return capacity; }
    public int getEnrolledCount() { return enrolledCount; }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public synchronized void incrementEnrolledCount() { enrolledCount++; }
    public void decrementEnrolledCount() { enrolledCount--; }


    // --- Advanced Day4 methods ---

    public synchronized int getAvailableSeats() {
        return capacity - enrolledStudents.size();
    }

    public synchronized boolean isFull() {
        return enrolledStudents.size() >= capacity;
    }

    public synchronized boolean enrollStudent(Student s) {
        if (s == null) return false;
        if (enrolledStudents.contains(s)) return true;
        if (!isFull()) {
            enrolledStudents.add(s);
            enrolledCount++; // keep Day3 counter updated
            return true;
        }
        // if full, automatically add to waitlist
        addToWaitlist(s);
        return false;
    }

    public synchronized boolean dropStudent(Student s) {
        if (s == null) return false;
        boolean removed = enrolledStudents.remove(s);
        if (removed) {
            enrolledCount--; // update Day3 counter
            // Promote next student from waitlist
            if (!waitlist.isEmpty()) {
                Student next = waitlist.poll();
                enrollStudent(next);
            }
        }
        return removed;
    }

    public synchronized void addToWaitlist(Student s) {
        if (s == null) return;
        if (waitlist.contains(s)) return;
        waitlist.add(s);
    }

    public synchronized Student pollFromWaitlist() {
        return waitlist.poll();
    }

    public synchronized boolean removeFromWaitlist(Student s) {
        return waitlist.remove(s);
    }

    public synchronized List<Student> getWaitlistSnapshot() {
        return Collections.unmodifiableList(new ArrayList<>(waitlist));
    }

    public synchronized List<Student> getEnrolledStudentsSnapshot() {
        return Collections.unmodifiableList(new ArrayList<>(enrolledStudents));
    }

    @Override
    public String toString() {
        return String.format("%s (ID:%s) — seats: %d/%d, waitlist: %d",
                name, courseId, enrolledStudents.size(), capacity, waitlist.size());
    }
}
