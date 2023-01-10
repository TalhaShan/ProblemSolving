package Recursion;

public class FibonacciNumber {
    static int fib(int n) {

        //base condition;
        if(n<2){  //because we know n ==0  and n==1 answer so if n =1 return 1 or n =2 return 2
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fib(6));
    }
}
