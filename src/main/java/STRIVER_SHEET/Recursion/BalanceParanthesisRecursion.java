package com.demo.project;

import java.util.ArrayList;
import java.util.List;

public class BalanceParanthesisRecursion {
    public class GenerateBalancedParenthesesRecursive {

        public static void main(String[] args) {
            int n = 4;
            int open = n, closed = n;
            String op = "";
            List<String> output = new ArrayList<>();
            List<String> result = solve(open, closed, op, output);
            result.forEach(System.out::println);
        }

        /**
         * input is an integer and output is a list of balanced parentheses strings.
         */
        public static List<String> solve(int open, int closed, String op, List<String> output) {
            // base condition
            if (open == 0 && closed == 0) {
                output.add(op);
                return output;
            }

            String op1;
            String op2;

            // opening parentheses choice is used until it becomes 0
            if (open != 0) {
                op1 = op;
                op1 += "(";
                solve(open - 1, closed, op1, output);
            }
            // when closed is greater than open, we have the closing parentheses choice in the output.
            if (closed > open) {
                op2 = op;
                op2 += ")";
                solve(open, closed - 1, op2, output);
            }
            return output;
        }
    }

    //More cleaner
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recurse(res, 0, 0, "", n);
        return res;
    }

    public void recurse(List<String> res, int left, int right, String s, int n) {
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }

        if (left < n) {
            recurse(res, left + 1, right, s + "(", n);
        }

        if (right < left) {
            recurse(res, left, right + 1, s + ")", n);
        }
    }
}
