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

---

# 8. Linear Search

## Problem Statement

Given an array and a target element, determine whether the target exists. If found, return its index (first occurrence, last occurrence, or all occurrences depending on the requirement).

## Best Approach

### Idea

Scan the array linearly and compare each element with the target. Stop early when the required occurrence is found, or collect every matching index when all occurrences are needed.

### Algorithm

**First occurrence**

1. Traverse the array from index `0` to `n - 1`.
2. If `arr[i] == target`, return `i`.
3. If the loop finishes, return `-1`.

**Last occurrence**

1. Traverse the array from index `n - 1` down to `0`.
2. If `arr[i] == target`, return `i`.
3. If the loop finishes, return `-1`.

**All occurrences**

1. Create an empty list.
2. Traverse the array from left to right.
3. Add index `i` to the list whenever `arr[i] == target`.
4. Return the list.

### Time Complexity

`O(N)` for first and last occurrence because each element is checked at most once.

`O(N)` for all occurrences because the full array is scanned once.

### Space Complexity

`O(1)` for first and last occurrence because only loop variables are used.

`O(K)` for all occurrences, where `K` is the number of matches, because indexes are stored in a list.

### Key Points

- Works on unsorted arrays; no preprocessing is required.
- Returning `-1` is the standard way to signal "not found" for index-based search.
- For last occurrence, reverse traversal avoids a second pass.
- For all occurrences, an `ArrayList<Integer>` is a simple and readable choice.

### Code

```java
static int returnTheFirstOccurenceIndex(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i;
        }
    }
    return -1;
}

static int returnTheLastOccurenceIndex(int[] arr, int target) {
    for (int i = arr.length - 1; i >= 0; i--) {
        if (arr[i] == target) {
            return i;
        }
    }
    return -1;
}

static ArrayList<Integer> returnAllTheOccurenceIndexes(int[] arr, int target) {
    ArrayList<Integer> indexes = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            indexes.add(i);
        }
    }
    return indexes;
}
```

---

# 9. Second Largest and Second Smallest

## Problem Statement

Find the second distinct largest and second distinct smallest elements in an array.

## Best Approach

### Idea

Track the two smallest and two largest values in separate single-pass traversals. Each update mirrors the logic used for finding the second largest element.

### Algorithm

**Second smallest**

1. Initialize `firstMin = Integer.MAX_VALUE` and `secondMin = Integer.MAX_VALUE`.
2. Traverse the array.
3. If the current element is smaller than `firstMin`, shift `firstMin` to `secondMin` and update `firstMin`.
4. Otherwise, if it is greater than `firstMin` but smaller than `secondMin`, update `secondMin`.
5. After traversal, return `secondMin`.

**Second largest**

1. Initialize `firstMax = Integer.MIN_VALUE` and `secondMax = Integer.MIN_VALUE`.
2. Traverse the array.
3. If the current element is greater than `firstMax`, shift `firstMax` to `secondMax` and update `firstMax`.
4. Otherwise, if it is smaller than `firstMax` but greater than `secondMax`, update `secondMax`.
5. After traversal, return `secondMax`.

### Time Complexity

`O(N)` for each function because the array is scanned once per call.

`O(N)` overall if both values are needed, since two linear passes are still linear time.

### Space Complexity

`O(1)` because only a constant number of variables are used.

### Key Points

- "Second smallest" and "second largest" usually mean second distinct values.
- Arrays with fewer than two distinct elements may not have a valid answer.
- The second-smallest logic is the mirror of the second-largest logic.
- Two separate passes are clear and still optimal for interview purposes.

### Code

