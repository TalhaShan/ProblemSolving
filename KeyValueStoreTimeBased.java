package NeetCode150;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class KeyValueStoreTimeBased {

    class TimeMap {

        private Map<String, TreeMap<Integer,String>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {

            map.computeIfAbsent(key,k-> new TreeMap<>()).put(timestamp,value);
        }

        public String get(String key, int timestamp) {
            TreeMap<Integer,String> treeMap = map.get(key);
            if (treeMap == null) {
                return "";
            }

            Map.Entry<Integer,String>  entry = treeMap.floorEntry(timestamp);
            return entry == null ? "" : entry.getValue();
        }
    }
/*
`TreeMap` in Java stores keys in **sorted order** and provides navigation methods to find entries relative to a given key.

## `floorEntry(K key)`

Returns the **key-value pair with the greatest key less than or equal to the given key**.

### Example

```java
import java.util.TreeMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();

        map.put(10, "A");
        map.put(20, "B");
        map.put(30, "C");
        map.put(40, "D");

        Map.Entry<Integer, String> entry = map.floorEntry(25);

        System.out.println(entry);
    }
}
```

### Output

```text
20=B
```

Because `20` is the largest key ≤ `25`.

### More Examples

| Call             | Result |
| ---------------- | ------ |
| `floorEntry(30)` | `30=C` |
| `floorEntry(25)` | `20=B` |
| `floorEntry(5)`  | `null` |

---

## Other Useful TreeMap Navigation Methods

### 1. `ceilingEntry(K key)`

Returns the **smallest key greater than or equal to the given key**.

```java
System.out.println(map.ceilingEntry(25));
```

Output:

```text
30=C
```

---

### 2. `lowerEntry(K key)`

Returns the **greatest key strictly less than the given key**.

```java
System.out.println(map.lowerEntry(30));
```

Output:

```text
20=B
```

```java
System.out.println(map.lowerEntry(10));
```

Output:

```text
null
```

---

### 3. `higherEntry(K key)`

Returns the **smallest key strictly greater than the given key**.

```java
System.out.println(map.higherEntry(30));
```

Output:

```text
40=D
```

---

### 4. `firstEntry()`

Returns the first (smallest key) entry.

```java
System.out.println(map.firstEntry());
```

Output:

```text
10=A
```

---

### 5. `lastEntry()`

Returns the last (largest key) entry.

```java
System.out.println(map.lastEntry());
```

Output:

```text
40=D
```

---

## Real-world Use Case: Finding the Closest Previous Timestamp

```java
TreeMap<Long, String> logs = new TreeMap<>();

logs.put(1000L, "Start");
logs.put(2000L, "Login");
logs.put(3000L, "Purchase");

System.out.println(logs.floorEntry(2500L));
```

Output:

```text
2000=Login
```

This is useful when you need the latest event that occurred **at or before** a given time.

---

## Quick Summary

| Method            | Meaning                     |
| ----------------- | --------------------------- |
| `floorEntry(k)`   | Greatest key ≤ k            |
| `floorKey(k)`     | Greatest key ≤ k (key only) |
| `ceilingEntry(k)` | Smallest key ≥ k            |
| `ceilingKey(k)`   | Smallest key ≥ k (key only) |
| `lowerEntry(k)`   | Greatest key < k            |
| `higherEntry(k)`  | Smallest key > k            |
| `firstEntry()`    | Smallest entry              |
| `lastEntry()`     | Largest entry               |

These methods make `TreeMap` very useful for range queries, scheduling systems, nearest-value lookups, leaderboards, and time-series data.

 */
}
