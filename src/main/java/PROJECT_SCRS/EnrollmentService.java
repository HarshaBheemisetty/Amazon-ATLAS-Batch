package PROJECT_SCRS;

import java.time.LocalDate;
import java.util.*;

public class EnrollmentService {
    private final Map<String, Student> students = new HashMap<>();
    private final Map<String, Course> courses = new HashMap<>();
    private final Map<String, Map<String, EnrollmentRecord>> enrollments = new HashMap<>();
    private final WaitlistManager waitlistManager = new WaitlistManager(); // Day 6 Queue-based waitlist

    /* ---------------- Student & Course management ---------------- */

    public Student createStudent(String studentId, String name, String email, String password) {
        if (students.containsKey(studentId)) return students.get(studentId);
        Student s = new Student(studentId, name, email, password);
        students.put(studentId, s);
        return s;
    }

    public Course createCourse(String courseId, String courseName, int capacity, LocalDate start, LocalDate end) {
        if (courses.containsKey(courseId)) return courses.get(courseId);
        Course c = new Course(courseId, courseName, capacity, start, end);
        courses.put(courseId, c);
        return c;
    }

    public Optional<Student> findStudent(String studentId) {
        return Optional.ofNullable(students.get(studentId));
    }

    public Optional<Course> findCourse(String courseId) {
        return Optional.ofNullable(courses.get(courseId));
    }

    public List<Course> listAllCourses() {
        return new ArrayList<>(courses.values());
    }

    /* ---------------- Enrollment operations ---------------- */

    public EnrollmentRecord enroll(String studentId, String courseId) {
        Student s = students.get(studentId);
        Course c = courses.get(courseId);
        if (s == null) throw new IllegalArgumentException("Student not found: " + studentId);
        if (c == null) throw new IllegalArgumentException("Course not found: " + courseId);

        synchronized (c) {
            EnrollmentRecord existing = getEnrollment(studentId, courseId);
            if (existing != null) {
                // Re-enroll after drop
                if (existing.getStatus() == enrollmentStatus.DROPPED) {
                    if (!c.isFull()) {
                        c.enrollStudent(s);
                        existing.setStatus(enrollmentStatus.ENROLLED);
                        s.addEnrollment(existing);
                        waitlistManager.removeFromWaitlist(courseId, studentId);
                    } else {
                        existing.setStatus(enrollmentStatus.WAITLISTED);
                        waitlistManager.addToWaitlist(courseId, studentId);
                    }
                    return existing;
                }
                return existing;
            }

            // New enrollment
            EnrollmentRecord record;
            if (!c.isFull()) {
                c.enrollStudent(s);
                record = new EnrollmentRecord(s, c, enrollmentStatus.ENROLLED);
            } else {
                // Add to waitlist queue
                record = new EnrollmentRecord(s, c, enrollmentStatus.WAITLISTED);
                waitlistManager.addToWaitlist(courseId, studentId);
            }

            enrollments.computeIfAbsent(studentId, k -> new HashMap<>()).put(courseId, record);
            s.addEnrollment(record);

            return record;
        }
    }

    public boolean drop(String studentId, String courseId) {
        Student s = students.get(studentId);
        Course c = courses.get(courseId);
        if (s == null || c == null) return false;

        synchronized (c) {
            EnrollmentRecord rec = getEnrollment(studentId, courseId);
            if (rec == null) return false;

            enrollmentStatus prev = rec.getStatus();
            if (prev == enrollmentStatus.DROPPED) return false;

            if (prev == enrollmentStatus.ENROLLED) {
                c.dropStudent(s);
                rec.setStatus(enrollmentStatus.DROPPED);
                s.removeEnrollment(rec);

                // Promote first waitlisted student
                String promoteeId = waitlistManager.pollWaitlist(courseId);
                if (promoteeId != null) {
                    Student promotee = students.get(promoteeId);
                    if (promotee != null) {
                        c.enrollStudent(promotee);
                        EnrollmentRecord pRec = getEnrollment(promoteeId, courseId);
                        if (pRec == null) {
                            pRec = new EnrollmentRecord(promotee, c, enrollmentStatus.ENROLLED);
                            enrollments.computeIfAbsent(promoteeId, k -> new HashMap<>()).put(courseId, pRec);
                            promotee.addEnrollment(pRec);
                        } else {
                            pRec.setStatus(enrollmentStatus.ENROLLED);
                            promotee.addEnrollment(pRec);
                        }
                        System.out.printf("Promotion: student %s promoted from waitlist to ENROLLED in course %s%n",
                                promoteeId, courseId);
                    }
                }
                return true;

            } else if (prev == enrollmentStatus.WAITLISTED) {
                waitlistManager.removeFromWaitlist(courseId, studentId);
                rec.setStatus(enrollmentStatus.DROPPED);
                s.removeEnrollment(rec);
                return true;
            } else {
                rec.setStatus(enrollmentStatus.DROPPED);
                s.removeEnrollment(rec);
                return true;
            }
        }
    }

    public EnrollmentRecord getEnrollment(String studentId, String courseId) {
        Map<String, EnrollmentRecord> map = enrollments.get(studentId);
        if (map == null) return null;
        return map.get(courseId);
    }

    public List<EnrollmentRecord> listEnrollmentsForStudent(String studentId) {
        Map<String, EnrollmentRecord> map = enrollments.get(studentId);
        if (map == null) return Collections.emptyList();
        return new ArrayList<>(map.values());
    }

    public List<EnrollmentRecord> listEnrollmentsForCourse(String courseId) {
        List<EnrollmentRecord> out = new ArrayList<>();
        for (Map<String, EnrollmentRecord> m : enrollments.values()) {
            EnrollmentRecord r = m.get(courseId);
            if (r != null) out.add(r);
        }
        return out;
    }

    public void printCourseStatus(String courseId) {
        Course c = courses.get(courseId);
        if (c == null) {
            System.out.println("Course not found: " + courseId);
            return;
        }
        synchronized (c) {
            System.out.printf("Course %s - %s%n", c.getCourseId(), c.getCourseName());
            System.out.printf("  Capacity: %d, Enrolled: %d, Seats left: %d%n",
                    c.getMaxCapacity(), c.getEnrolledStudentsSnapshot().size(), c.getAvailableSeats());
            System.out.println("  Enrolled students: " + c.getEnrolledStudentsSnapshot());
            // Day 6: queue-based waitlist
            System.out.println("  Waitlist: " + waitlistManager.getWaitlist(courseId));
        }
    }
}
