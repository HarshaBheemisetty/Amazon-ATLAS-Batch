public class TASK039 {

    public static void main(String [] args) {
        /* Following is not allowed and would raise error */
        Employee2 e = new subClass1("George W.", "Houston, TX", 43);
        System.out.println("\n Call mailCheck using Employee reference--");
        e.mailCheck();
    }
}

abstract class Employee2{
    private String name;
    private String address;
    private int number;

    Employee2(String name, String address, int number)
    {
        System.out.println("Constructing an Employee");
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public double computePay() {
        System.out.println("Inside Employee computePay");
        return 0.0;
    }

    public void mailCheck() {
        System.out.println("Mailing a check to " + this.name + " " + this.address);
    }

    public String toString() {
        return name + " " + address + " " + number;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String newAddress) {
        address = newAddress;
    }

    public int getNumber() {
        return number;
    }
}

class subClass1 extends Employee2{

    public subClass1(String name, String address, int number) {
        super(name, address, number);
    }
}