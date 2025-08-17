package AbstractFactoryDP;

public class MobileStore {
    private MobileStore() {}

    public static Mobile getMobile(String brand, String model) {
        if (brand.equalsIgnoreCase("Apple")) {
            System.out.println("Here are your Apple Models:");
            return Apple.getMobile(model);
        } else if (brand.equalsIgnoreCase("Samsung")) {
            System.out.println("Here are your Samsung Models:");
            return Samsung.getMobile(model);
        } else if (brand.equalsIgnoreCase("OnePlus")) {
            System.out.println("Here are your OnePlus Models:");
            return Oneplus.getMobile(model);
        }
        return new NoMobile();
    }
}
