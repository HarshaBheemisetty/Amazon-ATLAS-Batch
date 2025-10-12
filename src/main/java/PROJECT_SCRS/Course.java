package PROJECT_SCRS;

import java.time.LocalDate;
import java.util.*;

/**
 * Thread-safe Course class with enrolled count and waitlist.
 */
public class Course {
    private final String courseId;
    private String name;
    private final int capacity;
    private int enrolledCount; // tracks number of enrolled students
    private LocalDate startDate;
    private LocalDate endDate;

    private final Set<Student> enrolledStudents = new LinkedHashSet<>();
    private final Queue<Student> waitlist = new ArrayDeque<>();

    // Constructor
    public Course(String courseId, String name, int capacity, int enrolledCount,
                  LocalDate startDate, LocalDate endDate) {
        this.courseId = Objects.requireNonNull(courseId, "Course ID cannot be null");
        this.name = (name != null && !name.isEmpty()) ? name : "N/A";
        this.capacity = Math.max(0, capacity);
        this.enrolledCount = Math.max(0, enrolledCount);
        this.startDate = (startDate != null) ? startDate : LocalDate.now();
        this.endDate = (endDate != null) ? endDate : this.startDate.plusMonths(3);
    }

    // Getters
    public String getCourseId() { return courseId; }
    public String getCourseName() { return name; }
    public int getMaxCapacity() { return capacity; }
    public int getEnrolledCount() { return enrolledCount; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }

    // Setters
    public synchronized void setCourseName(String name) {
        if (name != null && !name.isEmpty()) this.name = name;
    }

    public synchronized void setStartDate(LocalDate startDate) {
        if (startDate != null) this.startDate = startDate;
    }

    public synchronized void setEndDate(LocalDate endDate) {
        if (endDate != null) this.endDate = endDate;
    }

    // **Added setter for enrolledCount**
    public synchronized void setEnrolledCount(int count) {
        if (count >= 0 && count <= capacity) {
            this.enrolledCount = count;
        }
    }

    // Increment/decrement enrolled count safely
    public synchronized void incrementEnrolledCount() {
        if (enrolledCount < capacity) enrolledCount++;
    }

    public synchronized void decrementEnrolledCount() {
        if (enrolledCount > 0) enrolledCount--;
    }

    // Waitlist & enrollment
    public synchronized boolean isFull() {
        return enrolledStudents.size() >= capacity;
    }

    public synchronized int getAvailableSeats() {
        return capacity - enrolledStudents.size();
    }

    public synchronized boolean enrollStudent(Student s) {
        if (s == null) return false;
        if (enrolledStudents.contains(s)) return true;
        if (!isFull()) {
            enrolledStudents.add(s);
            enrolledCount++;
            return true;
        }
        addToWaitlist(s);
        return false;
    }

    public synchronized boolean dropStudent(Student s) {
        if (s == null) return false;
        boolean removed = enrolledStudents.remove(s);
        if (removed) {
            decrementEnrolledCount();
            if (!waitlist.isEmpty()) {
                Student next = waitlist.poll();
                enrollStudent(next);
            }
        }
        return removed;
    }

    public synchronized void addToWaitlist(Student s) {
        if (s != null && !waitlist.contains(s)) waitlist.add(s);
    }

    public synchronized boolean removeFromWaitlist(Student s) {
        return waitlist.remove(s);
    }

    // Snapshots
    public synchronized List<Student> getWaitlistSnapshot() {
        return Collections.unmodifiableList(new ArrayList<>(waitlist));
    }

    public synchronized List<Student> getEnrolledStudentsSnapshot() {
        return Collections.unmodifiableList(new ArrayList<>(enrolledStudents));
    }

    @Override
    public String toString() {
        return String.format("%s (ID:%s) — seats: %d/%d, waitlist: %d, Start: %s, End: %s",
                name, courseId, enrolledStudents.size(), capacity, waitlist.size(),
                startDate, endDate);
    }
}
