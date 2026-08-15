import java.util.ArrayList;
import java.util.Collections;

public class Leaders {
    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};

        System.out.println(brute(arr)); // O(N^2)
        System.out.println(optimized(arr)); // O(N)

    }

    static ArrayList<Integer> optimized(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        int maxRight = 0;

        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] >= maxRight) {
                result.add(arr[i]);
                maxRight = arr[i];
            }
        }

        // return result; // reverse order as be traverse.
        Collections.reverse(result);
        return result;

    }

    static ArrayList<Integer> brute(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            boolean isLeader = true;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] < arr[j]) {
                    isLeader = false;
                    break;
                }
            }
            if(isLeader) result.add(arr[i]);
        }
        
        return result;
    }
}
