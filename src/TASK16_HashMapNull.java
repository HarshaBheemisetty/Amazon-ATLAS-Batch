import java.util.*;
import java.util.HashMap;
class TASK16_HashMapNull {
    public static void main(String[] args) {
        HashMap<String, Integer> ht = new HashMap<>();
        ht.put("Anitha", 101);
        ht.put("Kavitha", 102);
        ht.put("Meera", 103);
        ht.put(null, 105);
        ht.put(null, 106);
        // use  get method of Ht
        for (Map.Entry<String, Integer> e : ht.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());
    }
}
