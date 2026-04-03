package NeetCode150;

import java.util.HashSet;

public class LongestCommonSubString {

    int lengthOfLongestSubstring(String s) {

        if(s==null || s.length()==0) return 0;
        if(s.length()==1) return 1;

        int left=0;
        int right=0;
        int max=0;
        HashSet<Character> unique =new HashSet<>();
        while (right < s.length()) {
            Character c=s.charAt(right);
            if(unique.contains(c)){
                unique.remove(s.charAt(left));
                left++;
            }else{
                unique.add(c);
                right++;
                max=Math.max(max,unique.size());
            }
        }
        return max;
    }
}
