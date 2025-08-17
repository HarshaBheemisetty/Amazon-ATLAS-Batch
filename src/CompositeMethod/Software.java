package CompositeMethod;

public class Software implements Company {
    private int id;
    private String name; // variable names in Java typically start lowercase

    // Constructor
    public Software(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Implementing interface method
    @Override
    public void displayName() {
        System.out.println(getClass().getSimpleName());
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
