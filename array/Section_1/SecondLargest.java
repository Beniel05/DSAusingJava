package Section_1;
import java.util.Arrays;

public class SecondLargest {
    // Second distinct largest element;

    static void findSecondLargest(int[] arr) {
        // OPTIMIZED SOLUTION;
        int largest = Integer.MIN_VALUE;
        int secondLargest = largest;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Largest: " + largest);

        if (secondLargest != Integer.MIN_VALUE) {
            System.out.println("Second Largest: " + secondLargest);
        } else {
            System.out.println("THERE IS NO DISTINCT SECOND LARGEST ELEMENT IN THE ARRAY");
        }

        System.out.println(); // empty line after getting the output
    }

    public static void main(String[] args) {

        int[] arr = { 10, 20, 40, 30, 50, 70, 50, 80, 80 };

        // OPTIMIZED SOLUTION; O(N) -> single for loop
        findSecondLargest(arr);

        int[] arr2 = { 80, 80, 80 };
        findSecondLargest(arr2);

        // BETTER SOLUTION;
        // using 2 different for loops finding both largest and second largest
        // separately.
        // O(2N) -> 2 different no nested for loops.

        // BRUTE FORCE;
        // Sort the array and the largest = arr[arr.length - 1] (last element)
        // traverse to find the second largest from the end to start.
        // O(N log N) for sorting and O(N) for traversing.

        /*
         * Arrays.sort(arr);
         * int l = arr[arr.length - 1];
         * int sl = arr[0];
         * for(int i = arr.length - 2; i >= 0; i--) {
         * if(arr[i] != l) {
         * sl = arr[i];
         * break;
         * }
         * }
         * System.out.println(l);
         * System.out.println(sl);
         */

    }

}