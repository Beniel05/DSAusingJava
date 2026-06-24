import java.util.Arrays;

public class SecondLargestAndSmallest {
    // O(n) time and O(1) space.

    public static void main(String[] args) {

        int[] array = { 1, 2, 3, 4, 5, 6, 7 };

        int sMin = findSecondSmallest(array);
        int sMax = findSecondLargest(array);

        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Second Smallest: " + sMin);
        System.out.println("Second Largest: " + sMax);
    }

    static int findSecondSmallest(int[] arr) {
        int firstMin = Integer.MAX_VALUE;
        int secondMin = firstMin;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < firstMin) {
                secondMin = firstMin;
                firstMin = arr[i];
            } else if (arr[i] > firstMin && arr[i] < secondMin) {
                secondMin = arr[i];
            }
        }

        return secondMin;
    }

    static int findSecondLargest(int[] arr) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = firstMax;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > firstMax) {
                secondMax = firstMax;
                firstMax = arr[i];
            } else if (arr[i] < firstMax && arr[i] > secondMax) {
                secondMax = arr[i];
            }
        }

        return secondMax;
    }

}
