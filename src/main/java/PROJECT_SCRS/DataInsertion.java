package PROJECT_SCRS;

import java.time.LocalDate;

public class DataInsertion {
    public static void main(String[] args) {
        // Get DynamoDB client (local or AWS based on USE_LOCAL_DB)
        var client = DynamoDBConfig.getClient();

        // Create tables
        DynamoDBTableCreator.createTables(client);

        // Seed a sample student
        StudentDAO studentDAO = new StudentDAO(client);
        Student student = new Student(
                "S001",               // studentId
                "Harsha",             // name
                "harsha@example.com", // email
                "password"            // password
        );
        studentDAO.saveStudent(student);

        // Seed a sample course
        CourseDAO courseDAO = new CourseDAO(client);
        LocalDate start = LocalDate.now();
        LocalDate end = start.plusMonths(3);
        Course course = new Course(
                "C001",     // courseId
                "DSA",      // name
                30,         // capacity
                start,      // startDate
                end         // endDate
        );

        courseDAO.saveCourse(course);

        System.out.println("Tables created and sample data inserted successfully!");
    }
}
