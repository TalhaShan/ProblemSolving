package com.demo.project;

import java.util.Stack;

public class ReverseStackRecursion {

    static void reverse(Stack<Integer> s) {
        if(s.size()==1){
            return;
        }
        int temp = s.pop();
        reverse(s);
        insertPopElement(s,temp);
    }

    private static void insertPopElement(Stack<Integer> s, int temp) {
        if(s.size()==0){
            s.push(temp);
            return;
        }
        int val = s.pop();
        insertPopElement(s,temp);
        s.push(val);
    }
}
