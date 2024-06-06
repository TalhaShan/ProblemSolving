package STRIVER_SHEET.Sliding_Two_Pointers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubString {

    int findMaxSubStringLength(String s) {
        int left = 0;
        int right = 0;
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (map.containsKey(current)) {
                left = map.get(current) + 1;
                map.put(current, i);
            } else {
                map.put(current, i);
                len = right - left + 1;
                max = Math.max(max, len);
                right++;

            }

        }
        return max;
    }

    //COOL
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        int max = 0;
        Set<Character> unique = new HashSet<>();
        while (i < s.length()) {
            if (!unique.contains(s.charAt(i))) {
                unique.add(s.charAt(i));
                max = Math.max(max, unique.size());
                i++;
            } else {
                unique.remove(s.charAt(j));
                j++;
            }
        }
        return max;

    }
}
