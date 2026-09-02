public class findXinSortedArray {
    public static void main(String args[]) {

        int[] nums = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int len = nums.length;
        int find = 23; // 5

        int result1 = iterativeMethod(nums, len, find);
        System.out.println(result1);

        int result2 = recursiveMethod(nums, 0, len - 1, find);
        System.out.println(result2);

    }

    static int iterativeMethod(int[] arr, int n, int target) {
        int left = 0;
        int right = n - 1; // last index = length - 1.

        while(left <= right) {
            int mid = (left + right) / 2;

            if(arr[mid] == target) return mid;
            else if(arr[mid] > target) right = mid - 1;
            else left = mid + 1;
        }

        return -1;
    }

    static int recursiveMethod(int[] arr, int left, int right, int target) {

        if(left > right) return -1;
        
        int mid = (left + right) / 2;

        if(arr[mid] == target) return mid;
        else if(arr[mid] >= target) {
            // right --
            return recursiveMethod(arr, left, mid - 1, target);
        } else {
            // left ++
            return recursiveMethod(arr, mid + 1, right, target);
        }

    }
}
