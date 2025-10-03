package PROJECT_SCRS;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.URI;

public class DynamoDBConfig {
    public static DynamoDbClient getClient() {
        return DynamoDbClient.builder()
                .region(Region.AP_SOUTH_1) // dummy region for local DynamoDB
                .endpointOverride(URI.create("http://localhost:8000")) // DynamoDB local
                .credentialsProvider(
                        StaticCredentialsProvider.create(AwsBasicCredentials.create("dummy", "dummy"))
                )
                .build();
    }
}

