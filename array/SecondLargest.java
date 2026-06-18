import java.util.Arrays;

public class SecondLargest {
    // Second distinct largest element;

    public static void main(String[] args) {

        int[] arr = { 10, 20, 40, 30, 50, 70, 50, 80, 80 };

        int largest = Integer.MIN_VALUE;
        int secondLargest = largest;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Largest: " + largest);
        System.out.println("Second Largest: " + secondLargest);
    }

}