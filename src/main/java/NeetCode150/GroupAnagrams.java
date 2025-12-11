package NeetCode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GroupAnagrams {


    public List<List<String>> groupAnagramsBetter(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<>());
            }
            ans.get(key).add(s);
        }

        return new ArrayList<>(ans.values());
        //O(NLOGN*M)
    }
    public List<List<String>> groupAnagramsOptimal(String[] strs) {

        if(strs.length == 0){
            return new ArrayList();
        }

        Map<String, List> ansMap = new HashMap<>();

        int[] count = new int[26];

        for(String s:strs){
            Arrays.fill(count, 0);
            for(char c:s.toCharArray()){
                count[c-'a']++;
            }

            StringBuilder sb = new StringBuilder("");

            for(int i=0; i<26; i++){
                sb.append("#");
                sb.append(count[i]);
            }
            String key = sb.toString();
            if(!ansMap.containsKey(key)){
                ansMap.put(key,new ArrayList());

            }
            ansMap.get(key).add(s);

        }

        return new ArrayList(ansMap.values());
        //O(N*M)
    }


}
