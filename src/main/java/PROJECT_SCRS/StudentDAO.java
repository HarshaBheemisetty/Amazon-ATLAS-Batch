package PROJECT_SCRS;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;

import java.util.HashMap;
import java.util.Map;

public class StudentDAO {
    private final DynamoDbClient client;
    private final String tableName = "Students";

    public StudentDAO(DynamoDbClient client) { this.client = client; }

    public void saveStudent(Student s) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("studentId", AttributeValue.builder().s(s.getStudentId()).build());
        item.put("name", AttributeValue.builder().s(s.getName()).build());
        item.put("email", AttributeValue.builder().s(s.getEmail()).build());
        item.put("password", AttributeValue.builder().s(s.getPassword()).build());

        client.putItem(PutItemRequest.builder().tableName(tableName).item(item).build());
    }

    public Student getStudent(String studentId) {
        Map<String, AttributeValue> key = new HashMap<>();
        key.put("studentId", AttributeValue.builder().s(studentId).build());

        GetItemResponse response = client.getItem(GetItemRequest.builder().tableName(tableName).key(key).build());
        if (!response.hasItem()) return null;

        Map<String, AttributeValue> item = response.item();
        return new Student(
                item.get("studentId").s(),
                item.get("name").s(),
                item.get("email").s(),
                item.get("password").s()
        );
    }
}
