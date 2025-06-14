import java.util.ArrayList;
public class ArrayList_Program {

    public static void main(String[] args)
    {
        ArrayList<String> fruits = new ArrayList<String>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Custard");
        fruits.add("Mango");
        System.out.println(fruits);
        System.out.println(fruits.get(2));
        System.out.println(fruits.set(2, "Fig"));
        System.out.println(fruits);
        System.out.println(fruits.get(2));



    }

}