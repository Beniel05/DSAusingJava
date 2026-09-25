import java.util.Arrays;

public class ProductOfArrayExceptItself {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };

        int[] bruteResult = productExceptSelfBrute(arr);
        System.out.println(Arrays.toString(bruteResult));
        int[] betterResult = productExceptSelfBetter(arr);
        System.out.println(Arrays.toString(betterResult));
        int[] optimizedResult = productExceptSelfOptimized(arr);
        System.out.println(Arrays.toString(optimizedResult));

    }

    public static int[] productExceptSelfOptimized(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        int prefixProduct = 1;
        for (int i = 0; i < n; i++) {
            result[i] = prefixProduct;
            prefixProduct *= arr[i];
        }

        int postfixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= postfixProduct;
            postfixProduct *= arr[i];
        }

        return result;
    }

    public static int[] productExceptSelfBetter(int[] arr) {
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n];

        // Finding left side product of each elements;
        int runningProduct = 1;
        for (int i = 0; i < n; i++) {
            left[i] = runningProduct;
            runningProduct *= arr[i];
        }

        // Finding right side product of each element;
        runningProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            right[i] = runningProduct;
            runningProduct *= arr[i];
        }

        // Finding the product array;
        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }

    public static int[] productExceptSelfBrute(int[] nums) {
        int[] resultArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i == j)
                    continue;
                product *= nums[j];
            }
            resultArray[i] = product;
        }
        return resultArray;
    }
}