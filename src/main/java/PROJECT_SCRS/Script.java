package PROJECT_SCRS;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import java.time.LocalDate;
import java.util.Map;

public class Script {

    public static void main(String[] args) {

        DynamoDbClient client = DynamoDBConfig.getClient();
        CourseDAO courseDAO = new CourseDAO(client);
        EnrollmentDAO enrollmentDAO = new EnrollmentDAO(client);

        // Correct course names mapping
        Map<String, String> courseNames = Map.of(
                "101", "DSA",
                "C101", "DSA",
                "102", "OOP",
                "C1", "DSA",
                "C201", "Data Structures",
                "C4", "Java Full Stack",
                "C3", "DSA",
                "C5", "OOPS",
                "CS101", "Intro to CS",
                "C100", "Algorithms"
        );

        for (Map.Entry<String, String> entry : courseNames.entrySet()) {
            String courseId = entry.getKey();
            String name = entry.getValue();

            // Fetch course from DynamoDB
            Course course = courseDAO.getCourse(courseId);

            if (course != null) {
                // Get the actual enrolled count from EnrollmentDAO
                int actualEnrolled = enrollmentDAO.countEnrollmentsForCourse(courseId);

                // Update course object
                course = new Course(
                        course.getCourseId(),
                        name, // updated name
                        course.getMaxCapacity(),
                        actualEnrolled, // correct enrolled count
                        course.getStartDate() != null ? course.getStartDate() : LocalDate.now(),
                        course.getEndDate() != null ? course.getEndDate() : LocalDate.now().plusMonths(3)
                );

                // Save updated course back to DynamoDB
                courseDAO.saveCourse(course);

                System.out.println("✅ Updated course: " + courseId +
                        " -> " + name + ", Enrolled: " + actualEnrolled);
            } else {
                System.out.println("⚠️ Course not found in DynamoDB: " + courseId);
            }
        }

        System.out.println("🎯 Migration completed!");
        client.close();
    }
}
