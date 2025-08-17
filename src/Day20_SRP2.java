class Employee {
    private String name;
    private String email;
    private double salary;

    public Employee(String name, String email, double salary) {
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getSalary() {
        return salary;
    }
}
class PdfReportGenerator {
    public void generate(Employee e) {
        // Simulated PDF report generation logic
        System.out.println("Generating PDF Report for " + e.getName());
        // Actual PDF logic would go here
    }
}
class EmailService {
    public void sendEmail(Employee e) {
        // Simulated email sending logic
        System.out.println("Sending email to " + e.getEmail());
        // Actual email logic would go here
    }
}
public class Day20_SRP2 {
    public static void main(String[] args) {
        Employee emp = new Employee("Harsha", "harsha@example.com", 60000);

        PdfReportGenerator reportGenerator = new PdfReportGenerator();
        EmailService emailService = new EmailService();

        reportGenerator.generate(emp);
        emailService.sendEmail(emp);
    }
}
