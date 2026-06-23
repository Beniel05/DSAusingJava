import java.util.Arrays;
import java.util.Scanner;

public class DemoHash {

    /*
     * Array Hashing
     * - Fast O(1) access and frequency counting.
     * - Requires O(max) extra space.
     * - Suitable only when the value range is small.
     * - Large ranges (10^8+) may cause OutOfMemoryError.
     * - Use HashMap for sparse or very large ranges.
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter value for index " + i + ": ");
            arr[i] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // this sizing may raise memory exception when the size is larger like 10^7
        int[] hash = new int[max + 1];

        for (int i = 0; i < size; i++) {
            hash[arr[i]] += 1;
        }

        // System.out.println(Arrays.toString(arr));
        // System.out.println(Arrays.toString(hash));

        System.out.print("Enter total number of times to find occurence: ");
        int total = sc.nextInt();

        while (total-- > 0) {
            System.out.println("Only upto " + max + " number is accepted!");
            int Number = sc.nextInt();
            if (Number <= max)
                System.out.println(Number + " appeared " + hash[Number] + " times.");
            else
                System.out.println("Array out of bound. The Highest number in the Hash array is: " + max);
        }

    }
    /*
     * Hashing using an array:
     * 
     * Time Complexity:
     * - Insertion: O(1)
     * - Search: O(1)
     * 
     * Space Complexity:
     * - O(max)
     * 
     * Note:
     * This approach is efficient only when the maximum value is reasonably small.
     * Creating a large hash array like:
     * 
     * int[] hash = new int[max + 1];
     * 
     * may cause OutOfMemoryError if 'max' is very large
     * (e.g., 10^8 or higher), because arrays are allocated on the Heap.
     * 
     * Memory required:
     * int[] -> 4 bytes per element
     * boolean[] -> 1 byte per element (typically)
     * 
     * Example:
     * int[10^7] ≈ 40 MB
     * int[10^8] ≈ 400 MB
     * 
     * For large ranges with sparse data, prefer HashMap instead of an array.
     */
}