```java
static int findSecondSmallest(int[] arr) {
    int firstMin = Integer.MAX_VALUE;
    int secondMin = Integer.MAX_VALUE;

    for (int num : arr) {
        if (num < firstMin) {
            secondMin = firstMin;
            firstMin = num;
        } else if (num > firstMin && num < secondMin) {
            secondMin = num;
        }
    }

    return secondMin;
}

static int findSecondLargest(int[] arr) {
    int firstMax = Integer.MIN_VALUE;
    int secondMax = Integer.MIN_VALUE;

    for (int num : arr) {
        if (num > firstMax) {
            secondMax = firstMax;
            firstMax = num;
        } else if (num < firstMax && num > secondMax) {
            secondMax = num;
        }
    }

    return secondMax;
}
```

---

# 10. Union of Two Sorted Arrays

## Problem Statement

Given two sorted arrays, return the union containing all distinct elements from both arrays in sorted order.

## Brute Force Approach

### Idea

Build a result list by adding elements from both arrays one by one. Before adding, check whether the element already exists in the list. After both arrays are processed, sort the list and return it.

### Algorithm

1. Create an empty `ArrayList<Integer>`.
2. Traverse the first array and add each element only if it is not already present in the list.
3. Traverse the second array and add each element only if it is not already present in the list.
4. Sort the list.
5. Return the sorted list as the union.

### Time Complexity

`O((N + M)^2 + U log U)` where `N` and `M` are the sizes of the two arrays and `U` is the number of distinct elements in the union.

The duplicate check scans the list linearly, and sorting adds `O(U log U)`.

### Space Complexity

`O(N + M)` because the result list can store at most all distinct elements from both arrays.

### Key Points

- Easy to understand and implement.
- Works even if the input arrays are not sorted, though this problem gives sorted arrays.
- Duplicate checking with a linear scan makes this approach inefficient for large inputs.

### Code

```java
static ArrayList<Integer> findUnionBRUTE(int[] a1, int[] a2) {
    ArrayList<Integer> list = new ArrayList<>();

    for (int element : a1) {
        if (!contains(list, element)) {
            list.add(element);
        }
    }

    for (int element : a2) {
        if (!contains(list, element)) {
            list.add(element);
        }
    }

    Collections.sort(list);
    return list;
}

static boolean contains(ArrayList<Integer> list, int value) {
    for (int i = 0; i < list.size(); i++) {
        if (value == list.get(i)) {
            return true;
        }
    }
    return false;
}
```

## Better Approach

### Idea

Use a `TreeSet` to insert all elements from both arrays. A set removes duplicates automatically, and a tree set keeps elements sorted.

### Algorithm

1. Create an empty `TreeSet<Integer>`.
2. Insert every element from the first array into the set.
3. Insert every element from the second array into the set.
4. Convert the set into an `ArrayList` and return it.

### Time Complexity

`O((N + M) log(N + M))` because each insertion into a tree set takes logarithmic time.

### Space Complexity

`O(N + M)` to store all distinct elements in the set.

### Key Points

- Cleaner than manually checking duplicates and sorting a list.
- Output is automatically sorted because `TreeSet` maintains order.
- Still not the most optimal approach when both input arrays are already sorted.

### Code

```java
static List<Integer> findUnionBETTER(int[] a1, int[] a2) {
    Set<Integer> st = new TreeSet<>();

    for (int i : a1) {
        st.add(i);
    }

    for (int i : a2) {
        st.add(i);
    }

    return new ArrayList<>(st);
}
```

---

# 11. Find The Missing Number

## Problem Statement

Given an array containing `N - 1` distinct numbers from `1` to `N`, find the one missing number.

## Brute Force Approach

### Idea

For every number from `1` to `N`, check whether it exists in the array by scanning the array linearly.

### Algorithm

1. Loop `i` from `1` to `N - 1`.
2. For each `i`, scan the entire array to see if `i` is present.
3. If `i` is not found, it is the missing number.

### Time Complexity

`O(N^2)` because each value from `1` to `N` may require a full array scan.

### Space Complexity

`O(1)` because only a flag variable is used.

### Key Points

- Simple and works without extra data structures.
- Inefficient for large values of `N`.
- Assumes numbers are in the range `1` to `N` with exactly one missing value.

