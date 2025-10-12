package PROJECT_SCRS;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.HashMap;
import java.util.Map;

public class EnrollmentDAO {
    private final DynamoDbClient client;
    private final String tableName = "Enrollments";

    public EnrollmentDAO(DynamoDbClient client) {
        this.client = client;
    }

    // ------------------ SAVE ENROLLMENT ------------------
    public void saveEnrollment(EnrollmentRecord r) {
        Map<String, AttributeValue> item = new HashMap<>();
        String enrollmentId = r.getStudent().getStudentId() + "#" + r.getCourse().getCourseId();

        item.put("enrollmentId", AttributeValue.builder().s(enrollmentId).build());
        item.put("studentId", AttributeValue.builder().s(r.getStudent().getStudentId()).build());
        item.put("courseId", AttributeValue.builder().s(r.getCourse().getCourseId()).build());
        item.put("status", AttributeValue.builder().s(r.getStatus().name()).build());

        client.putItem(PutItemRequest.builder()
                .tableName(tableName)
                .item(item)
                .build());
    }

    // ------------------ GET ENROLLMENT BY ID ------------------
    public EnrollmentRecord getEnrollment(String enrollmentId, Student s, Course c) {
        Map<String, AttributeValue> key = new HashMap<>();
        key.put("enrollmentId", AttributeValue.builder().s(enrollmentId).build());

        GetItemResponse response = client.getItem(GetItemRequest.builder()
                .tableName(tableName)
                .key(key)
                .build());

        if (!response.hasItem()) return null;

        Map<String, AttributeValue> item = response.item();
        return new EnrollmentRecord(s, c, enrollmentStatus.valueOf(item.get("status").s()));
    }

    // ------------------ PRINT ALL ENROLLMENTS ------------------
    public void printAllEnrollments() {
        try {
            ScanRequest scanRequest = ScanRequest.builder()
                    .tableName(tableName)
                    .build();

            ScanResponse scanResponse = client.scan(scanRequest);

            if (scanResponse.count() == 0) {
                System.out.println("No enrollments found.");
                return;
            }

            System.out.println("=== All Enrollments ===");
            for (Map<String, AttributeValue> item : scanResponse.items()) {
                System.out.println(
                        "EnrollmentId: " + item.get("enrollmentId").s() +
                                ", StudentId: " + item.get("studentId").s() +
                                ", CourseId: " + item.get("courseId").s() +
                                ", Status: " + item.get("status").s()
                );
            }
        } catch (Exception e) {
            System.err.println("Error fetching all enrollments: " + e.getMessage());
        }
    }

    // ------------------ PRINT ENROLLMENTS FOR A SPECIFIC STUDENT ------------------
    public void printEnrollmentsForStudent(String studentId) {
        try {
            ScanRequest scanRequest = ScanRequest.builder()
                    .tableName(tableName)
                    .build();

            ScanResponse scanResponse = client.scan(scanRequest);

            boolean found = false;
            System.out.println("\n=== Enrollments for Student: " + studentId + " ===");
            for (Map<String, AttributeValue> item : scanResponse.items()) {
                if (item.get("studentId").s().equals(studentId)) {
                    System.out.println(
                            "Course ID: " + item.get("courseId").s() +
                                    " | Status: " + item.get("status").s()
                    );
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No enrollments found for student ID: " + studentId);
            }
        } catch (Exception e) {
            System.err.println("Error fetching enrollments for student: " + e.getMessage());
        }
    }

    // ------------------ COUNT ENROLLMENTS FOR A COURSE ------------------
    // ------------------ COUNT ENROLLMENTS FOR A COURSE ------------------
    public int countEnrollmentsForCourse(String courseId) {
        try {
            ScanRequest scanRequest = ScanRequest.builder()
                    .tableName(tableName)
                    .build();

            ScanResponse scanResponse = client.scan(scanRequest);

            int count = 0;
            for (Map<String, AttributeValue> item : scanResponse.items()) {
                String cId = item.get("courseId").s();
                // Count all enrollments regardless of status
                if (cId.equals(courseId)) {
                    count++;
                }
            }
            return count;

        } catch (Exception e) {
            System.err.println("Error counting enrollments for course " + courseId + ": " + e.getMessage());
            return 0;
        }
    }

}

