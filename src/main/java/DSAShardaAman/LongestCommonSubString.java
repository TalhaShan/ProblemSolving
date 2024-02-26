package DSAShardaAman;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonSubString {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> unique = new HashSet<>();
        int i=0,j=0;
        int len =0;
        while (i<s.length()){
            if(!unique.contains(s.charAt(i))){
                unique.add(s.charAt(i));
                len = Math.max(len,unique.size());
                i++;
            }else {
                //jb tk wo repeatin nai hat jata tb tk wo repating uss se phela sb remove
                //we are finding heresubstring not subsequnce rememeber

                unique.remove(s.charAt(j));
                j++;

            }

        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
