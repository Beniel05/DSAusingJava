import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {

        int[] arr = { 45, 12, 89, 5, 23 };
        int n = arr.length;

        System.out.println(Arrays.toString(arr));
        int[] result = getSorted(arr, n);
        System.out.println(Arrays.toString(result));
    }

    static int[] getSorted(int[] arr, int n) {

        for (int i = n - 1; i > 0; i--) { // from last element's index to 1st index 
        // [If the array has 5 elements - the number of steps to get sorted will be 4]
            boolean didSwap = false;
            
            // 0 to last, 0 to last - 1, 0 to last - 2,...
            for (int j = 0; j < i; j++) { // from 0th to nth element's index - 1
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    didSwap = true;
                }
            }
            if (!didSwap) { // If all all in the ascending sorted order
                // didSwap will stay as false. So we can skip our outer loop entirely.
                // And can have O(N) in the best case.
                break;
            }
        }
        return arr;
    }

}
