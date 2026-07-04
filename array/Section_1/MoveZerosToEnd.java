import java.util.ArrayList;
import java.util.Arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        
        int[] array1 = {1,0,2,3,2,0,0,4,5,1};
        int[] array2 = {1,0,2,3,2,0,0,4,5,1};
        int[] array3 = {1,0,2,3,2,0,0,4,5,1};
        System.out.println("Initial Array: " + Arrays.toString(array1));
        // {1,2,3,2,4,5,1,0,0,0};

        int[] firstResult = bruteReturningAnotherArray(array1);
        int[] secondResult = bruteUsingArrayList(array2);
        int[] OptimizedResult = optimizedMethod(array3);
        // THIS OPTIMIZED NEED ANOTHER LOOP TO ADD ZERO IN THE END!.

        System.out.println(Arrays.toString(firstResult));
        System.out.println(Arrays.toString(secondResult));
        System.out.println(Arrays.toString(OptimizedResult));


    }

    static int[] optimizedMethod(int[] arr) {
        int j = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                arr[j] = arr[i];
                j++;
            }
        }
        while(j < arr.length) {
            arr[j] = 0;
            j++;
        }
        return arr;
    }

    static int[] bruteUsingArrayList(int[] arr) {
        // Step 1: Storing all the non - zero numbers in the temp List;
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) { // O(N)
            if(arr[i] != 0) {
                temp.add(arr[i]);
            }
        }
        // Step 2: Put all the temp elements(non-zero) into the original arr;
        for(int i = 0; i < temp.size(); i++) { // O(X) - X numbers
            arr[i] = temp.get(i);
        }
        // Step 3: Fill the rest of the space with zeros in the array;
        for(int i = temp.size(); i < arr.length; i++) { // O(N - X)
            arr[i] = 0;
        } 

        return arr;
    }

    // ANOTHER SOLUTION: 
    // RETURNING THE NEW ARRAY;

    static int[] bruteReturningAnotherArray(int[] arr) {
        int[] bruteArr = new int[arr.length]; // new array will be filled with { 0, 0, 0s }
        int pointer = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                bruteArr[pointer] = arr[i];
                pointer++;
            }
        }
        return bruteArr;
        // OR -> arr = bruteArr -> return arr;
    }

}
