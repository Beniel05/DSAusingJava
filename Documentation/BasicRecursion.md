# 1. Intro To Recursion

## Problem Statement

Print numbers recursively until a base condition stops further calls.

## Best Approach

### Idea

Use a recursive function that does some work, updates the state, and stops when the base case is reached.

### Algorithm

1. Check the base case first.
2. Print the current value.
3. Update the value.
4. Call the function again.

### Time Complexity

`O(N)` because the function is called once per value.

### Space Complexity

`O(N)` due to recursion call stack.

### Key Points

- Every recursive solution must have a base case.
- Missing the base case causes infinite recursion and stack overflow.
- Think in terms of "current work + smaller subproblem".

### Code

```java
static int count = 1;

static void print() {
    if (count == 4) {
        return;
    }
    System.out.println(count);
    count++;
    print();
}
```

---

# 2. Print Name N Times

## Problem Statement

Print a given name `N` times using recursion.

## Best Approach

### Idea

Use the current index to track how many times printing has been done.

### Algorithm

1. Start from `i = 1`.
2. If `i > n`, stop.
3. Print the name.
4. Recur with `i + 1`.

### Time Complexity

`O(N)` because there are `N` recursive calls.

### Space Complexity

`O(N)` due to recursion stack.

### Key Points

- Parameter-based recursion is useful when counting progress.
- The stopping condition should be checked before printing.

### Code

```java
static void printNamesNtimes(int i, int n) {
    if (i > n) {
        return;
    }
    System.out.println("name");
    printNamesNtimes(i + 1, n);
}
```

---

# 3. Print 1 To N

## Problem Statement

Print numbers from `1` to `N` using recursion.

## Best Approach

### Idea

Print the current number, then solve for the next number.

### Algorithm

1. If `i > n`, stop.
2. Print `i`.
3. Recur for `i + 1`.

### Time Complexity

`O(N)`.

### Space Complexity

`O(N)`.

### Key Points

- This is straightforward forward recursion.
- Printing happens before the recursive call.

### Code

```java
static void print1toN(int i, int n) {
    if (i > n) {
        return;
    }
    System.out.println(i);
    print1toN(i + 1, n);
}
```

---

# 4. Print N To 1

## Problem Statement

Print numbers from `N` down to `1` using recursion.

## Best Approach

### Idea

Print the current value and recur on the smaller number.

### Algorithm

1. If `n < 1`, stop.
2. Print `n`.
3. Recur with `n - 1`.

### Time Complexity

`O(N)`.

### Space Complexity

`O(N)`.

### Key Points

- This is the reverse of `1` to `N`.
- Useful for understanding decrement-based recursion.

### Code

```java
static void printNto1(int n) {
    if (n < 1) {
        return;
    }
    System.out.println(n);
    printNto1(n - 1);
}
```

---

# 5. Print 1 To N Using Backtracking

## Problem Statement

Print numbers from `1` to `N` using backtracking in recursion.

## Best Approach

### Idea

Go down to the base case first, then print while the recursive calls return.

### Algorithm

1. If `i < 1`, stop.
2. Recur with `i - 1`.
3. Print `i` while returning.

### Time Complexity

`O(N)`.

### Space Complexity

`O(N)`.

### Key Points

- Backtracking means work happens after the recursive call.
- This pattern is common in recursion problems.

### Code

```java
static void print1toNusingBacktracking(int i, int n) {
    if (i < 1) {
        return;
    }
    print1toNusingBacktracking(i - 1, n);
    System.out.println(i);
}
```

---

# 6. Print N To 1 Using Backtracking

## Problem Statement

Print numbers from `N` to `1` using backtracking.

## Best Approach

### Idea

Move forward recursively, then print values while the stack unwinds.

### Algorithm

1. If `i > n`, stop.
2. Recur with `i + 1`.
3. Print `i` while returning.

### Time Complexity

`O(N)`.

### Space Complexity

`O(N)`.

### Key Points

- Another example of "do work on return".
- Helps build recursion intuition beyond direct printing.

### Code

```java
static void printNto1usingBacktracking(int i, int n) {
    if (i > n) {
        return;
    }
    printNto1usingBacktracking(i + 1, n);
    System.out.println(i);
}
```

