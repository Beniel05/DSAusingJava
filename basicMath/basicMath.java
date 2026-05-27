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

    public static void main(String[] args) {

        countDigitsOfAGivenNumber(12345);
        countDigitsUsingLog10(-1234);
        reverseTheGivenNumber(12345);
        givenNumberIsPalindromeOrNot(12321);

    }
}