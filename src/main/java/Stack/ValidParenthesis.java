package Stack;

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(char x :  s.toCharArray()){
            if(x == '(' || x == '{' ||  x == '['){
                stack.push(x);
            }else{
                if(x == ')'){
                    if(stack.isEmpty() || stack.pop()!='('){
                        return false;
                    }
                }
                if(x == '}'){
                    if(stack.isEmpty() || stack.pop()!='{'){
                        return false;
                    }
                }

                if(x == ']'){
                    if(stack.isEmpty() || stack.pop()!='['){
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }
}
