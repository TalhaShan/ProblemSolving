package Strings;

public class RemoveOuterMostParantheses {
    public String removeOuterParentheses(String s) {
        int count = 0;
        StringBuilder res  = new StringBuilder();
        for (int i=0;i <s.length();i++){
            if(s.charAt(i)==')'){ //there is a resson to check closing bracket first so we can get our counter
                // incremented without adding I mean opening one first time.
                count--;
            }
            if(count!=0){
                res.append(s.charAt(i));
            }
            if(s.charAt(i) == '('){
                count++;
            }
        }
        return res.toString();
    }

    //Using stack
    public String removeOuterParenthesesUsingS(String s) {
        StringBuilder result=new StringBuilder();   // To store the final result
        int balance = 0; // To keep track of the balance of parentheses

        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // If balance is greater than 0, it means this '(' is not an
                // outermost parenthesis
                if (balance > 0) {
                    result.append(s.charAt(i)); // Add the character to the result
                }
                balance++; // Increase the balance for '('
            } else {
                balance--; // Decrease the balance for ')'
                // If balance is greater than 0, it means this ')' is not an
                // outermost parenthesis
                if (balance > 0) {
                    result.append(s.charAt(i)); // Add the character to the result
                }
            }
        }

        return result.toString(); // Return the final result after removing outermost
        // parentheses
    }
}
