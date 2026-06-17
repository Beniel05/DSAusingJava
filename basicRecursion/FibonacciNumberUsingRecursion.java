class FibonacciNumberUsingRecursion {

    static int f(int n) {
        
        if (n <= 1) return n;

        int firstLast = f(n - 1);
        int secondLast = f(n - 2);
        return firstLast + secondLast;
    }

    public static void main(String[] args) {
        int n = 4;
        int res = f(n);
        System.out.println(res);
    }
}
