package Strings;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs);
        //        Arrays.sort(strs, String.CASE_INSENSITIVE_ORDER);
        if(strs.length==1) return strs[0];
        StringBuilder res = new StringBuilder();
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();

        for (int i = 1; i < first.length - 1; i++) {
            if (first[i] != last[i]) {
                break;
            }
            res.append(first[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
       String result = longestCommonPrefix(new String[]{"ab","a"});
        System.out.println("resulktr:"+ result);
    }


    /*
    That’s a **very thoughtful question**, and you're almost right — but let’s break it down carefully:

---

### 🔍 Your Assumption:

> “Wouldn’t `first` (i.e., `strs[0]`) always be the shortest string after sorting?”

### ❌ Not necessarily.

Sorting by default (`Arrays.sort(strs)`) sorts **lexicographically**, not by string **length**.

#### For example:

```java
String[] strs = {"apple", "a", "apricot"};
Arrays.sort(strs);
System.out.println(Arrays.toString(strs));
```

**Output:**

```
[a, apple, apricot]
```

Here, `"a"` comes first (shortest), but **not because it's the shortest**, but because it's lexicographically smallest.

Now try this:

```java
String[] strs = {"abc", "ab", "abcd"};
Arrays.sort(strs);
System.out.println(Arrays.toString(strs));
```

**Output:**

```
[ab, abc, abcd]
```

Here, `strs[0]` is `"ab"` (shorter), but what if you had:

```java
String[] strs = {"aa", "aZ"};
```

Lexicographically:

* `"aZ"` comes **after** `"aa"` because `'Z' > 'a'` in ASCII.

So:

```java
Arrays.sort(new String[]{"aa", "aZ"});
// → ["aZ", "aa"]
```

Now `"aZ"` is first, but it’s **not** the shortest!

---

### ✅ So, Why `minLength`?

Because to compare two strings character by character, we must avoid going **out of bounds** — we only compare up to the **length of the shorter string**.

If you skip `minLength`, you risk a `StringIndexOutOfBoundsException`.

---

### 🔁 TL;DR:

* Lexicographic sorting does **not guarantee** the first string is shortest.
* Use `minLength = Math.min(first.length, last.length)` to safely compare characters.

     */
}
