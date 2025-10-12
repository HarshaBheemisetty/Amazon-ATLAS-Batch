package PROJECT_SCRS;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class CourseDAO {

    private final DynamoDbClient client;
    private final String tableName = "Courses";

    public CourseDAO(DynamoDbClient client) {
        this.client = client;
    }

    // Save or update course
    public void saveCourse(Course c) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("courseId", AttributeValue.builder().s(c.getCourseId()).build());
        item.put("courseName", AttributeValue.builder().s(c.getCourseName() != null ? c.getCourseName() : "N/A").build());
        item.put("capacity", AttributeValue.builder().n(String.valueOf(c.getMaxCapacity())).build());

        // Save enrolledCount from enrolledStudents snapshot if possible
        item.put("enrolledCount", AttributeValue.builder().n(String.valueOf(c.getEnrolledCount())).build());

        item.put("startDate", AttributeValue.builder().s(c.getStartDate() != null ? c.getStartDate().toString() : LocalDate.now().toString()).build());
        item.put("endDate", AttributeValue.builder().s(c.getEndDate() != null ? c.getEndDate().toString() : LocalDate.now().plusMonths(3).toString()).build());

        client.putItem(PutItemRequest.builder()
                .tableName(tableName)
                .item(item)
                .build());
    }


    // Get course by ID
    public Course getCourse(String courseId) {
        Map<String, AttributeValue> key = new HashMap<>();
        key.put("courseId", AttributeValue.builder().s(courseId).build());

        GetItemResponse response = client.getItem(GetItemRequest.builder()
                .tableName(tableName)
                .key(key)
                .build());

        if (!response.hasItem()) return null;

        Map<String, AttributeValue> item = response.item();

        String name = item.containsKey("courseName") ? item.get("courseName").s() : "N/A";
        int capacity = item.containsKey("capacity") ? Integer.parseInt(item.get("capacity").n()) : 0;
        int enrolled = item.containsKey("enrolledCount") ? Integer.parseInt(item.get("enrolledCount").n()) : 0;
        LocalDate start = item.containsKey("startDate") ? LocalDate.parse(item.get("startDate").s()) : LocalDate.now();
        LocalDate end = item.containsKey("endDate") ? LocalDate.parse(item.get("endDate").s()) : start.plusMonths(3);

        return new Course(courseId, name, capacity, enrolled, start, end);
    }

    // Print all courses
    public void printAllCourses() {
        try {
            ScanResponse scanResponse = client.scan(ScanRequest.builder()
                    .tableName(tableName)
                    .build());

            if (scanResponse.count() == 0) {
                System.out.println("No courses found.");
                return;
            }

            System.out.println("\n=== Available Courses ===");
            for (Map<String, AttributeValue> item : scanResponse.items()) {
                String courseId = item.containsKey("courseId") ? item.get("courseId").s() : "N/A";
                String name = item.containsKey("courseName") ? item.get("courseName").s() : "N/A";
                String capacity = item.containsKey("capacity") ? item.get("capacity").n() : "0";
                String enrolled = item.containsKey("enrolledCount") ? item.get("enrolledCount").n() : "0";
                String start = item.containsKey("startDate") ? item.get("startDate").s() : LocalDate.now().toString();
                String end = item.containsKey("endDate") ? item.get("endDate").s() : LocalDate.now().plusMonths(3).toString();

                System.out.println(
                        "Course ID: " + courseId +
                                " | Name: " + name +
                                " | Capacity: " + capacity +
                                " | Enrolled: " + enrolled +
                                " | Start: " + start +
                                " | End: " + end
                );
            }

        } catch (Exception e) {
            System.err.println("Error fetching all courses: " + e.getMessage());
        }
    }

    // Update enrolled count
    public void updateEnrolledCount(String courseId, int newCount) {
        Map<String, AttributeValue> key = new HashMap<>();
        key.put("courseId", AttributeValue.builder().s(courseId).build());

        Map<String, AttributeValueUpdate> updates = new HashMap<>();
        updates.put("enrolledCount", AttributeValueUpdate.builder()
                .value(AttributeValue.builder().n(String.valueOf(newCount)).build())
                .action(AttributeAction.PUT)
                .build());

        client.updateItem(UpdateItemRequest.builder()
                .tableName(tableName)
                .key(key)
                .attributeUpdates(updates)
                .build());
    }
}
