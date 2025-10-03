package PROJECT_SCRS;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

public class DynamoDBTableCreator {

    public static void createTables(DynamoDbClient client) {
        createStudentsTable(client);
        createCoursesTable(client);
        createEnrollmentsTable(client);
        createWaitlistTable(client);
    }

    private static void createStudentsTable(DynamoDbClient client) {
        String tableName = "Students";
        try {
            client.createTable(CreateTableRequest.builder()
                    .tableName(tableName)
                    .keySchema(KeySchemaElement.builder()
                            .attributeName("studentId").keyType(KeyType.HASH).build())
                    .attributeDefinitions(AttributeDefinition.builder()
                            .attributeName("studentId").attributeType(ScalarAttributeType.S).build())
                    .provisionedThroughput(ProvisionedThroughput.builder()
                            .readCapacityUnits(5L).writeCapacityUnits(5L).build())
                    .build());
            System.out.println("Created table: " + tableName);
        } catch (ResourceInUseException e) {
            System.out.println("Table already exists: " + tableName);
        }
    }

    private static void createCoursesTable(DynamoDbClient client) {
        String tableName = "Courses";
        try {
            client.createTable(CreateTableRequest.builder()
                    .tableName(tableName)
                    .keySchema(KeySchemaElement.builder()
                            .attributeName("courseId").keyType(KeyType.HASH).build())
                    .attributeDefinitions(AttributeDefinition.builder()
                            .attributeName("courseId").attributeType(ScalarAttributeType.S).build())
                    .provisionedThroughput(ProvisionedThroughput.builder()
                            .readCapacityUnits(5L).writeCapacityUnits(5L).build())
                    .build());
            System.out.println("Created table: " + tableName);
        } catch (ResourceInUseException e) {
            System.out.println("Table already exists: " + tableName);
        }
    }

    private static void createEnrollmentsTable(DynamoDbClient client) {
        String tableName = "Enrollments";
        try {
            client.createTable(CreateTableRequest.builder()
                    .tableName(tableName)
                    .keySchema(KeySchemaElement.builder()
                            .attributeName("enrollmentId").keyType(KeyType.HASH).build())
                    .attributeDefinitions(AttributeDefinition.builder()
                            .attributeName("enrollmentId").attributeType(ScalarAttributeType.S).build())
                    .provisionedThroughput(ProvisionedThroughput.builder()
                            .readCapacityUnits(5L).writeCapacityUnits(5L).build())
                    .build());
            System.out.println("Created table: " + tableName);
        } catch (ResourceInUseException e) {
            System.out.println("Table already exists: " + tableName);
        }
    }

    private static void createWaitlistTable(DynamoDbClient client) {
        String tableName = "Waitlist";
        try {
            client.createTable(CreateTableRequest.builder()
                    .tableName(tableName)
                    .keySchema(KeySchemaElement.builder()
                            .attributeName("waitlistId").keyType(KeyType.HASH).build())
                    .attributeDefinitions(AttributeDefinition.builder()
                            .attributeName("waitlistId").attributeType(ScalarAttributeType.S).build())
                    .provisionedThroughput(ProvisionedThroughput.builder()
                            .readCapacityUnits(5L).writeCapacityUnits(5L).build())
                    .build());
            System.out.println("Created table: " + tableName);
        } catch (ResourceInUseException e) {
            System.out.println("Table already exists: " + tableName);
        }
    }
}
