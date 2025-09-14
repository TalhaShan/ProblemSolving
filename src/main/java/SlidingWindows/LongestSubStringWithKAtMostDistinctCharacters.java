package SlidingWindows;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestSubStringWithKAtMostDistinctCharacters {

        public int longestkSubstr(String s, int k) {
            // code here
            int maxlen=-1;
            int n=s.length();
            HashSet<Character> map=new HashSet<>();
            for(int i=0;i<n;i++){
                map.clear();
                for(int j=i;j<n;j++){
                    map.add(s.charAt(j));
                    //ask map for are you distinct
                    if(map.size()<=k){
                        //distinct vaye
                        maxlen=Math.max(maxlen,j-i+1);
                    }else{
                        break;
                    }
                }
            }
            return maxlen;
        }
    // T O (2N)
    // S O (256)

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0 || s.length() == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            // shrink window if more than k distinct characters
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
