import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class user
{
    private String username;
    private String password;
    user(String username, String password)
    {
        this.username=username;
        this.password=password;
    }
    public String getUsername()
    {
        return username;
    }
    public String getPassword()
    {
        return password;
    }


}
public class Authentication_Program
{
    private LinkedList<user>UserList;
    public void Authentication_sys()
    {
        UserList = new LinkedList<>();
    }
    public void register(String username, String password)
    {
        user newuser = new user(username, password);
        UserList.add(newuser);
        System.out.println("User registered successfully");
    }
    public boolean login(String username, String password)
    {
        for(user u : UserList)
        {
            if(u.getUsername().equals(username)&&u.getPassword().equals(password))
            {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Authentication_Program ap = new Authentication_Program();
        Scanner sc = new Scanner(System.in);

        boolean LoggedIn = false;
        while(!LoggedIn)
        {
            System.out.println("Choose an option :");
            System.out.println(" 1.Register");
            System.out.println("2.Login");
            System.out.println("3.Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice)
            {
                case 1:
                    System.out.println("Enter a username: ");
                    String regUsername = sc.nextLine();
                    System.out.println("Enter a password : ");
                    String regPassword = sc.nextLine();
                    ap.register(regUsername, regPassword);
                    break;
                case 2:
                    System.out.println("Enter your username:");
                    String loginUsername=sc.nextLine();
                    System.out.println("Enter your password: ");
                    String loginPassword=sc.nextLine();

                    if(ap.login(loginUsername, loginPassword))
                    {
                        System.out.println("Login successfully");
                        LoggedIn=true;
                    }
                    else {
                        System.out.println("Login failed");
                    }
                    break;
                case 3 :
                    System.out.println("Exiting...");
                    LoggedIn=true;
                    break;
                default:
                    System.out.println("Invalid choice,try again");
            }
        }
        sc.close();
    }

}
