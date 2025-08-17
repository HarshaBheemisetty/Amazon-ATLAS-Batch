package CompositeMethod;

public class HR implements Company {
    private int id;
    private String name;

    // Constructor
    public HR(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Implementing the Company interface method
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
