package Recursion;

public class NTO1 {

    static void fun(int n) {
        if (n == 0) {
            return;
        }


        fun(n - 1);
        System.out.println(n);
    }

    static int factorial(int n) {
        if (n <= 1) {   //fact 0 is also 1
            return 1;
        }

        return n * factorial(n - 1);
    }

    static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);

    }

    static int addDigit(int n) {
        if (n == 0)
            return 0;

        return addDigit(n / 10) + (n % 10);
    }

    static int prod(int n) {
        if (n % 10 == n) {
            return n;            //if one digit is remaining return that avoiding 0 of write simply if n==0 return 1
        }

        return (n % 10) * prod(n / 10);
    }

    static void print(int n) {
        if (n == 0) {
            return;
        }

        System.out.println(n);
//        print(n--);
        print(--n);
    }


    public static int numberOfSteps(int num) {
        return  steps(num,0);
    }
    static int steps(int num, int count){
        if(num==0){
            return count;
        }
        if(num%2==0){
            count++;
            num = num/2;
            return steps(num,count);
        }else{
            count++;
            num = num-1;
            return steps(num,count);
        }
    }


    public static void main(String[] args) {
        //fun(5);
//        System.out.println(factorial(0));
//        System.out.println(factorial(6));
//        System.out.println(sum(5));
//        System.out.println(addDigit(1342));
//        System.out.println(prod(1342));
        //print(5);

    }
}
