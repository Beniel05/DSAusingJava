# 1. Number Frequency Queries Using Array Hashing

## Problem Statement

Given an array of integers and multiple queries, return how many times each queried number appears.

## Best Approach

### Idea

When the value range is small, use an array as a frequency table where the index represents the number.

### Algorithm

1. Find the maximum value in the array.
2. Create a hash array of size `max + 1`.
3. Traverse the array and increment `hash[arr[i]]`.
4. For each query number, answer directly using `hash[number]`.

### Time Complexity

- Preprocessing: `O(N)`
- Each query: `O(1)`

### Space Complexity

`O(max)` because the frequency array size depends on the maximum value.

### Key Points

- Very fast for small ranges.
- Not suitable when values are very large or sparse.
- Negative values are not directly handled in this version.

### Code

```java
static int[] buildFrequencyArray(int[] arr) {
    int max = Integer.MIN_VALUE;
    for (int num : arr) {
        max = Math.max(max, num);
    }

    int[] hash = new int[max + 1];
    for (int num : arr) {
        hash[num]++;
    }

    return hash;
}
```

---

# 2. Character Frequency Queries Using Array Hashing

## Problem Statement

Given a string and multiple character queries, return how many times each queried character appears.

## Best Approach

### Idea

Use a fixed-size frequency array and map each character to its ASCII value.

### Algorithm

1. Create a frequency array of size `256`.
2. Traverse the string and increment `hash[ch]`.
3. For each query character, return `hash[ch]`.

### Time Complexity

- Preprocessing: `O(N)`
- Each query: `O(1)`

### Space Complexity

`O(1)` because the array size is fixed at `256`.

### Key Points

- Best for ASCII-based character counting.
- For lowercase-only problems, size `26` is enough.
- Direct indexing makes lookup constant time.

### Code

```java
static int[] buildCharFrequency(String str) {
    int[] hash = new int[256];

    for (int i = 0; i < str.length(); i++) {
        hash[str.charAt(i)]++;
    }

    return hash;
}
```

---

# 3. Number Frequency Queries Using HashMap

## Problem Statement

Given an array of integers and multiple queries, return the frequency of each queried number using `HashMap`.

## Best Approach

### Idea

Use `HashMap<Integer, Integer>` to store only the values that actually appear.

### Algorithm

1. Create an empty `HashMap`.
2. Traverse the array.
3. For each value, update its count using `getOrDefault`.
4. For each query, return `map.getOrDefault(query, 0)`.

### Time Complexity

- Preprocessing: `O(N)` average
- Each query: `O(1)` average

### Space Complexity

`O(K)` where `K` is the number of distinct values.

### Key Points

- Handles large or sparse values efficiently.
- Supports negative numbers naturally.
- Preferred over array hashing when value range is unknown or huge.

### Code

```java
static Map<Integer, Integer> buildNumberFrequencyMap(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int num : arr) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    return map;
}
```

---

# 4. Character Frequency Queries Using HashMap

## Problem Statement

Given a string and multiple character queries, return character frequencies using `HashMap`.

## Best Approach

### Idea

Use `HashMap<Character, Integer>` so only existing characters are stored.

### Algorithm

1. Create an empty `HashMap<Character, Integer>`.
2. Traverse the string character by character.
3. Update each character count using `getOrDefault`.
4. For queries, return `map.getOrDefault(ch, 0)`.

### Time Complexity

- Preprocessing: `O(N)` average
- Each query: `O(1)` average

### Space Complexity

`O(K)` where `K` is the number of distinct characters.

### Key Points

- Better than fixed arrays when the character set is large or not limited to ASCII.
- Also works well for Unicode-aware variations with adjusted handling.

### Code

```java
static Map<Character, Integer> buildCharacterFrequencyMap(String str) {
    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    return map;
}
```
