package FlyWeightMethod;

public class Main {
    private static final String[] colors = {"Red", "Green", "Blue"};

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            Shape circle = ShapeFactory.getCircle(colors[i % colors.length]);
            int x = (int) (Math.random() * 100);
            int y = (int) (Math.random() * 100);
            circle.draw(x, y); // extrinsic state: position
        }
    }
}
