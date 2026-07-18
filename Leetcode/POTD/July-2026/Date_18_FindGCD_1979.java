class Date_18_FindGCD_1979 {
    public static void main(String[] args) {
        /*
         * Example 1:
         * 
         * Input: nums = [2,5,6,9,10]
         * Output: 2
         * Explanation:
         * The smallest number in nums is 2.
         * The largest number in nums is 10.
         * The greatest common divisor of 2 and 10 is 2.
         */

        int[] nums = {2, 5, 6, 9, 10};
 
        int result = findGCD(nums);
        System.out.println(result);
    }

    public static int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            
            // Finding min and max;
            if(nums[i] > max) {
                max = nums[i];
            }
            if(nums[i] < min) {
                min = nums[i];
            }
        }
        
        // Finding GCD;
        while(min > 0 && max > 0) {
            if(max > min) {
                max %= min;
            } else {
                min %= max;
            }
        }

        // Returning GCD;
        if(max == 0) return min;
        else return max;

    }
}