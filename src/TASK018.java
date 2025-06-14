class Person {
    private String name;

    // Getter
    public String getName() {
        return name;
    }

    // Setter
    public void setName(String newName) {
        this.name = newName;
    }
}
class Task018 {
    public static void main(String[] args) {
        Person myObj = new Person();

        // Set name using setter
        myObj.setName("John");

        // Get name using getter
        System.out.println(myObj.getName());
    }
}
