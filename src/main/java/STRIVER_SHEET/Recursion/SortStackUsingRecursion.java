package com.demo.project;

import java.util.Stack;

public class SortStackUsingRecursion {
    public static Stack<Integer> insertstack(Stack<Integer> stack, int elem){
        if(stack.size()==0 || stack.peek()<elem) {
            stack.add(elem);
            return stack;
        }
        int temp=stack.pop();
        insertstack(stack,elem);
        stack.add(temp);
        return stack;
    }
    public static Stack<Integer> sortstack(Stack<Integer> stack){
        if(stack.isEmpty() || stack.size()==1) {
            return stack;
        }
        int temp=stack.pop();
        sortstack(stack);
        insertstack(stack,temp);
        return stack;
    }
    public static void  main(String[] args) {
        Stack<Integer> stack=new Stack<Integer>();
        stack.push(3);
        stack.push(1);
        stack.push(23);
        stack.push(4);
        stack=sortstack(stack);
        for(int elem: stack) {
            System.out.print(elem);
        }
    }
}
