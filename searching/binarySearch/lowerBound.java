/*
* Lower Bound: The first index where the element is ≥ X (not smaller than X).
* Upper Bound: The first index where the element is > X (strictly greater than X).
------------------------------
## Example
For the array: [1, 2, 4, 4, 4, 6, 7] and X = 4:

* Lower Bound: Index 2 (the first 4).
* Upper Bound: Index 5 (the 6, which is the first element greater than 4).
*/

public class lowerBound {
    public static void main(String[] args) {

        int[] array1 = { 1, 2, 2, 2, 3 };
        int x1 = 2;
        int len1 = array1.length;

        int[] array2 = { 3, 5, 8, 15, 19 };
        int x2 = 9;
        int len2 = array2.length;

        int res1 = lowerBoundFinder(array1, len1, x1);
        System.out.println("Target: " + x1 + " | Index: " + res1 + " | Element: " + array1[res1]);

        int res2 = lowerBoundFinder(array2, len2, x2);
        System.out.println("Target: " + x2 + " | Index: " + res2 + " | Element: " + array2[res2]);

    }

    static int lowerBoundFinder(int[] arr, int len, int x) {

        int left = 0;
        int right = len - 1;
        int index = len; // If not found.

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= x) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return index;

    }

}
