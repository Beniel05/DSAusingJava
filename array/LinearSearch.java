import java.util.ArrayList;

public class LinearSearch {

    // Problem Statement:
    // Given an array and a target element, find whether the target
    // exists in the array. If found, return its index; otherwise return -1.

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 4, 4 };
        int element = 4;

        int result1 = returnTheFirstOccurenceIndex(arr, element);
        int result2 = returnTheLastOccurenceIndex(arr, element);
        ArrayList<Integer> result3 = returnAllTheOccurenceIndexes(arr, element);

        System.out.println("First Occurrence Index : " + result1);
        System.out.println("Last Occurrence Index  : " + result2);
        System.out.println("All Occurrence Indexes : " + result3);
    }

    // Notes:
    // 1. This implementation returns the first occurrence when searching
    // from left to right.

    public static int returnTheFirstOccurenceIndex(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // 2. To find the last occurrence, traverse the array from
    // arr.length - 1 down to 0.

    public static int returnTheLastOccurenceIndex(int[] arr, int target) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    // 3. To find all occurrences, store the matching indexes
    // in an ArrayList<Integer> and return the list.

    public static ArrayList<Integer> returnAllTheOccurenceIndexes(int[] arr, int target) {
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                indexes.add(i);
            }
        }
        return indexes;
    }
}
