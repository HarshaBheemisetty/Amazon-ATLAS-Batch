public class Day16_QuickSort {

    public void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            // Recursively sort elements before partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    // This method takes last element as pivot, places the pivot element at its correct position in sorted array,
    // and places all smaller (than pivot) to left of pivot and all greater elements to right of pivot
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choosing the last element as pivot
        int i = (low - 1); // Index of the smaller element; keeps track of where to place the next smaller-than-pivot number.


        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Utility method to print the array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Driver code to test the QuickSort implementation
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        Day16_QuickSort qs = new Day16_QuickSort();
        System.out.println("Original array:");
        printArray(arr);

        qs.sort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}