package Section_1;
import java.util.Arrays;

public class UniqueFirst {
    /*
     * Two Pointer Approach
     *
     * i -> points to last unique element
     * j -> scans the array
     *
     * If arr[j] is different,
     * move i forward and place arr[j].
     *
     * Unique elements will be stored
     * from index 0 to i.
     *
     * TC: O(N)
     * SC: O(1)
     */

    public static int removeDuplicate(int[] arr) {
        System.out.println("=== Initial Array ===");
        System.out.println(Arrays.toString(arr));

        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i]) {
                i++; // to add in the next index
                arr[i] = arr[j];
            }
        }

        System.out.println("=== Array After Iteration ===");
        System.out.println(Arrays.toString(arr));
        System.out.println("Number of unique elements: " + (i + 1));

        return i + 1; // returing unique elements count for re-use-ability
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 2, 2, 3, 3, 4, 5 };
        int totalUniqueLength = removeDuplicate(array);

        for (int i = 0; i < totalUniqueLength; i++) {
            // getting all the unique elements from the array after the function process and
            // changed.
            System.out.print(array[i] + " ");
        }
    }

    /*
     * [1,2,2,2,3,3,4,5]
     * 
     * i = 0
     * 
     * j = 1 -> 2 != 1
     * i = 1
     * 
     * [1,2,2,2,3,3,4,5]
     * 
     * j = 2 -> duplicate
     * 
     * j = 3 -> duplicate
     * 
     * j = 4 -> 3 != 2
     * i = 2
     * arr[2] = 3
     * 
     * [1,2,3,2,3,3,4,5]
     * 
     * j = 5 -> duplicate
     * 
     * j = 6 -> 4 != 3
     * i = 3
     * arr[3] = 4
     * 
     * [1,2,3,4,3,3,4,5]
     * 
     * j = 7 -> 5 != 4
     * i = 4
     * arr[4] = 5
     * 
     * [1,2,3,4,5,3,4,5]
     */
}
