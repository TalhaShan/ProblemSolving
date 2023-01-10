package Recursion;

public class ReverseNumber {

    static int sum = 0;

    static void reverseANumber(int n) {  //12345 ->54321

        if (n == 0) {
            return;
        }
        int rem=n%10;
        sum = sum*10+rem;
        reverseANumber(n/10);

    }

    static int rev2(int n){
        int digits = (int) (Math.log10(n)+1);
        return helper(n,digits);

    }
    private static int helper(int n , int digits){
        if(n%10==n){
            return n;
        }
        int rem = n%10;

        return rem * (int) (Math.pow(10,digits-1))+helper(n/10,digits-1);
    }


    public static void main(String[] args) {
        reverseANumber(1432);
        System.out.println(rev2(1432));
        System.out.println(sum);
    }
}
