package AbstractFactoryDP;

public class Apple {
    private Apple() {} // prevent object creation

    public static Mobile getMobile(String model) {
        if (model.equalsIgnoreCase("iphone16")) {
            return new Mobile("Here is your iPhone 16");
        } else if (model.equalsIgnoreCase("iphone16MaxPro")) {
            return new Mobile("Here is your iPhone 16 Max Pro");
        }
        return new NoMobile();
    }
}
