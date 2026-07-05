import java.util.Arrays;

public class InsertionSort {

    // Insertion Sort takes one element at a time,
    // and inserts it into its correct position in the already sorted left part of the array.
   
    public static void main(String[] args) {

        int[] arr = { 7, 4, 1, 5, 3 };
        int n = arr.length;

        System.out.println(Arrays.toString(arr));
        int[] result = getSorted(arr, n);
        System.out.println(Arrays.toString(result));
    }

    static int[] getSorted(int[] arr, int n) {

        // Assume the first element is already sorted.
        // Start from the next element and insert it into its correct position.
        for (int i = 0; i < n; i++) {

            // j points to the current element that needs positioning.
            int j = i;

            // Move the current element left until:
            // 1. It reaches the beginning of the array, OR
            // 2. The element on its left is smaller or equal.
            while (j > 0 && arr[j - 1] > arr[j]) {

                // Swap the current element with the larger element on its left.
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;

                // Continue checking further left.
                j--;
            }

            /*
             * After each iteration:
             *
             * i = 0 -> [7] is sorted
             * i = 1 -> [4, 7] is sorted
             * i = 2 -> [1, 4, 7] is sorted
             * i = 3 -> [1, 4, 5, 7] is sorted
             * i = 4 -> [1, 3, 4, 5, 7] is sorted
             *
             * The left portion (0 to i) is always sorted.
             */
        }

        return arr;
    }
}