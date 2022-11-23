package Google;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> main;
    private Stack<Integer> temp;

    public MinStack(){
         main = new Stack<>();
         temp = new Stack<>();
    }
    public void push(int x){
       main.push(x);
       int min = temp.isEmpty() || x <temp.peek() ? x : temp.peek();

       temp.push(min);

    }
    public void pop(){
        main.pop();
        temp.pop();
    }
    public int top(){
       return main.peek();
    }
    public int getMin(){
        return temp.peek();
    }

    public static void main(String[] args) {

    }
}
