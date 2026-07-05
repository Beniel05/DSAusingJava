import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {4,2,3,5,1};

        System.out.println(Arrays.toString(arr));
        int[] result = getSorted(arr, arr.length);
        System.out.println(Arrays.toString(result));
    }

    public static int[] getSorted(int[] arr, int n) {

        for(int i = 0; i < n; i++) {
            int j = i;
            while(j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }

        return arr;
    }

}
