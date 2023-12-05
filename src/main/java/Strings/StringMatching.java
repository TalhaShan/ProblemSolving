package Strings;

public class StringMatching {

    public static boolean rotateString(String s, String goal) {
        // abcde    abcde
        // cdeab    abced

        for(int i =0 ; i<goal.length()-1; i++){

            if(s.indexOf(goal.charAt(i))==goal.length()){
                i=-1;
            }
            if(s.charAt(s.indexOf(goal.charAt(i))+1)==(goal.charAt(i+1))){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        rotateString("abcde","cdeab");
    }
}
