public class BasicRecursion {
    public static void main(String[] args) {
        /*
         * 1. Print name N times
         * 2. Print linearly from 1 to N
         * 3. Print from N to 1
         * 4. Print linearly from 1 to N (but by Backtracking)
         * 3. Print from N to 1 (but by Backtracking)
         */

        // printNamesNtimes(1, 10);
        // print1toN(1, 10);
        // printNto1(5);

        int n = 3;
        // print1toNusingBacktracking(n, n);
        printNto1usingBacktracking(1, n);
    }

    static void printNamesNtimes(int i, int n) {
        if (i > n)
            return;
        System.out.println("name");
        printNamesNtimes(i + 1, n);
        // printNamesNtimes(++i, n);
    }

    static void print1toN(int i, int n) {
        if (i > n)
            return;
        System.out.println(i);
        print1toN(i + 1, n);
    }

    static void printNto1(int n) {
        if (n < 1)
            return;
        System.out.println(n);
        printNto1(n - 1);
    }

    static void print1toNusingBacktracking(int i, int n) {
        if(i < 1) return;
        // to practice backtracking we should not use i + 1 here
        print1toNusingBacktracking(i - 1, n);
        System.out.println(i);
    }

    static void printNto1usingBacktracking(int i, int n) {
        if(i > n) return;
        printNto1usingBacktracking(i + 1, n);
        System.out.println(i);
    }
}
