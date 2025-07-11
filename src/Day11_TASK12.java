import java.util.ArrayList;
public class Day11_TASK12
{
    public static void main(String[] args)
    {
        ArrayList<String> names = new ArrayList<>();
        names.add("Harsha");
        names.add("Arun");
        names.add("Kumar");
        names.add("Teddy");
        names.forEach(name-> System.out.println(name));
        names.forEach(System.out::println);
    }
}
