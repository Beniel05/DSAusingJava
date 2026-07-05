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

---

# 3. Insertion Sort

## Problem Statement

Sort an array in ascending order using the Insertion Sort algorithm.

**Example**

- Input: `{7, 4, 1, 5, 3}`
- Output: `{1, 3, 4, 5, 7}`

## Best Approach

### Idea

Assume the first element forms a sorted portion of size one. Take each next element and insert it into its correct position within the already sorted left portion by shifting larger elements one step to the right.

### Algorithm

1. Run the outer loop from `i = 0` to `n - 1`.
2. Set `j = i` to mark the element being inserted.
3. While `j > 0` and `arr[j - 1] > arr[j]`, swap `arr[j]` with `arr[j - 1]` and decrement `j`.
4. After the inner loop, indices `0` to `i` form a sorted subarray.
5. Return the sorted array.

### Time Complexity

- **Best case:** `O(N)` when the array is already sorted (each element is already in place).
- **Average case:** `O(N^2)` because elements may need to shift across the sorted portion.
- **Worst case:** `O(N^2)` when the array is reverse sorted.

### Space Complexity

`O(1)` because sorting is done in place with only index and swap variables.

### Key Points

- Stable sort: equal elements are not swapped past each other.
- Efficient on small or nearly sorted arrays — often used as a fallback in hybrid sorts like Timsort.
- The left portion `arr[0..i]` is always sorted after each outer-loop iteration.
- Similar to sorting playing cards in your hand — pick a card and slide it into the correct spot.

### Code

```java
static int[] getSorted(int[] arr, int n) {

    // Assume the first element is already sorted.
    // Start from the next element and insert it into its correct position.
    for (int i = 0; i < n; i++) {

        // j points to the current element that needs positioning.
        int j = i;

        // Move the current element left until:
        // 1. It reaches the beginning of the array, OR
        // 2. The element on its left is smaller or equal.
        while (j > 0 && arr[j - 1] > arr[j]) {

            // Swap the current element with the larger element on its left.
            int temp = arr[j];
            arr[j] = arr[j - 1];
            arr[j - 1] = temp;

            // Continue checking further left.
            j--;
        }
    }

    return arr;
}
```

---

# Bubble Sort vs Selection Sort vs Insertion Sort

## Bubble Sort

### Idea

Repeatedly compare adjacent elements and swap them if they are in the wrong order.

### What happens after each pass?

- The largest element "bubbles up" to its correct position at the end.
- After the 1st pass, the largest element is fixed.
- After the 2nd pass, the 2nd largest element is fixed.
- And so on.

### Visualization

```text
[7, 4, 1, 5, 3]

Pass 1 → Largest element (7) moves to the end
[4, 1, 5, 3, 7]

Pass 2 → Next largest element (5) moves to its position
[1, 4, 3, 5, 7]
```

### Key Point

Focuses on **adjacent comparisons and swaps**.

---

## Selection Sort

### Idea

Find the smallest element from the unsorted portion and place it at its correct position.

### What happens after each pass?

- After the 1st pass, the smallest element is fixed at index 0.
- After the 2nd pass, the 2nd smallest element is fixed at index 1.
- And so on.

### Visualization

```text
[7, 4, 1, 5, 3]

Pass 1 → Find smallest (1)
[1, 4, 7, 5, 3]

Pass 2 → Find next smallest (3)
[1, 3, 7, 5, 4]
```

### Key Point

Focuses on **finding the minimum element** and placing it correctly.

---

## Insertion Sort

### Idea

Take one element at a time and insert it into its correct position in the already sorted left portion.

### What happens after each pass?

- The left side of the array remains sorted.
- Each new element is inserted into that sorted portion.

### Visualization

```text
[7, 4, 1, 5, 3]

Insert 4 into [7]
[4, 7, 1, 5, 3]

Insert 1 into [4, 7]
[1, 4, 7, 5, 3]

Insert 5 into [1, 4, 7]
[1, 4, 5, 7, 3]
```

### Key Point

Focuses on **inserting an element into its correct position**.

---

# Quick Comparison

| Sort           | Main Idea                               | After Each Pass                        |
| -------------- | --------------------------------------- | -------------------------------------- |
| Bubble Sort    | Swap adjacent elements                  | Largest element reaches the end        |
| Selection Sort | Find minimum element                    | Smallest element reaches the beginning |
| Insertion Sort | Insert current element into sorted part | Left portion becomes sorted            |

# Interview Memory Trick

### Bubble Sort

> Push the largest element to the end.

### Selection Sort

> Select the smallest element and place it correctly.

### Insertion Sort

> Insert the current element into the sorted left part.

---

# Key Differences (Time, Stability, and When to Use)

## Time Complexity at a Glance

| Sort           | Best Case | Average Case | Worst Case |
| -------------- | --------- | ------------ | ---------- |
| Bubble Sort    | `O(N)`    | `O(N^2)`     | `O(N^2)`   |
| Selection Sort | `O(N^2)`  | `O(N^2)`     | `O(N^2)`   |
| Insertion Sort | `O(N)`    | `O(N^2)`     | `O(N^2)`   |

- **Bubble Sort** and **Insertion Sort** can both finish early on sorted or nearly sorted input.
- **Selection Sort** always runs `O(N^2)` comparisons — it never gets faster just because the array is already sorted.

## Stability

| Sort           | Stable? | Why |
| -------------- | ------- | --- |
| Bubble Sort    | Yes     | Only swaps adjacent out-of-order pairs; equal elements stay in order. |
| Selection Sort | No      | Swapping a distant minimum can jump over equal values and break their order. |
| Insertion Sort | Yes     | Shifts only when the left neighbor is strictly greater. |

## Number of Swaps / Writes

| Sort           | Swaps per pass | Notes |
| -------------- | -------------- | ----- |
| Bubble Sort    | Up to `N - 1`  | Can swap many times in one pass. |
| Selection Sort | Exactly 1      | Minimizes writes — good when memory writes are costly. |
| Insertion Sort | Up to `i`      | Few swaps on nearly sorted data; many on reverse sorted data. |

## Which One Builds the Sorted Part?

| Sort           | Sorted portion grows from… | Fixed side after each pass |
| -------------- | -------------------------- | -------------------------- |
| Bubble Sort    | Right (end)                | Largest elements at the back |
| Selection Sort | Left (start)               | Smallest elements at the front |
| Insertion Sort | Left (start)               | Left subarray is fully sorted |

Bubble Sort and Selection Sort fix elements from opposite ends of the array. Insertion Sort also grows from the left, but it keeps the left side **fully sorted** rather than just placing one minimum at a time.

## When to Prefer Each (Interview Context)

| Sort           | Prefer when… |
| -------------- | ------------ |
| Bubble Sort    | Teaching basics only — rarely chosen in practice. |
| Selection Sort | Write operations are expensive and stability does not matter. |
| Insertion Sort | Array is small or nearly sorted — common real-world choice among the three. |

## One-Line Summary

| Sort           | One line |
| -------------- | -------- |
| Bubble Sort    | Compare neighbors, push max to the end; stable but slow. |
| Selection Sort | Pick the min, swap once; few writes but not stable. |
| Insertion Sort | Slide each element into sorted left part; best on small or almost-sorted arrays. |
