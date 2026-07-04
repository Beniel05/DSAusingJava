import java.util.*;

public class BubbleSort {
    public static void main(String[] args) {

        /*
         * Example:
         * Input: {13, 46, 24, 52, 20, 9}
         * Output: {9, 13, 20, 24, 46, 52}
         */

        // int[] arr1 = {13, 46, 24, 52, 20, 9};
        // int n1 = arr1.length;

        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.println("Before Sorting: " + Arrays.toString(arr1));
        System.out.println("After Sorting : " + Arrays.toString(getSorted(arr1, n1)));
    }

    static int[] getSorted(int[] arr, int n) {

        // Each outer-loop pass pushes the largest unsorted
        // element to its correct position from the end.
        for (int i = n - 1; i > 0; i--) {

            // Assume that this pass will not perform any swaps.
            // If this remains false until the end of the pass,
            // the array is already sorted.
            boolean didSwap = false;

            // Compare adjacent elements.
            for (int j = 0; j < i; j++) {

                // If left element is greater than right element,
                // they are in the wrong order.
                if (arr[j] > arr[j + 1]) {

                    // Swap them.
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    /*
                     * IMPORTANT:
                     *
                     * We found at least one pair that was out of order.
                     * Therefore the array was NOT fully sorted when
                     * this pass started.
                     *
                     * We set didSwap = true to remember that
                     * a swap happened somewhere during this pass.
                     *
                     * We don't care how many swaps happened.
                     * We only care whether at least one swap happened.
                     */
                    didSwap = true;
                }
            }

            /*
             * If didSwap is still false after checking every pair,
             * it means:
             *
             * 1. No swap was needed.
             * 2. Every element was already in the correct order.
             * 3. The array is fully sorted.
             *
             * So we can stop Bubble Sort early.
             */
            if (!didSwap) {
                break;
            }

            // System.out.println("Run: " + i);
            // to check how many times the outer loop runs.
        }

        return arr;
    }
}