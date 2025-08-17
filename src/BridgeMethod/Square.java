package BridgeMethod;

public class Square extends Shape {
    private int s;

    // Constructor
    public Square(int s, ExcalidrawAPI excalidrawAPI) {
        super(excalidrawAPI); // Pass API object to Shape
        this.s = s;
    }

    @Override
    void draw() {
        excalidrawAPI.drawSquare(s); // Access from Shape
    }
}
