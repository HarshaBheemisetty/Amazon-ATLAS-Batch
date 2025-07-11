import java.util.*;

public class TASK10_MergeUnsortedArrays{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size and elements of first array
        System.out.print("Enter number of elements in first list: ");
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        System.out.println("Enter " + n1 + " elements:");
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }

        // Input size and elements of second array
        System.out.print("Enter number of elements in second list: ");
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        System.out.println("Enter " + n2 + " elements:");
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        // Merge the two arrays
        int[] merged = new int[n1 + n2];
        for (int i = 0; i < n1; i++) {
            merged[i] = arr1[i];
        }
        for (int i = 0; i < n2; i++) {
            merged[n1 + i] = arr2[i];
        }

        // Sort the merged array
        Arrays.sort(merged);

        // Print the sorted merged array
        System.out.println("Merged and Sorted Array: " + Arrays.toString(merged));

        sc.close();
    }
}
