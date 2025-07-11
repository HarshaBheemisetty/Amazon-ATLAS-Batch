import java.util.Arrays;

public class MergeArrays {
    public static void main(String[] args) {
        int[] array1 = {1, 3, 5};
        int[] array2 = {2, 4, 6};

        // Create a new array to hold both
        int[] merged = new int[array1.length + array2.length];

        // Copy elements from first array
        for (int i = 0; i < array1.length; i++) {
            merged[i] = array1[i];
        }

        // Copy elements from second array
        for (int i = 0; i < array2.length; i++) {
            merged[array1.length + i] = array2[i];
        }

        // Print merged array
        System.out.println("Merged Array: " + Arrays.toString(merged));
    }
}
