import java.util.Arrays;

class SelectionSort {
    public static void main(String[] args) {
        /*
         * Example 1:
         * Input: N = 6, array[] = {13,46,24,52,20,9}
         * Output: 9,13,20,24,46,52
         * Explanation: After sorting the array is: 9, 13, 20, 24, 46, 52
         * 
         * Example 2:
         * Input: N=5, array[] = {5,4,3,2,1}
         * Output: 1,2,3,4,5
         * Explanation: After sorting the array is: 1, 2, 3, 4, 5
         */

        int[] arr1 = { 13, 46, 24, 52, 20, 9 };
        int n1 = arr1.length;

        int[] arr2 = { 5, 4, 3, 2, 1 };
        int n2 = arr2.length;

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(getSorted(arr1, n1)));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(getSorted(arr2, n2)));

    }

    static int[] getSorted(int[] arr, int n) {

        // Move through the array one position at a time.
        // After each pass, the smallest element from the
        // unsorted portion is placed in its correct position. (ie. i-th position ASC)
        for (int i = 0; i < n - 1; i++) {

            // Assume the current position contains the minimum element.
            int min = i;

            // Search for the actual minimum element in the
            // remaining unsorted portion of the array.
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            // Swap the current element with the minimum element found.
            // If min == i, this simply swaps the element with itself.
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

        return arr;
    }
}