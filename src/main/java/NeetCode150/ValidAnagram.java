package NeetCode150;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length()) {
            return false;
        }

        //
        int[] charCount= new int[26];
        //Idea is to match the frequency or it should be sae for final reason will be 0
        for(int i =0 ; i<s.length() ;i++){
            charCount[s.charAt(i)-'a']++;
            charCount[t.charAt(i)-'a']--;
        }

        for(int x:charCount){
            if(x!=0){
                return false;
            }
        }

    return true;

    }
}
