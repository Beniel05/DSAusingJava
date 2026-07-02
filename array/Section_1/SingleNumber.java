package Section_1;
public class SingleNumber {
    public static void main(String[] args) {
        int[] array = { 1, 1, 2, 2, 3, 4, 4, 5, 5 };

        System.out.println(brute(array));

        System.out.println(better(array)); 
        // better approach used here - only work for positive integers. For negative integers we need to use HashMap.
        // because we use the index as the number here.

        System.out.println(optimizedXOR(array));
    }

    static int optimizedXOR(int[] arr) {
        int xor1 = 0;
        for(int i = 0; i < arr.length; i++) {
            xor1 = xor1 ^ arr[i];
        }
        return xor1;
    }

    static int better(int[] arr) {
        int max = -1;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) max = arr[i];
        }

        int[] hashArr = new int[max + 1]; // +1 because it'll have 0th index

        for(int i = 0; i < arr.length; i++) {
            hashArr[arr[i]]++;
        }

        for(int i = 0; i < hashArr.length; i++) {
            if(hashArr[i] == 1) return i;
        }
        // for(int i : hashArr) {
        //     if(i == 1) return i;
        // }
        return -1;
    }

    static int brute(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int count = 0;
            for(int j = 0; j < arr.length; j++) {
                if(arr[j] == num) { 
                    count++;
                }
            }
            if(count==1) { 
                return num;
            }
        }
        return -1;
    }
}
