package Day13;
import java.util.HashMap;

public class TASK18_CopyMap {
    public static void main(String[] args) {
        HashMap<String, Integer> original = new HashMap<>();
        original.put("Arun", 10);
        original.put("Teddy", 20);

        HashMap<String, Integer> copy = new HashMap<>(original);
        System.out.println("Copied Map: " + copy);
    }
}
