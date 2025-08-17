package AbstractFactoryDP;

public class Oneplus {
    private Oneplus() {}

    public static Mobile getMobile(String model) {
        if (model.equalsIgnoreCase("oneplus12")) {
            return new Mobile("Here is your OnePlus 12");
        } else if (model.equalsIgnoreCase("oneplus12R")) {
            return new Mobile("Here is your OnePlus 12R");
        }
        return new NoMobile();
    }
}
