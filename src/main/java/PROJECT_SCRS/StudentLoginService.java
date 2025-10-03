package PROJECT_SCRS;

public class StudentLoginService {
    private final StudentDAO studentDAO;

    public StudentLoginService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    // Register a new student
    public void register(String studentId, String name, String email, String password) {
        Student existing = studentDAO.getStudent(studentId);
        if (existing != null) {
            System.out.println("❌ Student ID already exists. Try logging in.");
            return;
        }

        Student newStudent = new Student(studentId, name, email, password);
        studentDAO.saveStudent(newStudent);
        System.out.println("✅ Registration successful for " + name);
    }

    // Login existing student
    public Student login(String studentId, String password) {
        Student student = studentDAO.getStudent(studentId);
        if (student == null) {
            System.out.println("❌ Student not found.");
            return null;
        }
        if (!student.getPassword().equals(password)) {
            System.out.println("❌ Invalid password.");
            return null;
        }

        System.out.println("✅ Login successful! Welcome, " + student.getName());
        return student;
    }
}
