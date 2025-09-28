import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeDefinition;
import software.amazon.awssdk.services.dynamodb.model.CreateTableRequest;
import software.amazon.awssdk.services.dynamodb.model.KeySchemaElement;
import software.amazon.awssdk.services.dynamodb.model.KeyType;
import software.amazon.awssdk.services.dynamodb.model.ProvisionedThroughput;
import software.amazon.awssdk.services.dynamodb.model.ScalarAttributeType;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import java.net.URI; // needed if using endpointOverride

public class CustomerDynamoJava {
    public static void main(String[] args) {

        // Create DynamoDB client
        DynamoDbClient dynamoDb = DynamoDbClient.builder()
                .region(Region.US_WEST_2)
                .endpointOverride(URI.create("http://localhost:8000")) // uncomment for local
                .build();


        String tableName = "Customer";

        try {
            System.out.println("Creating table: " + tableName);

            CreateTableRequest request = CreateTableRequest.builder()
                    .tableName(tableName)
                    .keySchema(
                            KeySchemaElement.builder().attributeName("ID").keyType(KeyType.HASH).build(), // Partition key
                            KeySchemaElement.builder().attributeName("No").keyType(KeyType.RANGE).build()  // Sort key
                    )
                    .attributeDefinitions(
                            AttributeDefinition.builder().attributeName("ID").attributeType(ScalarAttributeType.N).build(),
                            AttributeDefinition.builder().attributeName("No").attributeType(ScalarAttributeType.S).build()
                    )
                    .provisionedThroughput(
                            ProvisionedThroughput.builder().readCapacityUnits(5L).writeCapacityUnits(5L).build()
                    )
                    .build();

            dynamoDb.createTable(request);
            System.out.println("Table created successfully.");

        } catch (DynamoDbException e) {
            System.err.println("Cannot create table. Error: " + e.getMessage());
        } finally {
            dynamoDb.close();
        }
    }
}
