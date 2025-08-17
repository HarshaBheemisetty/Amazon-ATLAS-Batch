public class BinarySearch {

    // Repeat until the pointers low and
    // high meet each other
    public static int binarySearch(int[] arr, int target, int low, int high) {
        while (low <= high) {
            int mid = low + high / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 9, 10};
        int n = arr.length;
        int target = 7;
        int low = 0;
        int high = n;
        int index = binarySearch(arr, target, low, high);
        System.out.println(index);
    }
}