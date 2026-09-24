public class A1_FindMaxSum {
    public static void main(String[] args) {
        int[] arr = {2, -1, 3, 4};

        int res1 = brute(arr);
        System.out.println(res1);

        int res2 = better(arr);
        System.out.println(res2);

        int res3 = optimized(arr);
        System.out.println(res3);
    }

    public static int optimized(int[] arr) {
        int maxSum = arr[0];
        int currentSum = arr[0];
        for(int i = 1; i < arr.length; i++) {
            currentSum += arr[i];
            if(arr[i] > currentSum) currentSum = arr[i];
            // if(currentSum > maxSum) maxSum = currentSum;
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    public static int better(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        for(int start = 0; start < arr.length; start++) {
            int sum = 0;
            for(int end = start; end < arr.length; end++) {
                sum += arr[end];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    public static int brute(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        for(int start = 0; start < arr.length; start++) {
            for(int end = start; end < arr.length; end++) {
                int sum = 0;
                for(int k = start; k <= end; k++) {
                    sum += arr[k];
                }
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }
}
