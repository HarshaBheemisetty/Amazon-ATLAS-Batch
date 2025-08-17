interface Shape
{
    double area();
}
class Square implements Shape {
    private int height;

    public Square(int height) {
        this.height = height;
    }

    @Override
    public double area() {
        return height * height;
    }
}
class Circle implements Shape {
    private int r;

    public Circle(int r) {
        this.r = r;
    }

    @Override
    public double area() {
        return Math.PI * r * r;
    }
}
class AreaComparer {
    public int compareArea(Shape s1, Shape s2) {
        return Double.compare(s1.area(), s2.area());
    }
}
public class Day20_OCP1 {
    public static void main(String[] args) {
        Shape square = new Square(4);  // area = 16
        Shape circle = new Circle(3);  // area = ~28.27

        AreaComparer comparer = new AreaComparer();
        int result = comparer.compareArea(square, circle);

        if (result > 0) {
            System.out.println("Square has a larger area.");
        } else if (result < 0) {
            System.out.println("Circle has a larger area.");
        } else {
            System.out.println("Areas are equal.");
        }
    }
}


