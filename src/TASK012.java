import java.util.Scanner;

public class TASK012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String validLoginId = "Harsha";
        String validPassword = "Harsha@123";

        String loginId, password;
        int count = 0;

        do {
            System.out.print("Enter your login ID: ");
            loginId = sc.nextLine();

            System.out.print("Enter your password: ");
            password = sc.nextLine();

            if (loginId.equals(validLoginId) && password.equals(validPassword)) {
                count++;
                System.out.println("You have logged in for " + count + " times.");
            } else {
                System.out.println("Invalid login ID or password. Exiting...");
            }

        } while (loginId.equals(validLoginId) && password.equals(validPassword));

    }
}
