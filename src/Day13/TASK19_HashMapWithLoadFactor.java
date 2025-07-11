package Day13;

import java.util.HashMap;
public class TASK19_HashMapWithLoadFactor {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>(10, 0.75f);
        hm.put("A", 1);
        hm.put("B", 2);
        System.out.println(hm);
    }
}
