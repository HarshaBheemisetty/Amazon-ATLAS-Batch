
public class Day16_InsertionSort {

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int next = arr[i];         // element to be positioned
            int j = i - 1;

            while (j >= 0 && arr[j] > next) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = next;
        }
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};

        System.out.println("Original array:");
        printArray(arr);

        insertionSort(arr);

        System.out.println("Sorted array (Ascending):");
        printArray(arr);
    }
}
