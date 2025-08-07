package Strings;

public class BeautyOfTheSubString {

    public static void calculateSubString(String s){

        for(int i=0; i<s.length(); i++){
            for (int j = i; j<=s.length(); j++){ // why <= because substring excludes the end index so to reach till end last element have to add  <=
                System.out.println(s.substring(i,j));
            }
        }
    }


    public int beautySum(String s) {
        int sum = 0;
        for(int i =0; i<s.length(); i++){
            int[] freq = new int[26];
            for(int j=i+1; j<s.length(); j++){
                freq[s.charAt(j)-'0']++;
                    sum+=getMaxFreq(freq)-getMinFreq(freq);
            }
        }
        return sum;
    }

    private int getMinFreq(int[] freq) {
        int min = Integer.MAX_VALUE;
        for(int i=0; i<26; i++){
            if(freq[i]!=0) { //Only consider if its not a part of substring 0 means not part of substring.
                min = Math.min(min, freq[i]);
            }
        }
        return min;
    }

    private int getMaxFreq(int[] freq) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<26; i++){
            max = Math.max(max,freq[i]);
        }
        return max;
    }


    public int beautySumOptimizeButLowerRunTimeAtLeetCode(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] freq = new int[26];
            for (int j = i; j < s.length(); j++) {
                freq[s.charAt(j) - 'a']++;

                int max = 0;
                int min = Integer.MAX_VALUE;

                for (int k = 0; k < 26; k++) {
                    if (freq[k] > 0) {
                        max = Math.max(max, freq[k]);
                        min = Math.min(min, freq[k]);
                    }
                }

                sum += max - min;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        calculateSubString("aabcbaa");
    }
}

//Note Why j =i not i+1
/*
Your inner loop starts at j = i + 1, so the first character of the substring (at index i) is never counted in the frequency array.

        🧨 Example of the bug:
Given: "abc"

With your current code:

        When i = 0, j = 1:
freq[s.charAt(1) - 'a']++ → only counts 'b', ignores 'a', so you are computing beauty for "b" instead of "ab".

        ✅ Fix:
Move the character counting line into the start of the inner loop, but also:

        Start j = i, not j = i + 1, so you include the first character of each substring.


*/

