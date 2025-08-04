package Strings;

public class MaxDepthCharacter {
/*
    Example 1:
    Input: s = "(1+(2*3)+((8)/4))+1"
    Output: 3
    Explanation:
    Digit 8 is inside of 3 nested parentheses in the string.
    Example 2:
    Input: s = "(1)+((2))+(((3)))"
    Output: 3
    Explanation:
    Digit 3 is inside of 3 nested parentheses in the string.
    Input: s = "()(())((()()))"
    Output: 3
    */
    public static int maxDepth(String s) {
        int counter =0;
        int maxCounter=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                counter++;
                maxCounter = Math.max(counter,maxCounter);
            }else if(s.charAt(i)==')'){
                counter--;
            }
        }
        return maxCounter;
    }

    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
    }
}
