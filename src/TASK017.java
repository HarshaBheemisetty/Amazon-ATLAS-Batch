import java.util.HashMap;


class person {
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
public class TASK017 {
    public static void main(String[] args) {
        person myObj = new person();

        // Set name using setter
        myObj.setName("John");

        // Get name using getter
        System.out.println(myObj.getName());
    }
}
