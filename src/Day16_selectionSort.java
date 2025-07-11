class Day16_selectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // Move from end to start, placing the largest element at position i
        for (int i = n - 1; i >= 1; i--) {
            int maxIndex = 0;

            // Find the index of the largest element in [0 to i]
            for (int j = 1; j <= i; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            // Swap the largest element with the element at position i
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        System.out.println("Original array:");
        printArray(arr);

        selectionSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}
