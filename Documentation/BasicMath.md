# 1. a) Count Digits In A Number

## Problem Statement

Count how many digits are present in a given integer.

## Best Approach

### Idea

Repeatedly divide the number by `10` until it becomes `0`.

### Algorithm

1. Initialize `count = 0`.
2. While `n != 0`, increment `count` and divide `n` by `10`.
3. `count` is the number of digits.

### Time Complexity

`O(log10 N)` because one digit is removed in each step.

### Space Complexity

`O(1)`.

### Key Points

- For `n = 0`, the answer should be `1`.
- For negative numbers, use absolute value if needed.

### Code

```java
static int countDigits(int n) {
    n = Math.abs(n);
    if (n == 0) {
        return 1;
    }

    int count = 0;
    while (n != 0) {
        count++;
        n /= 10;
    }
    return count;
}
```

---


# 1. b) Count Digits Using Log10

## Problem Statement

Count digits in a number using a mathematical formula.

## Best Approach

### Idea

For a positive number, digits = `floor(log10(n)) + 1`.

### Algorithm

1. Convert the number to absolute value.
2. Handle `0` separately.
3. Return `(int)Math.log10(n) + 1`.

### Time Complexity

`O(1)`.

### Space Complexity

`O(1)`.

### Key Points

- Always handle `0` separately because `log10(0)` is undefined.
- Useful shortcut in interviews.

### Code

```java
static int countDigitsUsingLog10(int n) {
    n = Math.abs(n);
    if (n == 0) {
        return 1;
    }
    return (int) Math.log10(n) + 1;
}
```

---

# 3. Reverse A Number

## Problem Statement

Reverse the digits of an integer.

## Best Approach

### Idea

Extract the last digit and append it to the reversed number step by step.

### Algorithm

1. Initialize `rev = 0`.
2. While `n != 0`, take `lastDigit = n % 10`.
3. Check overflow before multiplying `rev` by `10`.
4. Update `rev = rev * 10 + lastDigit`.
5. Divide `n` by `10`.

### Time Complexity

`O(log10 N)`.

### Space Complexity

`O(1)`.

### Key Points

- Overflow checking is important for integer reversal.
- Works naturally for negative values in Java integer arithmetic.

### Code

```java
static int reverseNumber(int n) {
    int rev = 0;

    while (n != 0) {
        int lastDigit = n % 10;

        if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
            throw new ArithmeticException("Integer overflow");
        }

        rev = rev * 10 + lastDigit;
        n /= 10;
    }

    return rev;
}
```

---

# 4. Palindrome Number

## Problem Statement

Check whether a number reads the same forward and backward.

## Best Approach

### Idea

Reverse the number and compare it with the original.

### Algorithm

1. Store the original number.
2. Reverse the number.
3. Compare the reversed value with the original.

### Time Complexity

`O(log10 N)`.

### Space Complexity

`O(1)`.

### Key Points

- Negative numbers are usually not considered palindrome in interview settings.
- Can reuse the reverse-number logic.

### Code

```java
static boolean isPalindromeNumber(int n) {
    if (n < 0) {
        return false;
    }

    int original = n;
    int reversed = 0;

    while (n != 0) {
        int lastDigit = n % 10;
        reversed = reversed * 10 + lastDigit;
        n /= 10;
    }

    return original == reversed;
}
```

---

# 5. Armstrong Number

## Problem Statement

Check whether a number is equal to the sum of its digits raised to the power of the total number of digits.

## Best Approach

### Idea

Count digits, then compute the powered sum of each digit.

### Algorithm

1. Store the original number.
2. Count the number of digits.
3. Traverse each digit using `% 10`.
4. Add `digit^count` to the sum.
5. Compare the sum with the original number.

### Time Complexity

`O(log10 N)`.

### Space Complexity

`O(1)`.

### Key Points

- Also called narcissistic number.
- Example: `153 = 1^3 + 5^3 + 3^3`.

### Code

```java
static boolean isArmstrong(int n) {
    int original = n;
    int temp = n;
    int digits = String.valueOf(n).length();
    int sum = 0;

    while (temp != 0) {
        int digit = temp % 10;
        sum += (int) Math.pow(digit, digits);
        temp /= 10;
    }

    return sum == original;
}
```

---

# 6. Print All Divisors

## Problem Statement

Print all divisors of a number in sorted order.

## Best Approach

### Idea

Divisors come in pairs around the square root, so iterate only up to `sqrt(n)`.

### Algorithm

1. Traverse `i` from `1` to `sqrt(n)`.
2. If `i` divides `n`, add `i`.
3. If `i` and `n / i` are different, add both.
4. Sort and print the collected divisors.

### Time Complexity

`O(sqrt(N) log sqrt(N))` due to iteration plus sorting of collected divisors.

### Space Complexity

`O(sqrt(N))` in the worst case for storing divisors.

### Key Points

- Better than checking all numbers from `1` to `n`.
- Perfect squares should not add the same divisor twice.

### Code

```java
static List<Integer> getDivisors(int n) {
    List<Integer> divisors = new ArrayList<>();

    for (int i = 1; i * i <= n; i++) {
        if (n % i == 0) {
            divisors.add(i);
            if (n / i != i) {
                divisors.add(n / i);
            }
        }
    }

    Collections.sort(divisors);
    return divisors;
}
```

---

# 7. Check Prime Number

## Problem Statement

Check whether a number is prime.

## Best Approach

### Idea

A number is prime if it has no divisor other than `1` and itself, so test divisibility only up to `sqrt(n)`.

### Algorithm

1. If `n <= 1`, return `false`.
2. Traverse `i` from `2` to `sqrt(n)`.
3. If `n % i == 0`, return `false`.
4. If no divisor is found, return `true`.

### Time Complexity

`O(sqrt(N))`.

### Space Complexity

`O(1)`.

### Key Points

- `0` and `1` are not prime.
- Checking up to `sqrt(n)` is the standard optimization.

### Code

```java
static boolean isPrime(int n) {
    if (n <= 1) {
        return false;
    }

    for (int i = 2; i * i <= n; i++) {
        if (n % i == 0) {
            return false;
        }
    }

    return true;
}
```

---

# 8. GCD Or HCF Of Two Numbers

## Problem Statement

Find the greatest common divisor of two numbers.

## Best Approach

### Idea

Use the Euclidean algorithm: `gcd(a, b) = gcd(b, a % b)`.

### Algorithm

1. Repeat while both numbers are greater than `0`.
2. Replace the larger number with its remainder when divided by the smaller number.
3. When one number becomes `0`, the other is the GCD.

### Time Complexity

`O(log(min(a, b)))` for the Euclidean algorithm.

### Space Complexity

`O(1)`.

### Key Points

- Much better than checking all factors.
- One of the most important basic math interview formulas.

### Code

```java
static int gcd(int a, int b) {
    while (a > 0 && b > 0) {
        if (a > b) {
            a %= b;
        } else {
            b %= a;
        }
    }
    return a == 0 ? b : a;
}
```
