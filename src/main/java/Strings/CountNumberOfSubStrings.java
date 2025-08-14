package Strings;

public class CountNumberOfSubStrings {

    public static  int countSubString(String str){
        int n = str.length();
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        System.out.println(countSubString("abcd"));
    }
    //To(1), So(1)

    /*
    How does above formula work?

Number of substrings of length one is n (We can choose any of the n characters)
Number of substrings of length two is n-1 (We can choose any of the n-1 pairs formed by adjacent)
Number of substrings of length three is n-2
(We can choose any of the n-2 triplets formed by adjacent)
In general, number of substrings of length k is n-k+1 where 1 <= k <= n
Total number of substrings of all lengths from 1 to n =
n + (n-1) + (n-2) + (n-3) + ... 2 + 1
= n * (n + 1)/2
     */
}
