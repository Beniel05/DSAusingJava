import java.util.Arrays;

class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 29, 10, 14, 37, 13 };
        int n = arr.length;
        
        System.out.println(Arrays.toString(arr));
        int[] result = getSorted(arr, n);
        System.out.println(Arrays.toString(result));
    }

    static int[] getSorted(int[] arr, int n) {
        for(int i = 0; i < n - 1; i++) {
            int min = i;
            for(int j = i + 1; j < n; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }
}