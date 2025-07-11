import java.util.ArrayList;
public class Day11_TASK13 {
    public static void main(String[] args) {
        ArrayList<String> fullnames = new ArrayList<>();
        fullnames.add("Harsha Bheemisetty");
        fullnames.add("Arun Ramaji");
        fullnames.add("Kumar Arun");
        fullnames.add("Teddy Ramaji");
        fullnames.forEach(System.out::println);
    }
}