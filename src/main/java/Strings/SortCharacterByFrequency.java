package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharacterByFrequency {

//    Example 1:
//
//    Input: s = "tree"
//    Output: "eert"
//    Explanation: 'e' appears twice while 'r' and 't' both appear once.
//            So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
//            Example 2:
//
//    Input: s = "cccaaa"
//    Output: "aaaccc"
//    Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
//    Note that "cacaca" is incorrect, as the same characters must be together.
//    Example 3:
//
//    Input: s = "Aabb"
//    Output: "bbAa"
//    Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
//    Note that 'A' and 'a' are treated as two different characters.


    public static String frequencySort(String s) {

        Map<Character,Integer> map = new HashMap<>();
        StringBuilder res= new StringBuilder();
        for(Character ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        List<Character> characterList = new ArrayList<>(map.keySet());
      // characterList.sort((ob1,ob2)-> map.get(ob1)-map.get(ob2));
        characterList.sort(Comparator.comparingInt(map::get).reversed());
        for(Character ch:characterList){
            int freq = map.get(ch);
            while (freq >0){
                res.append(ch);
                freq--;
            }
        }
        return res.toString();
    }
    public static String frequencySort2DidNotWork(String s) {
        int[] freq = new int[128];
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i)-'0']++;
        }
        Arrays.sort(freq);
        for (int i = freq.length - 1; i >= 0; i--) {
            while (freq[i] > 0) {
                char found = (char)(i + '0');
                sb.append(found);
                freq[i]--;
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }

}
