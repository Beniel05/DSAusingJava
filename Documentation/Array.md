# 1. Largest Number

## Problem Statement

Find the maximum element in an array.

## Best Approach

### Idea

Scan the array once and keep track of the largest value seen so far.

### Algorithm

1. Initialize `max` as `Integer.MIN_VALUE`.
2. Traverse every element in the array.
3. Update `max` whenever the current element is larger.
4. Return or print `max`.

### Time Complexity

`O(N)` because each element is visited once.

### Space Complexity

`O(1)` because only one extra variable is used.

### Key Points

- Works for negative numbers as well.
- If the array can be empty, handle that case separately.

### Code

```java
static int largestNumber(int[] arr) {
    int max = Integer.MIN_VALUE;
    for (int num : arr) {
        if (num > max) {
            max = num;
        }
    }
    return max;
}
```

---

# 2. Second Largest

## Problem Statement

Find the second distinct largest element in an array.

## Best Approach

### Idea

Track both the largest and second largest values in a single traversal.

### Algorithm

1. Initialize `largest` and `secondLargest` as `Integer.MIN_VALUE`.
2. Traverse the array.
3. If the current element is greater than `largest`, shift `largest` to `secondLargest`.
4. Otherwise, if it is smaller than `largest` but greater than `secondLargest`, update `secondLargest`.
5. After traversal, `secondLargest` is the answer if it was updated.

### Time Complexity

`O(N)` because the array is scanned once.

### Space Complexity

`O(1)` because only constant extra space is used.

### Key Points

- "Second largest" usually means second distinct largest.
- Arrays like `{80, 80, 80}` have no valid second distinct largest.
- Using two variables is better than sorting for interviews.

### Code

```java
static int findSecondLargest(int[] arr) {
    int largest = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;

    for (int num : arr) {
        if (num > largest) {
            secondLargest = largest;
            largest = num;
        } else if (num < largest && num > secondLargest) {
            secondLargest = num;
        }
    }

    return secondLargest;
}
```

---

# 3. Left Rotate By One

## Problem Statement

Rotate an array to the left by one position.

## Best Approach

### Idea

Store the first element, shift the remaining elements left by one, then place the stored element at the end.

### Algorithm

1. Save `arr[0]` in a temporary variable.
2. Shift elements from index `1` to `n - 1` one position left.
3. Put the saved first element at index `n - 1`.

### Time Complexity

`O(N)` because one pass is needed for shifting.

### Space Complexity

`O(1)` because only one temporary variable is used.

### Key Points

- Simple building block for larger rotation problems.
- Handle arrays of size `0` or `1` separately if needed.

### Code

```java
static void leftRotateByOne(int[] arr) {
    int first = arr[0];
    for (int i = 1; i < arr.length; i++) {
        arr[i - 1] = arr[i];
    }
    arr[arr.length - 1] = first;
}
```

---

# 4. Move Zeros To End

## Problem Statement

Move all zeros to the end of the array while keeping the relative order of non-zero elements unchanged.

## Best Approach

### Idea

Use one pointer to place the next non-zero element, then fill the remaining positions with zeros.

### Algorithm

1. Initialize pointer `j = 0`.
2. Traverse the array.
3. For every non-zero element, place it at `arr[j]` and increment `j`.
4. After the traversal, fill all indices from `j` to `n - 1` with `0`.

### Time Complexity

`O(N)` because the array is traversed linearly.

### Space Complexity

`O(1)` because rearrangement is done in place.

### Key Points

- Preserves the order of non-zero elements.
- Better than creating an extra array or list.
- Common two-pointer / compaction pattern.

### Code

```java
static void moveZerosToEnd(int[] arr) {
    int j = 0;

    for (int i = 0; i < arr.length; i++) {
        if (arr[i] != 0) {
            arr[j] = arr[i];
            j++;
        }
    }

    while (j < arr.length) {
        arr[j] = 0;
        j++;
    }
}
```

---

# 5. Rotate By K Places

## Problem Statement

Rotate an array to the left by `k` positions.

## Best Approach

### Idea

Use the reversal technique: reverse the first `k` elements, reverse the remaining elements, then reverse the whole array.

### Algorithm

1. Compute `k = k % n`.
2. Reverse the subarray from `0` to `k - 1`.
3. Reverse the subarray from `k` to `n - 1`.
4. Reverse the entire array.

### Time Complexity

`O(N)` because each element is reversed a constant number of times.

### Space Complexity

`O(1)` because rotation is done in place.

### Key Points

- Always reduce `k` using modulo to avoid unnecessary rotations.
- Reversal technique is the standard optimal interview solution.
- Works for large `k` values efficiently.

### Code

```java
static void rotateLeftByK(int[] arr, int k) {
    k %= arr.length;

    reverse(arr, 0, k - 1);
    reverse(arr, k, arr.length - 1);
    reverse(arr, 0, arr.length - 1);
}

static void reverse(int[] arr, int start, int end) {
    while (start < end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
    }
}
```

---

# 6. Sorted Or Not

## Problem Statement

Check whether an array is sorted in non-decreasing order.

## Best Approach

### Idea

Compare each element with the previous one. If any previous element is greater than the current element, the array is not sorted.

### Algorithm

1. Traverse the array from index `1` to `n - 1`.
2. If `arr[i - 1] > arr[i]`, return `false`.
3. If the loop finishes, return `true`.

### Time Complexity

`O(N)` because each adjacent pair is checked once.

### Space Complexity

`O(1)` because no extra data structure is used.

### Key Points

- Allows duplicates because it checks non-decreasing order.
- Early exit makes it efficient when the array becomes unsorted quickly.

### Code

```java
static boolean isSorted(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
        if (arr[i - 1] > arr[i]) {
            return false;
        }
    }
    return true;
}
```

---

# 7. Remove Duplicates From Sorted Array (Unique First)

## Problem Statement

Remove duplicates from a sorted array in place and return the count of unique elements.

## Best Approach

### Idea

Use two pointers: one pointer tracks the last unique element, and the other scans the array.

### Algorithm

1. Initialize `i = 0` as the index of the last unique element.
2. Traverse the array with `j` from `1` to `n - 1`.
3. If `arr[j]` differs from `arr[i]`, increment `i` and place `arr[j]` at `arr[i]`.
4. After traversal, the first `i + 1` elements are unique.
5. Return `i + 1`.

### Time Complexity

`O(N)` because the array is scanned once.

### Space Complexity

`O(1)` because updates are done in place.

### Key Points

- This approach requires the array to be sorted.
- The answer is the new unique length, not the full modified array.
- After processing, valid unique values lie in indices `0` to `uniqueLength - 1`.

### Code

```java
static int removeDuplicates(int[] arr) {
    int i = 0;

    for (int j = 1; j < arr.length; j++) {
        if (arr[j] != arr[i]) {
            i++;
            arr[i] = arr[j];
        }
    }

    return i + 1;
}
```
