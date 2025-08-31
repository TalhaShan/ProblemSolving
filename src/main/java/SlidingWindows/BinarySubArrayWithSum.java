package SlidingWindows;

import java.util.HashMap;
import java.util.Map;

public class BinarySubArrayWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int res = 0;
        int ps = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            ps += nums[i];
            res += map.getOrDefault(ps - goal, 0);
            map.put(ps, map.getOrDefault(ps, 0) + 1);
        }
        return res;
    }
}

/*
Got it 👍 Let’s walk through the code **iteration by iteration** using the example:

**Input:**
`nums = [1, 0, 1, 0, 1], goal = 2`

---

### Initial Setup

* `res = 0` (result counter)
* `ps = 0` (prefix sum so far)
* `map = {0:1}` (prefix sum frequencies → means there is **one way** to have sum 0 before starting)

---

### Iteration 1: `i = 0`, `nums[0] = 1`

* `ps = ps + nums[0] = 0 + 1 = 1`
* We look for `(ps - goal) = (1 - 2) = -1` in `map` → not found → contributes **0**.
* `res = 0 + 0 = 0`
* Update map: `map[1] = map.getOrDefault(1,0)+1 = 1`

👉 `map = {0:1, 1:1}`
👉 `res = 0`

---

### Iteration 2: `i = 1`, `nums[1] = 0`

* `ps = 1 + 0 = 1`
* Look for `(ps - goal) = (1 - 2) = -1` → not found.
* `res = 0`
* Update map: `map[1] = 1 + 1 = 2`

👉 `map = {0:1, 1:2}`
👉 `res = 0`

---

### Iteration 3: `i = 2`, `nums[2] = 1`

* `ps = 1 + 1 = 2`
* Look for `(ps - goal) = (2 - 2) = 0` → found in `map` with count `1`.
* `res = 0 + 1 = 1`
* Update map: `map[2] = 1`

👉 `map = {0:1, 1:2, 2:1}`
👉 `res = 1`

✅ Subarray `[1,0,1]` found.

---

### Iteration 4: `i = 3`, `nums[3] = 0`

* `ps = 2 + 0 = 2`
* Look for `(2 - 2) = 0` → found with count `1`.
* `res = 1 + 1 = 2`
* Update map: `map[2] = 1 + 1 = 2`

👉 `map = {0:1, 1:2, 2:2}`
👉 `res = 2`

✅ Subarray `[0,1,0,1]` found.

---

### Iteration 5: `i = 4`, `nums[4] = 1`

* `ps = 2 + 1 = 3`
* Look for `(ps - goal) = (3 - 2) = 1` → found in `map` with count `2`.
* `res = 2 + 2 = 4`
* Update map: `map[3] = 1`

👉 `map = {0:1, 1:2, 2:2, 3:1}`
👉 `res = 4`

✅ Subarrays ending here: `[1,0,1]` and `[1,0,1,0,1]`.

---

### Final Answer:

`res = 4` ✅

---

### The 4 valid subarrays are:

1. `[1,0,1]` (indices 0–2)
2. `[1,0,1,0]` (indices 0–3)
3. `[0,1,0,1]` (indices 1–4)
4. `[1,0,1]` (indices 2–4)

 */