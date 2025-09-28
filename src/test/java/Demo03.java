import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;
import java.net.URI;
import java.util.Map;

public class Demo03 {
    public static void main(String[] args) {
        System.out.println("Scanning data from table - Employees01");
        AwsBasicCredentials awsCreds = AwsBasicCredentials.create("fakeAccesskey","fakeSecretKey");


        DynamoDbClient client = DynamoDbClient.builder()
                .endpointOverride(URI.create("http://localhost:8000"))
                .region(Region.AP_SOUTH_1)
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .build();
        String tableName = "Employees01";


        ScanRequest req = ScanRequest.builder().tableName(tableName).build();


        ScanResponse resp = client.scan(req);


        for (Map<String, AttributeValue> dbitem : resp.items()) {
            String id = dbitem.get("ID").n();          // "N" → number
            String name = dbitem.get("Name").s();      // "S" → string
            String address = dbitem.get("Address").s();

            System.out.println("ID: " + id + ", Name: " + name + ", Address: " + address);
        }

        client.close();
    }
}
