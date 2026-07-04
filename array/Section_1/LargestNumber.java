public class LargestNumber {
    public static void main(String[] args) {
        
        int[] arr = {10, 50, 30, 100, 60, 33};

        int Max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > Max) Max = arr[i];
        }

        System.out.println(Max);

    }
}
