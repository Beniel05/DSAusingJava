/*
* In binary search, floor and ceil (ceiling) refer to finding the closest boundary values for a target number within a sorted array: 

* Floor: The largest number in the array that is less than or equal to the target (≤ target).
* Ceil: The smallest number in the array that is greater than or equal to the target (≥ target).
------------------------------
## Quick Example => Given a sorted array: int[] arr = {1, 3, 5, 8, 10};

* If target is 5:
* Floor = 5 (exact match)
* Ceil = 5 (exact match)

* If target is 7:
* Floor = 5 (largest number ≤ 7)
* Ceil = 8 (smallest number ≥ 7) 

## How They Work in Binary Search
If the target is not found during the standard while (low <= high) loop: 
* Floor is the element at index high.
* Ceil is the element at index low.
*/

public class FloorAndCeil {
    
    static int findFloor(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int index = -1; // Default. 

        while(left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index;
    }

    static int findCeil(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int index = arr.length; // Default

        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] >= target) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        
        int[] array = {10, 20, 30, 40, 50};
        int x = 25;

        int floorResultIndex = findFloor(array, x);
        int ceilResultIndex = findCeil(array, x);

        System.out.println("Target: " + x);
        System.out.println("Floor index: " + floorResultIndex + " | Element: " + array[floorResultIndex]);
        System.out.println("Ceil index: " + ceilResultIndex + " | Element: " + array[ceilResultIndex]);

    }

}
