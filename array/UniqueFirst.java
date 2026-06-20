import java.util.Arrays;

public class UniqueFirst {
    public static int removeDuplicate(int[] arr) {
        System.out.println("=== Initial Array ===");
        System.out.println(Arrays.toString(arr));

        int i = 0;
        for(int j = 1; j < arr.length; j++) {
            if(arr[j] != arr[i]) {
                i++; // to add in the next index 
                arr[i] = arr[j];
            }
        }

        System.out.println("=== Array After Iteration ===");
        System.out.println(Arrays.toString(arr));
        System.out.println("Number of unique elements: " + (i + 1));

        return i+1; // returing unique elements count for re-use-ability
    }

    public static void main(String[] args) {
        int[] array = {1,2,2,2,3,3,4,5};
        int totalUniqueLength = removeDuplicate(array);
        
        for(int i = 0; i < totalUniqueLength; i++) {
            // getting all the unique elements from the array after the function process and changed.
            System.out.print(array[i] + " ");
        }
    }
}
