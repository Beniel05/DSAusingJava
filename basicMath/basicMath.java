import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class basicMath {

    static void countDigitsOfAGivenNumber(int n) {
        int digit = 0;
        int org = n;
        while (n != 0) {
            digit++;
            n /= 10;
        }
        System.out.println("Total digits of " + org + " is: " + digit);
    }

    static void countDigitsUsingLog10(int n) {
        // Math.abs to handle negative values;
        int digits = (int) Math.log10((Math.abs(n))) + 1;
        System.out.println("Total digits of " + n + " is: " + digits);
    }

    static void reverseTheGivenNumber(int n) {
        int org = n;
        int rev = 0;
        while (n != 0) {
            int lastDigit = n % 10;

            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
                System.out.println("The reverse value of " + org + " will arise integer overflow");
                return;
            }

            rev = rev * 10 + lastDigit;
            n /= 10;
        }
        System.out.println("The reverse of " + org + " is: " + rev);
    }

    static void givenNumberIsPalindromeOrNot(int n) {
        int org = n;
        int rev = 0;

        while (n != 0) {
            int lastDigit = n % 10;

            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
                System.out.println("The reverse of " + org + " will arise integer overflow.");
                return;
            }

            rev = rev * 10 + lastDigit;
            n /= 10;
        }
        if (org == rev)
            System.out.println(org + " is A Palindrome");
        else
            System.out.println(org + " is NOT A Palindrome");
    }

    static void armstrongNumberOrNot(int n) {
        int org = n;
        int sum = 0;

        int digits = (int) Math.log10(n) + 1;
        // (or) int digits = String.valueOf(n).length();

        while (n != 0) {
            int lastNum = n % 10;
            sum += Math.pow(lastNum, digits);
            n /= 10;
        }

        if (sum == org)
            System.out.println(org + " is an Armstrong Number.");
        else
            System.out.println(org + " is NOT an Armstrong Number.");
    }

    static void printAllDivisors(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    static void printAllDivisorsOptimized(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                // System.out.print(i + " ");
                if (n / i != i) {
                    list.add(n / i);
                    // System.out.print(n / i + " ");
                }
            }
        }
        Collections.sort(list);
        // System.out.println(list);
        for (int eachValue : list)
            System.out.print(eachValue + " ");
    }

    static void primeOrNotUsingCount(int n) {
        if (n <= 1) {
            System.out.print(n + " is NOT A PRIME number.");
            return;
        }

        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++;
                if ((n / i) != i)
                    count++;
                if (count > 2)
                    break;
            }
        }

        if (count == 2) // exactly (two) factors - 1 and itself
            System.out.print(n + " is A PRIME number.");
        else
            System.out.print(n + " is NOT A PRIME number.");
    }

    static boolean primeOrNotUsingBoolean(int n) {

        if (n <= 1)
            return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    static void findGCDofTwoNumbersBRUTEforce(int a, int b) {
        int min = Math.min(a, b);
        for (int i = min; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                System.out.print("The GCD of " + a + " and " + b + " is: " + i);
                break;
            }
        }
    }

    static void findGCDofTwoNumbersOptimized(int a, int b) {
        // will be implemented after understanding the concept.       
    }
    public static void main(String[] args) {

        // countDigitsOfAGivenNumber(12345);
        // countDigitsUsingLog10(-1234);
        // reverseTheGivenNumber(12345);
        // givenNumberIsPalindromeOrNot(12321);
        // armstrongNumberOrNot(8208);
        // printAllDivisors(36);
        // printAllDivisorsOptimized(36);
        // primeOrNotUsingCount(13);

        /*
         * int n = 1;
         * boolean isPrime = primeOrNotUsingBoolean(n);
         * if (isPrime)
         * System.out.println(n + " is A PRIME number");
         * else
         * System.out.print(n + " is NOT A PRIME number");
         */

        findGCDofTwoNumbersBRUTEforce(9,12);
        findGCDofTwoNumbersOptimized(527, 1147); // euclidean algorithm

    }
}