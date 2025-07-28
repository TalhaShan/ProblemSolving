package Strings;

import java.util.ArrayList;
import java.util.Stack;

public class ReverseWordsInString {

    /*
    Example 1:
    Input: s = "the sky is blue"
    Output: "blue is sky the"
    Example 2:

    Input: s = "  hello world  "
    Output: "world hello"
    Explanation: Your reversed string should not contain leading or trailing spaces.
    Example 3:

    Input: s = "a good   example"
    Output: "example good a"
    Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
    */

    public static String reverseWords(String s) {

        String words[] = s.split(" +"); //cater more than one space before after
        StringBuilder sb = new StringBuilder();
        for(int i=words.length-1; i>=0; i--){
            sb.append(words[i]);
            sb.append(" ");
        }
        return sb.toString().trim(); //.trim() removing trialing and leading space.
    }

    public static void main(String[] args) {
        System.out.println(reverseUsingStack("the sky is blue"));
    }

    public static String reverseUsingStack(String s){
        Stack<String> st = new Stack<>();
        String str = "";
        for (int i = 0;i < s.length();i++)
        {
            if (s.charAt(i) == ' ') //only push when word is completed in sentence
                //won't work with multiple spaces
            {
                st.push(str);
                str = "";
            }
            else
            {
                str += s.charAt(i);
            }
        }
        st.push(str);
        String ans = "";
        while (st.size() != 1)
        {
            ans += st.peek() + " ";
            st.pop();
        }
        ans += st.peek(); // The last word should'nt have a space after it
        return  ans.trim();
    }
}
