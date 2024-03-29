package Strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
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

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcbbbbb"));
    }

}
