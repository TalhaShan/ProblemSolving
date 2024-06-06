package STRIVER_SHEET.Sliding_Two_Pointers;

import java.util.Arrays;
import java.util.HashSet;

public class NumberOfSubStringContainingUniqueCharacter {

    public int numberOfSubstrings(String s) {
        int len = 0;
        int r = 0;
        int[] arr = new int[3];
        Arrays.fill(arr, -1);
        while (r < s.length()) {
            arr[s.charAt(r) - 'a'] = r;
            if (arr[0] != -1 && arr[1] != -1 && arr[2] != -1) {
                len = len + 1 + Math.min(arr[0], Math.min(arr[1], arr[2]));

            }
            r++;
        }
        return len;
    }

    public static int countSubstring(String s) {
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> mpp = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                mpp.add(s.charAt(j));
                if (mpp.size() == 3 && mpp.contains('a') && mpp.contains('b') && mpp.contains('c')) {
                    len++;
                } else if (mpp.size() > 0 && !(mpp.contains('a') || mpp.contains('b') || mpp.contains('c'))) {
                    break;
                }
            }
        }
        return len;
    }
}

