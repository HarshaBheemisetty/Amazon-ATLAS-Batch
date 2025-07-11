package Day13;

import java.util.HashMap;
public class TASK21_DifferentHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hm1 = new HashMap<>(); // default
        HashMap<String, Integer> hm2 = new HashMap<>(10); // with capacity
        HashMap<String, Integer> hm3 = new HashMap<>(hm2); // copy
        HashMap<String, Integer> hm4 = new HashMap<>(10, 0.75f); // capacity + load factor

        System.out.println("HashMaps created using different constructors");
    }
}
