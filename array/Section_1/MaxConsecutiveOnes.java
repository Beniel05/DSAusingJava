public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] a = {1,1,0,1,1,1}; // 3
        int[] b = {1,0,1,1,0,1}; // 2

        System.out.println(findMaxConsecutiveOnes(a));
        System.out.println(findMaxConsecutiveOnes(b));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                if (count > maxCount) {
                    maxCount = count;
                }
            } else {
                count = 0;
            }
        }
        return maxCount;
    }
}