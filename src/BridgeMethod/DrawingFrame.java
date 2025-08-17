package BridgeMethod;

// concrete Implementor DrawingFrame.. DrawingPicture
public class DrawingFrame implements ExcalidrawAPI {
    @Override
    public void drawSquare(int s) {
        System.out.println("draw square in Drawing frame using Excalidraw with side "+ s);
    }
}