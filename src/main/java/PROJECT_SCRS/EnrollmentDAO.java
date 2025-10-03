package PROJECT_SCRS;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.HashMap;
import java.util.Map;

public class EnrollmentDAO {
    private final DynamoDbClient client;
    private final String tableName = "Enrollments";

    public EnrollmentDAO(DynamoDbClient client) { this.client = client; }

    public void saveEnrollment(EnrollmentRecord r) {
        Map<String, AttributeValue> item = new HashMap<>();
        String enrollmentId = r.getStudent().getStudentId() + "#" + r.getCourse().getCourseId();
        item.put("enrollmentId", AttributeValue.builder().s(enrollmentId).build());
        item.put("studentId", AttributeValue.builder().s(r.getStudent().getStudentId()).build());
        item.put("courseId", AttributeValue.builder().s(r.getCourse().getCourseId()).build());
        item.put("status", AttributeValue.builder().s(r.getStatus().name()).build());

        client.putItem(PutItemRequest.builder().tableName(tableName).item(item).build());
    }

    public EnrollmentRecord getEnrollment(String enrollmentId, Student s, Course c) {
        Map<String, AttributeValue> key = new HashMap<>();
        key.put("enrollmentId", AttributeValue.builder().s(enrollmentId).build());

        GetItemResponse response = client.getItem(GetItemRequest.builder().tableName(tableName).key(key).build());
        if (!response.hasItem()) return null;

        Map<String, AttributeValue> item = response.item();
        return new EnrollmentRecord(s, c, enrollmentStatus.valueOf(item.get("status").s()));
    }

    // ------------------ NEW: Print all enrollments ------------------
    public void printAllEnrollments() {
        ScanRequest scanRequest = ScanRequest.builder()
                .tableName(tableName)
                .build();

        ScanResponse scanResponse = client.scan(scanRequest);

        if (scanResponse.count() == 0) {
            System.out.println("No enrollments found.");
            return;
        }

        System.out.println("Enrollments:");
        for (Map<String, AttributeValue> item : scanResponse.items()) {
            System.out.println(
                    "EnrollmentId: " + item.get("enrollmentId").s() +
                            ", StudentId: " + item.get("studentId").s() +
                            ", CourseId: " + item.get("courseId").s() +
                            ", Status: " + item.get("status").s()
            );
        }
    }
}