---

# 7. Sum Of First N Natural Numbers

## Problem Statement

Find the sum of the first `N` natural numbers using recursion.

## Best Approach

### Idea

Use functional recursion: each call returns `n + sum(n - 1)`.

### Algorithm

1. If `n < 1`, return `0`.
2. Return `n + sum(n - 1)`.

### Time Complexity

`O(N)` because one recursive call is made for each number.

### Space Complexity

`O(N)` due to recursion stack.

### Key Points

- Functional recursion returns values.
- Base case should return `0` for sum problems.
- Cleaner for interviews than parameter-style printing.

### Code

```java
static int sumOfNNaturalNumbers(int n) {
    if (n < 1) {
        return 0;
    }
    return n + sumOfNNaturalNumbers(n - 1);
}
```

---

# 8. Factorial Of N

## Problem Statement

Find the factorial of a number using recursion.

## Best Approach

### Idea

Use the recurrence `n! = n * (n - 1)!`.

### Algorithm

1. If `n < 1`, return `1`.
2. Return `n * factorial(n - 1)`.

### Time Complexity

`O(N)`.

### Space Complexity

`O(N)`.

### Key Points

- `0! = 1` is the base case.
- Very common recursion interview question.

### Code

```java
static int factorialOfN(int n) {
    if (n < 1) {
        return 1;
    }
    return n * factorialOfN(n - 1);
}
```

---

# 9. Reverse An Array Using Recursion

## Problem Statement

Reverse an array in place using recursion.

## Best Approach

### Idea

Swap symmetric elements from the start and end, then recurse inward.

### Algorithm

1. Start with index `i = 0`.
2. If `i >= n / 2`, stop.
3. Swap `arr[i]` and `arr[n - i - 1]`.
4. Recur for `i + 1`.

### Time Complexity

`O(N)` because each pair is swapped once.

### Space Complexity

`O(N)` due to recursion stack.

### Key Points

- Only one pointer is needed because the opposite index can be derived.
- Stop at the midpoint.

### Code

```java
static void reverseArr(int i, int[] arr, int n) {
    if (i >= n / 2) {
        return;
    }

    int temp = arr[i];
    arr[i] = arr[n - i - 1];
    arr[n - i - 1] = temp;

    reverseArr(i + 1, arr, n);
}
```

---

# 10. Check Palindrome String Using Recursion

## Problem Statement

Check whether a string is a palindrome using recursion.

## Best Approach

### Idea

Compare symmetric characters from both ends and recurse inward.

### Algorithm

1. If `i >= length / 2`, return `true`.
2. Compare the `i`th character from the left and right.
3. If they differ, return `false`.
4. Otherwise recur for `i + 1`.

### Time Complexity

`O(N)` because at most half the string is checked.

### Space Complexity

`O(N)` because recursive calls use stack space.

### Key Points

- Convert characters to lowercase if the check should be case-insensitive.
- Early mismatch gives immediate return.

### Code

```java
static boolean isPalindrome(int i, String s) {
    if (i >= s.length() / 2) {
        return true;
    }

    char left = Character.toLowerCase(s.charAt(i));
    char right = Character.toLowerCase(s.charAt(s.length() - i - 1));

    if (left != right) {
        return false;
    }

    return isPalindrome(i + 1, s);
}
```

---

# 11. Fibonacci Number Using Recursion

## Problem Statement

Find the `n`th Fibonacci number using recursion.

## Best Approach

### Idea

Use the recurrence `f(n) = f(n - 1) + f(n - 2)` with base cases `0` and `1`.

### Algorithm

1. If `n <= 1`, return `n`.
2. Recursively compute `f(n - 1)` and `f(n - 2)`.
3. Return their sum.

### Time Complexity

`O(2^N)` in the naive recursive version because subproblems are recomputed many times.

### Space Complexity

`O(N)` due to recursion depth.

### Key Points

- This recursive solution is good for recursion basics, not for optimization.
- In interviews, mention memoization or iterative DP for better efficiency.

### Code

```java
static int fibonacci(int n) {
    if (n <= 1) {
        return n;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
}
```
