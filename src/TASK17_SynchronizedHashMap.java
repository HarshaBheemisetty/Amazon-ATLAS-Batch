import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class TASK17_SynchronizedHashMap {
    public static void main(String[] args) {
        // ✅ Make HashMap synchronized
        Map<String, Integer> ht = Collections.synchronizedMap(new LinkedHashMap<>());

        ht.put("Anitha", 101);
        ht.put("Kavitha", 102);
        ht.put("Meera", 103);
        ht.put(null, 105);
        ht.put(null, 106);  // Overwrites previous null key

        // ✅ Use synchronized block while iterating
        synchronized (ht) {
            for (Map.Entry<String, Integer> e : ht.entrySet()) {
                System.out.println(e.getKey() + " = " + e.getValue());
            }
        }
    }
}
