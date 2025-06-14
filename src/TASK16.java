class Person2 {
    private String name;
    private int age;

    public Person2() {}

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return "Person [Name=" + name + ", Age=" + age + "]";
    }
}
//Employee.java
class Employee1 extends Person2 {
    private String employeeId;
    private String department;

    public Employee1() {}

    public Employee1(String name, int age, String employeeId, String department) {
        super(name, age);
        this.employeeId = employeeId;
        this.department = department;
    }

    // Getters and setters
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public String toString() {
        return super.toString() + ", Employee [Employee ID=" + employeeId + ", Department=" + department + "]";
    }
}
//Manager.java
class Manager extends Employee1 {
    private int teamSize;
    private String project;

    public Manager() {}

    public Manager(String name, int age, String employeeId, String department, int teamSize, String project) {
        super(name, age, employeeId, department);
        this.teamSize = teamSize;
        this.project = project;
    }

    // Getters and setters
    public int getTeamSize() { return teamSize; }
    public void setTeamSize(int teamSize) { this.teamSize = teamSize; }

    public String getProject() { return project; }
    public void setProject(String project) { this.project = project; }

    @Override
    public String toString() {
        return super.toString() + ", Manager [Team Size=" + teamSize + ", Project=" + project + "]";
    }
}


public class TASK16 {

    public static void main(String[] args)
    {
        Manager manager = new Manager("Alice", 40, "E123", "IT", 10, "AI Development");
        System.out.println(manager.toString());
    }

}
