public class FindTheMissingNumber {
    public static void main(String[] args) {
        int[] array = {1,2,4,5}; // array will contain n - 1 elements.
        int n = 5;

        brute(array, n);
        System.out.println(better(array, n));
        optimizedSum(array, n);

    }

    static void optimizedSum(int[] a, int n) {
        int sumOfN = n * (n + 1) / 2;
        int sumOfArr = 0;
        for(int i = 0; i < a.length; i++) {
            sumOfArr += a[i];
        }
        System.out.println(sumOfN - sumOfArr);
    }

    static int better(int[] a, int n) {
        int[] hashArray = new int[n + 1]; // 0-th index will be empty

        for(int i = 0; i < n - 1; i++) {
            hashArray[a[i]] = 1;
        }

        for(int i = 1; i < n; i++) {
            if(hashArray[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    static void brute(int[] a, int n) {
        // numbers are from 1 to N;
        for(int i = 1; i < n; i++) {
            int flag = 0;
            for(int j = 0; j < n - 1; j++) {
                if(a[j] == i) {
                    flag = 1;
                    break;
                }
            }
            if(flag == 0) {
                System.out.println("The Missing Number is: " + i);
            }
        }
        
    }
}
