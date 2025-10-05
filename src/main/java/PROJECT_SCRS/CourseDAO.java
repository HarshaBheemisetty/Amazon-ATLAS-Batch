package PROJECT_SCRS;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.HashMap;
import java.util.Map;

public class CourseDAO {
    private final DynamoDbClient client;
    private final String tableName = "Courses";

    public CourseDAO(DynamoDbClient client) {
        this.client = client;
    }

    // ------------------ SAVE COURSE ------------------
    public void saveCourse(Course c) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("courseId", AttributeValue.builder().s(c.getCourseId()).build());
        item.put("name", AttributeValue.builder().s(c.getCourseName()).build());
        item.put("capacity", AttributeValue.builder().n(String.valueOf(c.getMaxCapacity())).build());
        item.put("enrolledCount", AttributeValue.builder().n(String.valueOf(c.getEnrolledCount())).build());

        client.putItem(PutItemRequest.builder()
                .tableName(tableName)
                .item(item)
                .build());
    }

    // ------------------ GET COURSE BY ID ------------------
    public Course getCourse(String courseId) {
        Map<String, AttributeValue> key = new HashMap<>();
        key.put("courseId", AttributeValue.builder().s(courseId).build());

        GetItemResponse response = client.getItem(GetItemRequest.builder()
                .tableName(tableName)
                .key(key)
                .build());

        if (!response.hasItem()) return null;

        Map<String, AttributeValue> item = response.item();
        return new Course(
                item.get("courseId").s(),
                item.get("name").s(),
                Integer.parseInt(item.get("capacity").n()),
                null,
                null
        );
    }

    // ------------------ PRINT ALL COURSES ------------------
    public void printAllCourses() {
        try {
            ScanRequest scanRequest = ScanRequest.builder()
                    .tableName(tableName)
                    .build();

            ScanResponse scanResponse = client.scan(scanRequest);

            if (scanResponse.count() == 0) {
                System.out.println("No courses found.");
                return;
            }

            System.out.println("\n=== Available Courses ===");
            for (Map<String, AttributeValue> item : scanResponse.items()) {
                String courseId = item.get("courseId").s();
                String name = item.get("name").s();
                String capacity = item.get("capacity").n();
                String enrolled = item.get("enrolledCount").n();

                System.out.println(
                        "Course ID: " + courseId +
                                " | Name: " + name +
                                " | Capacity: " + capacity +
                                " | Enrolled: " + enrolled
                );
            }
        } catch (Exception e) {
            System.err.println("Error fetching all courses: " + e.getMessage());
        }
    }
}
