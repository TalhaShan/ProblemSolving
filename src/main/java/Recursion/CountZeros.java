package Recursion;

public class CountZeros {

    static int countZero(int n) {
        return helper(n, 0);

    }

    static int helper(int n, int count) {
        if (n == 0) {
            return count; //executes only once then it passing the result of count as per called
        }
        int rem = n % 10;
        if (rem == 0) {  //count zero or any other digit
            return helper(n / 10, count + 1);
        }
        return helper(n / 10, count);

    }

    public static void main(String[] args) {
        System.out.println(countZero(14001200));
    }
}
