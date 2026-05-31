import java.util.Arrays;

class BasicRecursion2 {
    public static void main(String[] args) {
        
        /*  1. Sum of first N numbers using Recursion */
        // Two ways: (1) Parameter wise | (2) Functional

        /* 2. Factorial of a Number using Recursion */
        
        int n = 3;

        // 1
        // sumOf_N_Natural_Numbers_Parameter_Printing(n, 0);
        // System.out.println(sumOf_N_Natural_Numbers_Return_Function(n));
        
        // 2
        // System.out.println(factorialOfN(n));

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

}