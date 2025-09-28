import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UpdateItem {
    public static void main(String[] args) {
        AwsBasicCredentials awsCreds = AwsBasicCredentials.create("fakeAccessKey", "fakeSecretKey");

        DynamoDbClient client = DynamoDbClient.builder()
                .endpointOverride(URI.create("http://localhost:8000")) // change if using AWS
                .region(Region.AP_SOUTH_1)
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .build();

        String tableName = "Employees01";
        Map<String, AttributeValue> key = new HashMap<>();
        key.put("ID", AttributeValue.builder().n("2").build()); // Update item with ID=2

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter new address: ");
        String newAddress = sc.nextLine();

        // 1) Read current (previous) value
        GetItemRequest getBefore = GetItemRequest.builder()
                .tableName(tableName)
                .key(key)
                .consistentRead(true)
                .build();

        GetItemResponse beforeResp = client.getItem(getBefore);

        System.out.println("Previous Item:");
        if (beforeResp.hasItem() && !beforeResp.item().isEmpty()) {
            printItem(beforeResp.item());
        } else {
            System.out.println("  (item not found)");
        }

        // 2) Update with a NEW address
        Map<String, AttributeValue> exprVals = new HashMap<>();
        exprVals.put(":newAddress", AttributeValue.builder().s(newAddress).build());

        UpdateItemRequest updateReq = UpdateItemRequest.builder()
                .tableName(tableName)
                .key(key)
                .updateExpression("SET Address = :newAddress")
                .expressionAttributeValues(exprVals)
                .returnValues(ReturnValue.ALL_NEW)
                .build();

        UpdateItemResponse updateResp = client.updateItem(updateReq);

        System.out.println("Updated Item:");
        if (updateResp.attributes() != null && !updateResp.attributes().isEmpty()) {
            printItem(updateResp.attributes());
        } else {
            System.out.println("  (no attributes returned)");
        }

        client.close();
        sc.close();
    }

    private static void printItem(Map<String, AttributeValue> item) {
        for (Map.Entry<String, AttributeValue> e : item.entrySet()) {
            String k = e.getKey();
            AttributeValue v = e.getValue();
            if (v.s() != null) {
                System.out.println(k + ": " + v.s());
            } else if (v.n() != null) {
                System.out.println(k + ": " + v.n());
            } else {
                System.out.println(k + ": " + v.toString());
            }
        }
        System.out.println("----");
    }
}
