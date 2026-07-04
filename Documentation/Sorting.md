# Sorting - I

---

# 1. Bubble Sort

## Problem Statement

Sort an array in ascending order using the Bubble Sort algorithm.

**Example**

- Input: `{13, 46, 24, 52, 20, 9}`
- Output: `{9, 13, 20, 24, 46, 52}`

## Best Approach

### Idea

Repeatedly compare adjacent elements and swap them if they are in the wrong order. After each complete pass through the unsorted portion, the largest remaining element "bubbles up" to its correct position at the end. Use an early-exit flag (`didSwap`) to stop as soon as a pass completes with no swaps.

### Algorithm

1. Run the outer loop from `i = n - 1` down to `1`. Index `i` marks the end of the unsorted portion.
2. Set `didSwap = false` at the start of each pass.
3. Compare every adjacent pair from index `0` to `i - 1`.
4. If `arr[j] > arr[j + 1]`, swap them and set `didSwap = true`.
5. If `didSwap` is still `false` after the inner loop, the array is already sorted — break early.
6. Return the sorted array.

### Time Complexity

- **Best case:** `O(N)` when the array is already sorted (one pass, no swaps).
- **Average case:** `O(N^2)` because nested loops compare adjacent pairs repeatedly.
- **Worst case:** `O(N^2)` when the array is reverse sorted.

### Space Complexity

`O(1)` because sorting is done in place with only a temporary swap variable and a boolean flag.

### Key Points

- Stable sort: equal elements retain their relative order.
- Simple to understand and implement — good for learning, not for large datasets.
- The `didSwap` optimization avoids unnecessary passes on nearly sorted input.
- After pass `k`, the last `k` elements are in their final sorted positions.

### Code

```java
static int[] getSorted(int[] arr, int n) {

    // Each outer-loop pass pushes the largest unsorted
    // element to its correct position from the end.
    for (int i = n - 1; i > 0; i--) {

        // Assume that this pass will not perform any swaps.
        // If this remains false until the end of the pass,
        // the array is already sorted.
        boolean didSwap = false;

        // Compare adjacent elements.
        for (int j = 0; j < i; j++) {

            // If left element is greater than right element,
            // they are in the wrong order.
            if (arr[j] > arr[j + 1]) {

                // Swap them.
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;

                didSwap = true;
            }
        }

        // No swap happened — array is fully sorted.
        if (!didSwap) {
            break;
        }
    }

    return arr;
}
```

---

# 2. Selection Sort

## Problem Statement

Sort an array in ascending order using the Selection Sort algorithm.

**Example 1**

- Input: `N = 6`, `array[] = {13, 46, 24, 52, 20, 9}`
- Output: `{9, 13, 20, 24, 46, 52}`

**Example 2**

- Input: `N = 5`, `array[] = {5, 4, 3, 2, 1}`
- Output: `{1, 2, 3, 4, 5}`

## Best Approach

### Idea

Divide the array into a sorted prefix and an unsorted suffix. For each position `i`, find the minimum element in the unsorted portion and swap it into place at index `i`. After `n - 1` passes, the array is sorted.

### Algorithm

1. Run the outer loop from `i = 0` to `n - 2`.
2. Assume the minimum is at index `i` (`min = i`).
3. Scan the unsorted portion from `j = i + 1` to `n - 1`.
4. If `arr[j] < arr[min]`, update `min = j`.
5. Swap `arr[i]` with `arr[min]`.
6. Return the sorted array.

### Time Complexity

`O(N^2)` in all cases (best, average, and worst) because every pass scans the remaining unsorted portion regardless of input order.

### Space Complexity

`O(1)` because sorting is done in place with only a few index and swap variables.

### Key Points

- Not stable by default — swapping non-adjacent elements can change the relative order of equal values.
- Performs at most one swap per outer-loop iteration, so it minimizes the number of writes.
- Simple and predictable, but always `O(N^2)` even on already sorted input.
- After pass `i`, the first `i + 1` elements are in their final sorted positions.

### Code

```java
static int[] getSorted(int[] arr, int n) {

    // Move through the array one position at a time.
    // After each pass, the smallest element from the
    // unsorted portion is placed in its correct position.
    for (int i = 0; i < n - 1; i++) {

        // Assume the current position contains the minimum element.
        int min = i;

        // Search for the actual minimum element in the
        // remaining unsorted portion of the array.
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[min]) {
                min = j;
            }
        }

        // Swap the current element with the minimum element found.
        // If min == i, this simply swaps the element with itself.
        int temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }

    return arr;
}
```
