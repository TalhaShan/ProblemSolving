package Strings;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String str) {

        if(str.length() <=1) return str;

        String lps = "";
        for(int i=1; i<str.length(); i++){
        //odd case
            int low = i;
            int high=i;

            while (str.charAt(low) == str.charAt(high)){
                low--;
                high++;
                if(low == -1 || high == str.length()) {
                    break;
                }
            }
            //when loops break so low+1 and high same as end index is excursive in substring function
            String plaindromString = str.substring(low+1,high);
            if(plaindromString.length()>lps.length()){
                lps = plaindromString;
            }

            //even case -> baab
            low = i-1;  //why not low = i and high = i+1 well it can be but it will be index out of bound as we are not have any measure for
                        // higher boundary *initially* later we do have, but initially we have for lower boundary as it start from i =1;
            high = i;
            while (str.charAt(low) == str.charAt(high)){
                low--;
                high++;
                if(low == -1 || high == str.length()) {
                    break;
                }
            }
            //similar
            plaindromString = str.substring(low+1,high);
            if(plaindromString.length()>lps.length()){
                lps = plaindromString;
            }

        }
        return lps;
    }
}
