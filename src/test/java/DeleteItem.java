import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.DeleteItemRequest;
import software.amazon.awssdk.services.dynamodb.model.DeleteItemResponse;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class DeleteItem {
    public static void main(String[] args) {
        AwsBasicCredentials awsCreds = AwsBasicCredentials.create("fakeAccessKey", "fakeSecretKey");

        DynamoDbClient client = DynamoDbClient.builder()
                .endpointOverride(URI.create("http://localhost:8000")) // Local DynamoDB
                .region(Region.AP_SOUTH_1)
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .build();

        String tableName = "Employees01";

        // 🔑 Specify the key of the row (item) to delete
        Map<String, AttributeValue> key = new HashMap<>();
        key.put("ID", AttributeValue.builder().n("2").build());

        // 🗑️ Delete the row
        DeleteItemRequest request = DeleteItemRequest.builder()
                .tableName(tableName)
                .key(key)
                .returnValues("ALL_OLD") // return deleted item for verification
                .build();

        DeleteItemResponse response = client.deleteItem(request);

        System.out.println("Deleted Item:");
        response.attributes().forEach((k, v) -> {
            if (v.s() != null) System.out.println(k + ": " + v.s());
            else if (v.n() != null) System.out.println(k + ": " + v.n());
        });

        client.close();
    }
}
