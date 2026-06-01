import java.util.Arrays;

class BasicRecursion2 {
    public static void main(String[] args) {
        
        /*  1. Sum of first N numbers using Recursion */
        // Two ways: (1) Parameter wise | (2) Functional

        /* 2. Factorial of a Number using Recursion */
        
        /* 3. Reverse an array only using one pointer and recursion */
        
        /* 4. Check if the given String is Palindrome or not using functional recursion */

        int n = 3;

        // 1
        // sumOf_N_Natural_Numbers_Parameter_Printing(n, 0);
        // System.out.println(sumOf_N_Natural_Numbers_Return_Function(n));
        
        // 2
        // System.out.println(factorialOfN(n));

        // 3
        // int[] arr = {10, 30, 60, 40, 50};
        // System.out.println(Arrays.toString(arr));
        // reverseArr(0, arr, arr.length);

        // 4
        String str = "Madam";
        boolean res = checkTheStringIsPalindromeOrNot(0, str);
        if(res) System.out.println(str + " is Palindrome");
        else System.out.println(str + " is NOT Palindrome");
    }

    static void sumOf_N_Natural_Numbers_Parameter_Printing(int i, int s) {
        if(i < 1) {
            System.out.print(s);
            return;
        }
        sumOf_N_Natural_Numbers_Parameter_Printing(i - 1, s + i);
    }

    static int sumOf_N_Natural_Numbers_Return_Function(int n) {
        if(n < 1) return n;
        return n + sumOf_N_Natural_Numbers_Return_Function(n - 1);
    }

    static int factorialOfN(int n) {
        if(n < 1) return 1;
        return n * factorialOfN(n - 1);
    }

    static void reverseArr(int i, int[] a, int n) {

        if(i >= n / 2) {
            System.out.println(Arrays.toString(a));
            return;
        }

        System.out.println("Before Swap: " + a[i] + " " + a[n - i - 1]);
        
        int temp = a[i];
        a[i] = a[n - i - 1];
        a[n - i - 1] = temp;
        
        System.out.println("After Swap: " + a[i] + " " + a[n - i - 1]);

        reverseArr(i + 1, a, n);

    }

    static boolean checkTheStringIsPalindromeOrNot(int i, String s) {
        
        if(i >= s.length() / 2) return true;

        char left = Character.toLowerCase(s.charAt(i));
        char right = Character.toLowerCase(s.charAt(s.length() - i - 1));

        if(left != right) return false;

        return checkTheStringIsPalindromeOrNot(i + 1, s);
    }

}