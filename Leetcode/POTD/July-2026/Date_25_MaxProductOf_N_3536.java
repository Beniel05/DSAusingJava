class Date_25_MaxProductOf_N_3536 {
    public static void main(String[] args) {

        /* 3536. Maximum Product of Two Digits */

        /*
         * Example 1:
         * Input: n = 31
         * Output: 3
         * Explanation;
         * The digits of n are [3, 1].
         * The possible products of any two digits are: 3 * 1 = 3.
         * The maximum product is 3.
         * 
         * Example 2:
         * Input: n = 22
         * Output: 4
         * Explanation;
         * The digits of n are [2, 2].
         * The possible products of any two digits are: 2 * 2 = 4.
         * The maximum product is 4.
         * 
         * Example 3:
         * Input: n = 124
         * Output: 8
         * Explanation;
         * The digits of n are [1, 2, 4].
         * The possible products of any two digits are: 1 * 2 = 2, 1 * 4 = 4, 2 * 4 = 8.
         * The maximum product is 8.
         */

        System.out.println(maxProduct(123)); // 2 * 3 -> makes the highest product
        System.out.println(maxProduct(623)); // 6 * 3 -> makes the highest product
    }

    public static int maxProduct(int n) {
        int first = 0;
        int second = 0;
    
        while (n != 0) {
    
            int lastDigit = n % 10;
    
            if (lastDigit > first) {
                second = first;
                first = lastDigit;
            } else if (lastDigit > second) {
                second = lastDigit;
            }
    
            n /= 10;
        }
        return first * second;
    }
}
