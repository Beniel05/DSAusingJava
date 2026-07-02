package Section_1;
import java.util.Arrays;

public class SortedOrNot {

    static void findTheArrayIsSortedOrNot(int[] arr) {

        boolean isSorted = true;
        for(int i = 1; i < arr.length; i++) {

            if(arr[i - 1] > arr[i]) {
                isSorted = false;
                break;
            }
        }

        if(isSorted) {
            System.out.println("The given array: " + Arrays.toString(arr) + " is sorted!");
        } else {
            System.out.println("The given array: " + Arrays.toString(arr) + " is NOT sorted.");
        }

    }

    public static void main(String[] args) {
        
        int[] arr1 = {10, 20, 30, 30, 40, 50};

        int[] arr2 = {10, 20, 30, 40, 50, 30};
        Arrays.sort(arr2);

        int[] arr3 = {10, 20, 20, 30, 20, 40};

        findTheArrayIsSortedOrNot(arr1);
        findTheArrayIsSortedOrNot(arr2);
        findTheArrayIsSortedOrNot(arr3);

    }
}
