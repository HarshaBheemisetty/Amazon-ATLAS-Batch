package PROJECT_SCRS;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.util.Scanner;

public class StudentLoginMain7 {
    public static void main(String[] args) {
        // Connect to DynamoDB Local using your config
        DynamoDbClient client = DynamoDBConfig.getClient();
        StudentDAO dao = new StudentDAO(client);
        StudentLoginService loginService = new StudentLoginService(dao);
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Student Login Portal (DynamoDB Local) ===");
        while (true) {
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Student ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Password: ");
                    String pwd = sc.nextLine();

                    loginService.register(id, name, email, pwd);
                }

                case 2 -> {
                    System.out.print("Enter Student ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Password: ");
                    String pwd = sc.nextLine();

                    Student student = loginService.login(id, pwd);
                    if (student != null) {
                        System.out.println("Welcome, " + student.getName() + "!");
                        student.viewDashboard();
                    }
                }

                case 3 -> {
                    System.out.println("👋 Exiting...");
                    sc.close();
                    client.close();
                    return;
                }

                default -> System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }
}
