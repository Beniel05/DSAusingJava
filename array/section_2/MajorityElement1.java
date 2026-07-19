import java.util.HashMap;

public class MajorityElement1 {
    public static void main(String[] args) {

        int[] arr = { 2, 2, 3, 3, 1, 2, 2 };

        System.out.println(brute(arr));
        System.out.println(better(arr));

    }

    static int better(int[] arr) { // HashMap

        HashMap<Integer, Integer> map = new HashMap<>();

        
        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], );
        }

        return -1;
    }

    static int brute(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            int count = 0;

            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count > arr.length / 2) {
                return arr[i];
            }
        }
        return -1;
    }

    static int myBrute(int[] arr) {

        // We can also skip this majorityElement - and use arr[i];
        int majorityElement = 0;
        int maxCount = 0;

        for (int i = 0; i < arr.length; i++) {
            int currentElement = arr[i];
            int currentCount = 0;
            for (int j = 0; j < arr.length; j++) {
                if (currentElement == arr[j]) {
                    currentCount++;
                }
            }
            if (currentCount > maxCount) {
                majorityElement = currentElement;
                maxCount = currentCount;
            }
        }

        // Majority element should occur more then half times * of the size of the
        // array.
        if (maxCount > (arr.length / 2)) {
            return majorityElement;
        } else {
            return -1;
        }
    }
}
