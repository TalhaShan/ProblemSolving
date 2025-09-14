package SlidingWindows;

import java.util.HashMap;

public class MinWindowSubString {

    public String minWindow(String s, String t) {

        String ans = "";
        int left = 0, right = 0;
        int min = Integer.MAX_VALUE;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int k = 0; k < t.length(); k++)
        {
            char c = t.charAt(k);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = map.size();
        for (right = 0; right < s.length(); right++)
        {
            char c = s.charAt(right);
            if (map.containsKey(c))
            {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0)  /// one of the condition of char satisfies in the window
                    count--;
            }
            if (count == 0)   //all conditions satisfies windows is valid
            {
                while (count == 0)  //lets try to optimize pointer and move right pointer
                {
                    char c1 = s.charAt(left);
                    if (min > right - left + 1)
                    {
                        ans = s.substring(left, right + 1);
                        min = Math.min(min, right - left + 1);

                    }

                    if (map.containsKey(c1)) {
                        map.put(c1, map.get(c1) + 1);  //doing reverse as we remove element via left++
                        if (map.get(c1) > 0)  // window becomes invalid so increment count
                            count++;
                    }
                    left++;
                }
            }
        }
        return ans;
    }
}
