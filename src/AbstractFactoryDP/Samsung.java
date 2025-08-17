package AbstractFactoryDP;

public class Samsung {
    private Samsung() {}

    public static Mobile getMobile(String model) {
        if (model.equalsIgnoreCase("s24")) {
            return new Mobile("Here is your Samsung S24");
        } else if (model.equalsIgnoreCase("s24Ultra")) {
            return new Mobile("Here is your Samsung S24 Ultra");
        }
        return new NoMobile();
    }
}
