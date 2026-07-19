import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;

        int[] bruteResult = brute(arr, target);
        System.out.println(Arrays.toString(bruteResult));

        int[] betterResult = better(arr, target);
        // This is the OPTIMIZED SOLUTION - when they want the indexes.
        System.out.println(Arrays.toString(betterResult));

        String optimizedResult = optimized(arr, target);
        // This will return a String saying YES or NO. (if there is 2 elements exist and sum up to the target).
        // But this involves Sorting the array.
        System.out.println(optimizedResult);
    }

    static int[] better(int[] arr, int t) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            int moreNeeded = t - arr[i];
            if(map.containsKey(moreNeeded)) {
                return new int[] {map.get(moreNeeded), i};
            }
            map.put(arr[i], i);
        }
        return new int[] {-1, -1};
    }

    static String optimized(int[] arr, int t) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;

        Arrays.sort(arr);

        while(left < right) {

            int sum = arr[left] + arr[right];

            if(sum == t) {
                return "YES";
            }
            else if(sum < t) left++;
            else right--;
        }

        return "NO";
    }

    static int[] brute(int[] arr, int t) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] + arr[j] == t) {
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {-1, -1};
    }
}
