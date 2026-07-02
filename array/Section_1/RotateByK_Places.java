package Section_1;
import java.util.Arrays;

public class RotateByK_Places {
    public static void main(String[] args) {

        // left shift the array by 3 places;
        int k = 3;

        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

        // bruteForceLeftRotateByK_Places(arr, k);
        OptimizedLeftRotateByK_Places(arr, k);

        // reverse(arr, 0, k);

    }

    public static void bruteForceLeftRotateByK_Places(int[] arr, int k) {
        System.out.println("Arrays before: " + Arrays.toString(arr));

        k = k % arr.length; // Any rotation equal to the length of the array
        // will give you the original array position after rotating.
        // So we just need to rotate the array by arr.length - 1 position. (here it's 6)

        int[] temp = new int[k]; // eg: arr size = 7 in this eg.
        // One complete 7 rotation will become the initial array.
        // So we just need to rotate upto 6 times

        for (int i = 0; i < temp.length; i++) {
            // Taking the first k elements in this array. To track and store back to array
            // in the end.
            temp[i] = arr[i];
        }

        for (int i = k; i < arr.length; i++) {
            // left shifting other elements up front
            arr[i - k] = arr[i];
        }

        for (int i = 0; i < k; i++) {
            arr[arr.length - k + i] = temp[i];
        }

        System.out.println("Arrays after: " + Arrays.toString(arr));
    }

    public static void OptimizedLeftRotateByK_Places(int[] arr, int k) {
        k %= arr.length;
        // arr = [1,2,3,4,5,6,7];
        reverse(arr, 0, k - 1); 
        // [3,2,1,4,5,6,7];
        reverse(arr, k, arr.length - 1);
        // [3,2,1,7,6,5,4];
        reverse(arr, 0, arr.length - 1);
        // [4,5,6,7,1,2,3];
        System.out.println(Arrays.toString(arr));
    }

    public static void reverse(int[] arr, int start, int end) {
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

}

/* brute force of left shift element by k places;
 * k = k % arr.length;
 * int[] temp = new int[k];
 * for(int i = 0; i < k; i++) {
 * temp[i] = arr[i];
 * }
 * for(int i = k; i < arr.length; i++) {
 * arr[i - k] = arr[i];
 * }
 * for(int i = arr.length - k; i < arr.length; i++) {
 * arr[i] = temp[i - arr.length + k];
 * }
 * 
 * System.out.println(Arrays.toString(arr));
 * System.out.println(Arrays.toString(temp));
 */