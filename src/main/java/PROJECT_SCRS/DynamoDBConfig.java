package PROJECT_SCRS;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.URI;

public class DynamoDBConfig {

    public static DynamoDbClient getClient() {
        String useLocal = System.getenv("USE_LOCAL_DB");

        if ("true".equalsIgnoreCase(useLocal)) {
            // Local DynamoDB
            return DynamoDbClient.builder()
                    .region(Region.AP_SOUTH_1) // dummy region for local
                    .endpointOverride(URI.create("http://localhost:8000"))
                    .credentialsProvider(
                            StaticCredentialsProvider.create(AwsBasicCredentials.create("dummy", "dummy"))
                    )
                    .build();
        } else {
            // AWS DynamoDB (real)
            return DynamoDbClient.builder()
                    .region(Region.AP_SOUTH_1) // change if needed
                    .build();
        }
    }
}


