package Strings;

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {

     Long count1 = getDistinctCharCount(s);
     Long count2 = getDistinctCharCount(t);

        return count1.equals(count2);
    }

    public static long getDistinctCharCount(String str) {
        return str.chars()
                .filter(c -> !Character.isWhitespace(c)) // optional
                .distinct()
                .count();
    }

    public boolean isIsomorphicOptimal(String s, String t) {
        //optimal

        int[] m1 = new int[128];
        int[] m2 = new int[128];

        for(int i=0; i<s.length(); i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
            m1[s.charAt(i)] = i+1;
            m2[t.charAt(i)] = i+1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("paper","title"));
    }
    /*
    Excellent observation — this method **looks mysterious at first**, but it’s actually a **very clever trick** to check if two strings are **isomorphic** using **constant space and time-efficient arrays**.

---

### 🔍 Let's break it down:

```java
int[] m1 = new int[128]; // Mapping for string s
int[] m2 = new int[128]; // Mapping for string t
```

* Each array stores the **last seen index + 1** of each character in `s` and `t`.
* `128` assumes only ASCII characters (which is fine for most cases).

---

### 🧠 Core Idea:

On each iteration:

```java
if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
```

* If the characters `s[i]` and `t[i]` have **different last seen positions**, the mapping is inconsistent → return false.

Then:

```java
m1[s.charAt(i)] = i + 1;
m2[t.charAt(i)] = i + 1;
```

* Set both to `i + 1` instead of `i` so that the **default value (0)** can still be used to mean "unseen".

---

### ✅ Why does this work?

Let’s look at a simple example:

```java
s = "paper"
t = "title"
```

At each step:

| i | s\[i] | t\[i] | m1\[s\[i]] | m2\[t\[i]] | Equal? | Set m1/s, m2/t |
| - | ----- | ----- | ---------- | ---------- | ------ | -------------- |
| 0 | p     | t     | 0          | 0          | ✅      | 1              |
| 1 | a     | i     | 0          | 0          | ✅      | 2              |
| 2 | p     | t     | 1          | 1          | ✅      | 3              |
| 3 | e     | l     | 0          | 0          | ✅      | 4              |
| 4 | r     | e     | 0          | 0          | ✅      | 5              |

No mismatches — so the strings are isomorphic.

---

### ❗ Why use `i + 1` instead of `i`?

Because:

* Arrays are initialized to `0` by default.
* So `m[c] = 0` means **character `c` hasn't been seen yet**.
* By storing `i + 1`, we distinguish between:

  * `0` (unseen)
  * `1+` (seen at some position)

---

### ✅ Pros:

* Very **fast** (O(n) time, O(1) space).
* No need for HashMaps.
* Simple and elegant once understood.

---

Let me know if you want to extend this for Unicode or make it more readable for beginners.
Absolutely! Let’s dry-run this algorithm on a few different examples, using the **table format** like before.

---

## ✅ Example 1:

### Input:

```java
s = "egg"
t = "add"
```

### Expected: `true` (isomorphic)

| i | s\[i] | t\[i] | m1\[s\[i]] | m2\[t\[i]] | Equal? | Update m1/s, m2/t      |
| - | ----- | ----- | ---------- | ---------- | ------ | ---------------------- |
| 0 | e     | a     | 0          | 0          | ✅      | m1\[e] = 1, m2\[a] = 1 |
| 1 | g     | d     | 0          | 0          | ✅      | m1\[g] = 2, m2\[d] = 2 |
| 2 | g     | d     | 2          | 2          | ✅      | m1\[g] = 3, m2\[d] = 3 |

✅ **All checks passed** → `true`

---

## ❌ Example 2:

### Input:

```java
s = "foo"
t = "bar"
```

### Expected: `false`

| i | s\[i] | t\[i] | m1\[s\[i]] | m2\[t\[i]] | Equal? | Update m1/s, m2/t      |
| - | ----- | ----- | ---------- | ---------- | ------ | ---------------------- |
| 0 | f     | b     | 0          | 0          | ✅      | m1\[f] = 1, m2\[b] = 1 |
| 1 | o     | a     | 0          | 0          | ✅      | m1\[o] = 2, m2\[a] = 2 |
| 2 | o     | r     | 2          | 0          | ❌      | — return false         |

❌ **Mismatch at index 2** → `false`

---

## ❌ Example 3:

### Input:

```java
s = "ab"
t = "aa"
```

### Expected: `false`

| i | s\[i] | t\[i] | m1\[s\[i]] | m2\[t\[i]] | Equal? | Update m1/s, m2/t      |
| - | ----- | ----- | ---------- | ---------- | ------ | ---------------------- |
| 0 | a     | a     | 0          | 0          | ✅      | m1\[a] = 1, m2\[a] = 1 |
| 1 | b     | a     | 0          | 1          | ❌      | — return false         |

❌ `b` maps to `a`, but `a` is already mapped to `a` → breaks bijection.

---

## ✅ Example 4:

### Input:

```java
s = "title"
t = "paper"
```

### Expected: `true`

| i | s\[i] | t\[i] | m1\[s\[i]] | m2\[t\[i]] | Equal? | Update m1/s, m2/t      |
| - | ----- | ----- | ---------- | ---------- | ------ | ---------------------- |
| 0 | t     | p     | 0          | 0          | ✅      | m1\[t] = 1, m2\[p] = 1 |
| 1 | i     | a     | 0          | 0          | ✅      | m1\[i] = 2, m2\[a] = 2 |
| 2 | t     | p     | 1          | 1          | ✅      | m1\[t] = 3, m2\[p] = 3 |
| 3 | l     | e     | 0          | 0          | ✅      | m1\[l] = 4, m2\[e] = 4 |
| 4 | e     | r     | 0          | 0          | ✅      | m1\[e] = 5, m2\[r] = 5 |

✅ All consistent → `true`

---

Would you like to test this on your original example `"bbbaaaba"` and `"aaabbbba"`? I can break that one down too.

     */
}
