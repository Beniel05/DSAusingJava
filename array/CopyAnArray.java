import java.util.Arrays;

public class CopyAnArray {
    public static void main(String[] args) {

        // Just copy - no extra size.

        String[] arr1 = {"One", "two", "Three"};
        String[] arr2 = arr1;
        System.out.println(Arrays.toString(arr2));


        // Copy with NEW extra length;
        
        int[] a = new int[3]; // 0, 1, 2 <=> 3
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        // a[3] = 4; // Error. InxedOutOfBound.
        System.out.println(Arrays.toString(a));
        
        a = Arrays.copyOf(a, 10);
        a[3] = 4;
        a[4] = 5;
        System.out.println(Arrays.toString(a));

        int[] b = Arrays.copyOf(a, a.length * 2);
        System.out.println("Length of int[] b = " + b.length);
        System.out.println(Arrays.toString(b));
    }
}
