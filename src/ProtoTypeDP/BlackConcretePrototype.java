package ProtoTypeDP;

public class BlackConcretePrototype implements Colors {
    private String name;

    public BlackConcretePrototype() {
        System.out.println("BlackConcretePrototype default constructor is called");
        this.name = "Black";
    }

    public BlackConcretePrototype(String name) {
        this.name = name;
    }

    @Override
    public Colors clone() {
        return new BlackConcretePrototype(this.name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
