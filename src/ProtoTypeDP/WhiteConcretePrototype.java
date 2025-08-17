package ProtoTypeDP;

class WhiteConcretePrototype implements Colors {
    private String name;

    public WhiteConcretePrototype() {
        System.out.println("WhiteConcretePrototype default constructor is called");
        this.name = "White"; // default
    }

    public WhiteConcretePrototype(String name) {
        this.name = name;
    }

    @Override
    public Colors clone() {
        return new WhiteConcretePrototype(this.name); // deep copy
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
