import java.util.Arrays;

public class SortAnArrayOf_0_1_2 {
    public static void main(String[] args) {
        
        int[] bruteArr = {0, 1, 2, 0, 1, 2, 1, 2, 0, 0, 0, 1};        
        System.out.println(Arrays.toString(brute(bruteArr)));

        // New array because we've manipulated the existing array.
        int[] betterArr = {0, 1, 2, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        System.out.println(Arrays.toString(better(betterArr)));

        int[] optimizedArr = {0, 1, 2, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        System.out.println(Arrays.toString(optimized(optimizedArr)));

    }

    static int[] optimized(int[] arr) { // O(N);
        //  Dutch National Flag (DNF) algorithm
        int low = 0;
        int mid = 0;
        int high = arr.length - 1; // pointing the last element's position

        for(int i = 0; i < arr.length; i++) {
            if(arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++; mid++;
            }
            else if(arr[mid] == 1) {
                mid++;
            } 
            else {
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            }
        }

        return arr;
    }

    static int[] better(int[] arr) { // O(2N)
        int count0 = 0, count1 = 0, count2 = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) count0++;
            else if(arr[i] == 1) count1++;
            else count2++;
        }

        int index = 0;
        while(count0-- > 0) arr[index++] = 0;
        while(count1-- > 0) arr[index++] = 1;
        while(count2-- > 0) arr[index++] = 2;

        return arr;
    }

    static int[] brute(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

}