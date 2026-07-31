import java.util.HashMap;

public class LongestSubArrayWithSum_K {
    public static void main(String[] args) {

        // int[] arr = {1,2,3,1,1,1,1,4,2,3};
        int[] arr = { 3, 2, 0, 0, 3 };
        int k = 3;
        int bruteResult = brute(arr, k);
        System.out.println(bruteResult);

        int[] arr1 = { 1, 2, 3, 1, 1, 1, 1 };
        int k1 = 6;
        int signedResult = optimizedBothPositiveAndNegative(arr1, k1);
        System.out.println(signedResult);

        int[] arr2 = { 1, 2, 3, 1, 1, 1, 1, 1, 1, 2, 3, 1 };
        int k2 = 6;
        int positiveResult = optimizedOnlyForPositives(arr2, k2);
        System.out.println(positiveResult);

    }

    static int optimizedOnlyForPositives(int[] arr, int k) { // O(2N)
        int maxLen = 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        int n = arr.length;

        while (right < n) {

            sum += arr[right];

            while (left <= right && sum > k) {
                sum -= arr[left];
                left++;
            }

            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;
        }

        return maxLen;
    }

    static int optimizedBothPositiveAndNegative(int[] arr, int k) { // HashMap
        // Stores: Prefix Sum -> First Index where it occurred
        HashMap<Long, Integer> preSumMap = new HashMap<>();

        // Running sum (prefix sum)
        long sum = 0;

        // Stores the maximum length found so far
        int maxLen = 0;

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {

            // Add current element to running sum
            sum += arr[i];

            // If the entire array from index 0 to i sums to k
            if (sum == k) {
                maxLen = i + 1;
            }

            // We need an old prefix sum = (current sum - k)
            long rem = sum - k;

            // If we've seen that prefix sum before...
            if (preSumMap.containsKey(rem)) {

                // Length of subarray = current index - old prefix index
                int len = i - preSumMap.get(rem);

                // Update answer if this subarray is longer
                maxLen = Math.max(maxLen, len);
            }

            // Store the current prefix sum ONLY the first time it appears
            // The earliest occurrence gives the longest subarray later
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }

        return maxLen;
    }

    static int brute(int[] arr, int k) {
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (k == sum) {
                    maxLen = Math.max(j - i + 1, maxLen);
                }
            }
        }

        return maxLen;
    }
}