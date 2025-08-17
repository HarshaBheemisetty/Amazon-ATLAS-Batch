package BridgeMethod;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bridge Method Design Pattern - Structural DP!");
        ExcalidrawAPI obj1 = new DrawingFrame();
        ExcalidrawAPI obj2 = new DrawingPicture();

        Shape square = new Square(5, obj1);
        Shape square2 = new Square(5, obj2);


        square.draw();
    }
}