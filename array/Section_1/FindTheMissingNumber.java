package Section_1;
public class FindTheMissingNumber {
    public static void main(String[] args) {
        int[] array = { 1, 2, 4, 5 }; // array will contain n - 1 elements.
        int n = 5;

        brute(array, n);
        System.out.println(better(array, n));
        optimizedSum(array, n);

        int[] arr = { 0, 1 }; // Leetcode: 268. Missing Number
        optimizedApproachUsingXOR(arr, n);

    }

    static void optimizedApproachUsingXOR(int[] a, int n) {
        int max = a.length;

        int xor1 = 0, xor2 = 0;

        for(int i = 0; i < max; i++) {
            xor1 = xor1 ^ i;
            xor2 = xor2 ^ a[i];
        }

        xor1 = xor1 ^ max;
        System.out.println("Missing number from [0 to n] is: " + (xor1 ^ xor2));
        /*
         * 268. Missing Number

         * Example 1:
         * Input: nums = [3,0,1]
         * Output: 2
         * Explanation:
         * n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is
         * the missing number in the range since it does not appear in nums.
         * 
         * Example 2:
         * Input: nums = [0,1]
         * Output: 2
         * Explanation:
         * n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is
         * the missing number in the range since it does not appear in nums.
         * 
         * Example 3:
         * Input: nums = [9,6,4,2,3,5,7,0,1]
         * Output: 8
         * Explanation:
         * n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is
         * the missing number in the range since it does not appear in nums.
         */
    }

    static void optimizedSum(int[] a, int n) {
        int sumOfN = n * (n + 1) / 2;
        int sumOfArr = 0;
        for (int i = 0; i < a.length; i++) {
            sumOfArr += a[i];
        }
        System.out.println(sumOfN - sumOfArr);
    }

    static int better(int[] a, int n) {
        int[] hashArray = new int[n + 1]; // 0-th index will be empty

        for (int i = 0; i < n - 1; i++) {
            hashArray[a[i]] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (hashArray[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    static void brute(int[] a, int n) {
        // numbers are from 1 to N;
        for (int i = 1; i < n; i++) {
            int flag = 0;
            for (int j = 0; j < n - 1; j++) {
                if (a[j] == i) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println("The Missing Number is: " + i);
            }
        }

    }
}
