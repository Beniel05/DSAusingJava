import java.util.Arrays;

public class Date_26_MaxProOf_3Nums_628 {
    public static void main(String[] args) {

        /* 628. Maximum Product of Three Numbers */
        
        /*
         * Example 1:
         * Input: nums = [1,2,3]
         * Output: 6
         * 
         * Example 2:
         * Input: nums = [1,2,3,4]
         * Output: 24
         * 
         * Example 3:
         * Input: nums = [-1,-2,-3]
         * Output: -6
         */

        int[] nums = {-2, -5, -10, 1};
        System.out.println(maximumProduct(nums));
        // Have to take -> -10 * -5 * 1

        // Why +1 instead of -2 ? 
        // -10 * -5 = +50.
        // +50 * -2 = -100
        // But, +50 * +1 = +50.
        // [ 50 > -100].
        // That's why two smallest negative numbers (-10 < -1) and one positive number / Top 3 largest numbers.
    }

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        return Math.max(
                // If all are positive integers.
                nums[n - 1] * nums[n - 2] * nums[n - 3],

                // If mostly negatives and few positive makes the high product;
                nums[0] * nums[1] * nums[n - 1]
                // Two smallest negative and one positive -> (-100 < -1)

                // Why one positive ?
                // -60000 < 1.
                // - * - = + (so two negatives) and one highest positive.
        );
    }
}
