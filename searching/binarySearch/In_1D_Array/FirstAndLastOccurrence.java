import java.util.Arrays;

public class FirstAndLastOccurrence {

    public static int[] searchRange(int[] nums, int target) {
        int firstOccurrence = -1;
        int lastOccurrence = -1;

        int n = nums.length;
        int left = 0;
        int right = n - 1;

        // Finding Left most index
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                firstOccurrence = mid; // Updating the value - Only when it's equal
                right = mid - 1;
            } else if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // Resetting Search Space
        left = 0;
        right = n - 1;
        // Finding Right most index
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                lastOccurrence = mid; // Updating the value - Only when it's equal
                left = mid + 1;
            } else if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return new int[] { firstOccurrence, lastOccurrence };
    }

    public static void main(String[] args) {

        int[] array = { 2, 4, 5, 5, 5, 5, 7, 8, 8, 10 };
        // OP:                2    ,   5
        int target = 5;

        int[] res = searchRange(array, target);
        System.out.println(Arrays.toString(res));
    }
}
