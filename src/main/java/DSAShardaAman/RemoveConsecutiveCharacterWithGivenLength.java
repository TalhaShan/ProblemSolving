package DSAShardaAman;

public class RemoveConsecutiveCharacterWithGivenLength {

    //aabcd B=2, bcd
    //aabbaad B =2, d
    //Take 2 point i j on index 0
    //if s.charat(i) == s.charAt(j) , j++
    //when s.char(i)!=s.char(j) , also check i-j length  =  b ignore,i++ and add s.charAt(i) to res
    //when s.char(i)==s.char(j) j++;

    public static String removeChar(String s, int b) {
        int i = 0;
        int j = 0;
        String res = "";
        int n = s.length()-1;
        while (j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                if(i==j && i==n){
                    res+=s.charAt(i);
                }
                j++;
            } else if (s.charAt(i) != s.charAt(j) && j - i == b) {
                //ignore part
                i = j;
            } else {
                res += s.charAt(i);
                i++;

            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(removeChar("aabcd", 2));
    }
}
