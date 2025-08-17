package ProtoTypeDP;
public class ClientPrototype {
    public static void main(String[] args) {
        // Create original White
        Colors white1 = new WhiteConcretePrototype("Bright White");

        // Clone it
        Colors white2 = white1.clone();

        // Modify clone name
        white2.setName("Soft White");

        System.out.println("Original White: " + white1.getName());
        System.out.println("Cloned White:   " + white2.getName());

        // Create original Black
        Colors black1 = new BlackConcretePrototype("Dark Black");

        // Clone and modify
        Colors black2 = black1.clone();
        black2.setName("Matte Black");

        System.out.println("Original Black: " + black1.getName());
        System.out.println("Cloned Black:   " + black2.getName());
    }
}
