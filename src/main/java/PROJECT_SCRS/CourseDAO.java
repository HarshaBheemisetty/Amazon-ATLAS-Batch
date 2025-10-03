package PROJECT_SCRS;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;

import java.util.HashMap;
import java.util.Map;

public class CourseDAO {
    private final DynamoDbClient client;
    private final String tableName = "Courses";

    public CourseDAO(DynamoDbClient client) { this.client = client; }

    public void saveCourse(Course c) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("courseId", AttributeValue.builder().s(c.getCourseId()).build());
        item.put("name", AttributeValue.builder().s(c.getCourseName()).build());
        item.put("capacity", AttributeValue.builder().n(String.valueOf(c.getMaxCapacity())).build());
        item.put("enrolledCount", AttributeValue.builder().n(String.valueOf(c.getEnrolledCount())).build());

        client.putItem(PutItemRequest.builder().tableName(tableName).item(item).build());
    }

    public Course getCourse(String courseId) {
        Map<String, AttributeValue> key = new HashMap<>();
        key.put("courseId", AttributeValue.builder().s(courseId).build());

        GetItemResponse response = client.getItem(GetItemRequest.builder().tableName(tableName).key(key).build());
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
}
