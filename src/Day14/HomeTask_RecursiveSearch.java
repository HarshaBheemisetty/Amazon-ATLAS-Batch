package Day14;

public class HomeTask_RecursiveSearch {

    // Recursive function to search for an element in an array
    public static int search(int[] arr, int target, int index) {
        // Base case: if index exceeds array length
        if (index >= arr.length) {
            return -1; // element not found
        }

        // If current element matches the target
        if (arr[index] == target) {
            return index;
        }

        // Recursive case: search in the remaining part of the array
        return search(arr, target, index + 1);
    }

    public static void main(String[] args) {
        int[] arr = {5, 8, 12, 7, 20};
        int target = 7;

        int result = search(arr, target, 0); // Start from index 0

        if (result != -1) {
            System.out.println("Element " + target + " found at index " + result);
        } else {
            System.out.println("Element " + target + " not found.");
        }
    }
}
