import java.util.HashMap;

public class MajorityElement1 {
    public static void main(String[] args) {

        // int[] arr = { 2, 2, 3, 3, 1, 2, 2, 3, 3, 3, 3 };
        int[] arr = { 2, 2, 3, 3, 1, 2, 2 };

        System.out.println(brute(arr));
        System.out.println(better(arr));
        System.out.println(optimized(arr));

    }

    static int optimized(int[] arr) {
        // Boyer–Moore Majority Vote Algorithm
        // (AKA) Moore's voting algorithm

        int element = 0;
        int count = 0;

        for(int i = 0; i < arr.length; i++) {
            if(count == 0) {
                element = arr[i];
                count++;
            }
            if(arr[i] == element) {
                count++;
            } else {
                count--;
            }
        }

        int count1 = 0;
        for(int i = 0; i < arr.length; i++) {
            if(element == arr[i]) {
                count1++;
            }
        }

        if(count1 > arr.length / 2) return element;
        else return -1;

    }

    static int better(int[] arr) { // HashMap

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for(int key : map.keySet()) {
            int more = arr.length / 2;
            if(map.get(key) > more) {
                return key;
            }
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
