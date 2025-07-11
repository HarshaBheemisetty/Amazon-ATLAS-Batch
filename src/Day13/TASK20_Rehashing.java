package Day13;
import java.util.HashMap;
public class TASK20_Rehashing {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>(4, 0.75f);

        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.put(4, "D");
        map.put(5, "E"); // triggers rehashing internally

        System.out.println(map);
    }
}
