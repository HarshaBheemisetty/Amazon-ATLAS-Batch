import java.util.Scanner;
public class ATMProject
{
    private double balance;
    private Scanner scanner;

    public void ATMProject()
    {
        balance = 2000.0;
        Scanner scanner = new Scanner(System.in);
    }
    public void displayMenu()
    {
        System.out.println("ATM Menu");
        System.out.println("1. check menu");
        System.out.println("2. check balance");
        System.out.println("3. deposit");
        System.out.println("4. withdraw");
    }
    public void CheckBalance()
    {
        System.out.println("Your Balance is : " +balance);
    }
    public void deposit()
    {
        System.out.println("Enter the amount to deposit :");
        double amount = scanner.nextDouble();
        if (amount> 0)
        {
            balance+=amount;
            System.out.println(amount + " has bee deposited.");
        }
        else
        {
            System.out.println(" Added invalid amount, please add positive value.");
        }
    }
    public void withdraw()
    {
        System.out.println("Enter the amount to withdraw : ");
        double amount = scanner.nextDouble();
        if(amount>0 && amount<=balance)
        {
            balance -= amount;
            System.out.println(amount + " is successfully withdrawn");
        }
        else if(amount>balance)
        {
            System.out.println("Insufficient funds. ");
        }
        else {
            System.out.println("Invalid entry ");
        }
    }

    public static void main(String[] args)
    {
        ATMProject atm = new ATMProject();
        while(true)
        {
            atm.displayMenu();
            System.out.println("Enter your choice:");
            int choice = atm.scanner.nextInt();
            switch(choice)
            {
                case 1:
                    atm.displayMenu();
                    break;
                case 2:
                    atm.CheckBalance();
                    break;
                case 3:
                    atm.deposit();
                    break;
                case 4:
                    atm.withdraw();
                default :
                    System.out.println("Invalid Choice");
            }
        }

    }
}
