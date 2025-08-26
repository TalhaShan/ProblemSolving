package SlidingWindows;

import java.util.HashMap;
import java.util.Map;

public class MaximumFruitsBasket {
    public int totalFruitWithArrayBetter(int[] fruits) {
        int n = fruits.length;
        int[] freq = new int[n];  // ⚠️ works only if fruit types < n
        int left = 0, maxFruits = 0, distinct = 0;

        for (int right = 0; right < n; right++) {
            if (freq[fruits[right]] == 0) {
                distinct++;
            }
            freq[fruits[right]]++;

            while (distinct > 2) {
                freq[fruits[left]]--;
                if (freq[fruits[left]] == 0) {
                    distinct--;
                }
                left++;
            }

            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }
    public int totalFruitWithMapBetter(int[] fruits) {
    Map<Integer, Integer> basket = new HashMap<>();
    int left = 0;
    int right = 0;
    int maxFruits = 0;

        for (right = 0; right < fruits.length; right++) {
        // Add current to basket
        int currentCount = basket.getOrDefault(fruits[right], 0);
        basket.put(fruits[right], currentCount + 1);

        // If basket has more than 2 type of fruits,
        // start emptying the basket
        while (basket.size() > 2) {
            int fruitCount = basket.get(fruits[left]);
            if (fruitCount == 1)
                basket.remove(fruits[left]);
            else
                basket.put(fruits[left], fruitCount - 1);
            left++;
        }

        maxFruits = Math.max(maxFruits, right - left + 1);
    }
        return maxFruits;
}

    public int totalFruitWithArrayOptimal(int[] fruits) {
        int n = fruits.length;
        int[] freq = new int[n];  // ⚠️ works only if fruit types < n
        int left = 0, maxFruits = 0, distinct = 0;

        for (int right = 0; right < n; right++) {
            if (freq[fruits[right]] == 0) {
                distinct++;
            }
            freq[fruits[right]]++;

            if (distinct > 2) {
                freq[fruits[left]]--;
                if (freq[fruits[left]] == 0) {
                    distinct--;
                }
                left++;
            }

            if(distinct>=2) {
                maxFruits = Math.max(maxFruits, right - left + 1);
            }
        }

        return maxFruits;
    }
}