### Code

```java
static void brute(int[] a, int n) {
    for (int i = 1; i < n; i++) {
        int flag = 0;
        for (int j = 0; j < n - 1; j++) {
            if (a[j] == i) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            System.out.println("The Missing Number is: " + i);
        }
    }
}
```

## Better Approach

### Idea

Use a hash array to mark which numbers from `1` to `N` are present, then return the unmarked index.

### Algorithm

1. Create a hash array of size `N + 1`.
2. Mark `hashArray[a[i]] = 1` for every element in the input array.
3. Traverse from `1` to `N - 1` and return the first index whose mark is still `0`.

### Time Complexity

`O(N)` because the array is traversed a constant number of times.

### Space Complexity

`O(N)` because a hash array of size `N + 1` is used.

### Key Points

- Much faster than the brute force nested-loop check.
- Easy to extend if multiple missing numbers need to be tracked.
- Uses extra space compared with the sum approach.

### Code

```java
static int better(int[] a, int n) {
    int[] hashArray = new int[n + 1];

    for (int i = 0; i < n - 1; i++) {
        hashArray[a[i]] = 1;
    }

    for (int i = 1; i < n; i++) {
        if (hashArray[i] == 0) {
            return i;
        }
    }

    return -1;
}
```

## Optimized Approach

### Idea

Use the sum formula for the first `N` natural numbers and subtract the sum of the array elements. The difference is the missing number.

### Algorithm

1. Compute `sumOfN = N * (N + 1) / 2`.
2. Compute the sum of all elements in the array.
3. Return `sumOfN - sumOfArr`.

### Time Complexity

`O(N)` because the array is summed once.

### Space Complexity

`O(1)` because only a few integer variables are used.

### Key Points

- Optimal space solution for this version of the problem.
- Works only when numbers are exactly `1` to `N` with one missing value.
- Be careful with overflow for very large `N` in languages with fixed integer sizes.

### Code

```java
static void optimizedSum(int[] a, int n) {
    int sumOfN = n * (n + 1) / 2;
    int sumOfArr = 0;

    for (int i = 0; i < a.length; i++) {
        sumOfArr += a[i];
    }

    System.out.println(sumOfN - sumOfArr);
}
```

---

# 12. Max Consecutive Ones

## Problem Statement

Given a binary array containing only `0`s and `1`s, find the maximum number of consecutive `1`s.

## Best Approach

### Idea

Traverse the array once while maintaining a running count of consecutive `1`s. Reset the count when a `0` appears and update the maximum whenever the current streak grows.

### Algorithm

1. Initialize `count = 0` and `maxCount = 0`.
2. Traverse the array from left to right.
3. If the current element is `1`, increment `count` and update `maxCount`.
4. If the current element is `0`, reset `count` to `0`.
5. Return `maxCount`.

### Time Complexity

`O(N)` because the array is scanned once.

### Space Complexity

`O(1)` because only constant extra variables are used.

### Key Points

- Classic single-pass counting problem.
- The streak resets immediately after encountering a `0`.
- Works for empty arrays if handled separately, otherwise `maxCount` stays `0`.

### Code

```java
static int findMaxConsecutiveOnes(int[] nums) {
    int maxCount = 0;
    int count = 0;

    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 1) {
            count++;
            if (count > maxCount) {
                maxCount = count;
            }
        } else {
            count = 0;
        }
    }

    return maxCount;
}
```

---

# 13. Intersection of Two Sorted Arrays

## Problem Statement

Given two sorted arrays, return their intersection. Depending on the requirement, the answer may include duplicates present in both arrays or only the distinct common elements.

## Brute Force Approach

### Idea

For each element in the first array, scan the second array and add the first unmatched equal element. Use a visited array so each element in the second array is used at most once.

### Algorithm

