import java.util.Arrays;

class MoveZerosToRightArray {
    public static void main(String[] args) {
        int[] array = {1,0,2,0,3,0,0,4,5,6};

        int[] result = moveZeroToTheEnd(array);
        System.out.println(Arrays.toString(result));
    }

    public static int[] moveZeroToTheEnd(int[] arr) {
        int i = 0;
        for(int j = 0; j < arr.length; j++) {
            if(arr[j] != 0) {
                arr[i] = arr[j];
                i++;
            }
        }
        for(int j = i + 1; j < arr.length; j++) {
            arr[j] = 0;
        }
        return arr;
    }
}