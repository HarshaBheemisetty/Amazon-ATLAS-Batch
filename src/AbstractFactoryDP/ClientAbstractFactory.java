package AbstractFactoryDP;
public class ClientAbstractFactory {
    public static void main(String[] args) {
        Mobile m1 = MobileStore.getMobile("Apple", "iphone16");
        m1.getDesc();

        Mobile m2 = MobileStore.getMobile("Samsung", "s24Ultra");
        m2.getDesc();

        Mobile m3 = MobileStore.getMobile("OnePlus", "oneplus12R");
        m3.getDesc();

        Mobile m4 = MobileStore.getMobile("Nokia", "1100");
        m4.getDesc(); // Invalid case
    }
}
