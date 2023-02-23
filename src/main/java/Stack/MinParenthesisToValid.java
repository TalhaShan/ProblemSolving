package Stack;

import java.util.Stack;

public class MinParenthesisToValid {
    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack();
        for (char x : s.toCharArray()) {
            if (x == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(x);
                }
            } else {
                stack.push(x);
            }

        }
        return stack.size();

    }

    public static void main(String[] args) {
        minAddToMakeValid("())");
    }
}