1. Create an empty result list and a `vis` array for the second array.
2. Traverse the first array element by element.
3. For each element, scan the second array until a match is found or an element larger than the current value appears.
4. If a match is found and that second-array index is unused, add it to the result and mark it visited.
5. Return the result list.

### Time Complexity

`O(N * M)` in the worst case, where `N` and `M` are the sizes of the two arrays.

The sorted order allows early breaking, but nested loops still make this approach slower than two pointers.

### Space Complexity

`O(M)` for the visited array, plus space for the result list.

### Key Points

- Preserves duplicate intersection values when both arrays contain repeated elements.
- The `vis` array prevents reusing the same element from the second array.
- Early break on `b[j] > a[i]` uses the sorted property.

### Code

```java
static ArrayList<Integer> brute(int[] a, int[] b) {
    ArrayList<Integer> list = new ArrayList<>();

    int n1 = a.length;
    int n2 = b.length;
    int[] vis = new int[n2];

    for (int i = 0; i < n1; i++) {
        for (int j = 0; j < n2; j++) {
            if (a[i] == b[j] && vis[j] == 0) {
                list.add(b[j]);
                vis[j] = 1;
                break;
            }
            if (b[j] > a[i]) {
                break;
            }
        }
    }

    return list;
}
```

## Optimized Two Pointer Approach

### Idea

Use two pointers to traverse both sorted arrays simultaneously. Whenever both pointers refer to equal values, add that value to the result and move both pointers forward.

### Algorithm

1. Initialize `i = 0` and `j = 0`.
2. While both pointers are in range:
   - If `a[i] < b[j]`, increment `i`.
   - If `a[i] == b[j]`, add the value and increment both pointers.
   - If `a[i] > b[j]`, increment `j`.
3. Return the result list.

### Time Complexity

`O(N + M)` because each pointer moves only forward.

### Space Complexity

`O(1)` extra space excluding the output list.

### Key Points

- Standard optimal approach for sorted-array intersection.
- Includes duplicates when both arrays contain the same value multiple times.
- Much cleaner and faster than nested loops.

### Code

```java
static ArrayList<Integer> optimizedTwoPointer(int[] a, int[] b) {
    ArrayList<Integer> list = new ArrayList<>();

    int i = 0, j = 0;
    int n1 = a.length, n2 = b.length;

    while (i < n1 && j < n2) {
        if (a[i] < b[j]) {
            i++;
        } else if (a[i] == b[j]) {
            list.add(b[j]);
            i++;
            j++;
        } else {
            j++;
        }
    }

    return list;
}
```

## Unique Intersection Approach

### Idea

Use the same two-pointer traversal, but add a common value only once by comparing it with the last element already stored in the result list.

### Algorithm

1. Initialize `i = 0` and `j = 0`.
2. While both pointers are in range:
   - If `a[i] < b[j]`, increment `i`.
   - If `a[i] > b[j]`, increment `j`.
   - If they are equal, add `a[i]` only when it is not equal to the last result element, then increment both pointers.
3. Return the result list.

### Time Complexity

`O(N + M)` because both arrays are scanned once with two pointers.

### Space Complexity

`O(1)` extra space excluding the output list.

### Key Points

- Useful when the answer must contain distinct common elements only.
- The last-element check avoids duplicate entries in the result.
- Same traversal pattern as union/intersection two-pointer problems.

### Code

```java
static ArrayList<Integer> uniqueIntersection(int[] a, int[] b) {
    ArrayList<Integer> list = new ArrayList<>();

    int i = 0, j = 0;
    int n1 = a.length;
    int n2 = b.length;

    while (i < n1 && j < n2) {
        if (a[i] < b[j]) {
            i++;
        } else if (a[i] > b[j]) {
            j++;
        } else {
            if (list.size() == 0 || list.get(list.size() - 1) != a[i]) {
                list.add(a[i]);
            }
            i++;
            j++;
        }
    }

    return list;
}
```
