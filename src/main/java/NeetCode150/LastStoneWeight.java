package NeetCode150;

import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); //assuming first one is biggest as descending order of queue
            int x = maxHeap.poll();
            if (y != x) { //only add if difference is not 0 else ignored
                maxHeap.add(y - x);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll(); //the remainng one
    }
}
/*
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); //assuming first one is biggest as descending order of queue
            int x = maxHeap.poll();
            if (y != x) { //only add if difference is not 0 else ignored
                maxHeap.offer(y - x);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll(); //the remainng one
    }
}
 */
/*
In a Java `Queue`, **`offer()` and `add()` usually do the same thing**, but there’s one important difference:

| Method     | If queue accepts element | If queue is full                               |
| ---------- | ------------------------ | ---------------------------------------------- |
| `add(e)`   | Adds `e`                 | **Throws exception** (`IllegalStateException`) |
| `offer(e)` | Adds `e`                 | **Returns `false`**                            |

### Example with a bounded queue

```java
Queue<Integer> q = new ArrayBlockingQueue<>(2);

q.add(10);       // true-ish: returns normally
q.add(20);       // returns normally

q.add(30);       // ❌ IllegalStateException
```

With `offer()`:

```java
Queue<Integer> q = new ArrayBlockingQueue<>(2);

q.offer(10);     // true
q.offer(20);     // true
q.offer(30);     // false
```

### Why does Java have both?

It's part of the **`Queue` API design**:

* `add()` → "I expect this insertion to succeed; tell me with an exception if it can't."
* `offer()` → "Try to insert it; if you can't, just tell me `false`."

This becomes especially important with **bounded queues** such as:

```java
ArrayBlockingQueue
```

For an **unbounded queue** like `LinkedList` or `PriorityQueue`, there's generally no practical difference because the queue doesn't normally become full:

```java
q.add(x);
q.offer(x);
```

Both will normally succeed.

**Easy interview memory trick:**

> `add` = **exception on failure**
> `offer` = **false on failure**

Also, `poll()` vs `remove()` and `peek()` vs `element()` follow the same design pattern.

 */
