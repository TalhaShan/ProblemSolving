package Strings;

import java.util.HashMap;
import java.util.Map;

public class IsAnagramQ {
//    An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, using all
//    the original letters exactly once.
    public boolean isAnagram(String s, String t) {

        int[] count = new int[26];
        for(char x :s.toCharArray()){
            count[x-'a']++;
        }

        for(char x :t.toCharArray()){
            count[x-'a']--;
        }

        for(int val:count){
            if(val!=0) return false;
        }
        return true;
     }

    public boolean isAnagramHashMap(String s, String t) {
        // Create two HashMaps to store the frequency of characters
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        // Populate the map for string s
        for (char c : s.toCharArray()) {
            mapS.put(c, mapS.getOrDefault(c, 0) + 1);
        }

        // Populate the map for string t
        for (char c : t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        // Compare both maps
        return mapS.equals(mapT);
    }

    }
