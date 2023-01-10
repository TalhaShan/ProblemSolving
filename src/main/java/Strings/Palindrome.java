package Strings;

public class Palindrome {

    static boolean isPalindrome(String word) {
        if (word == null || word.length() == 0) return true;
        word = word.toLowerCase();
        for (int i = 0; i <= word.length() / 2; i++) {
            char start = word.charAt(i);
            char end = word.charAt(word.length() - 1 - i);
            if (start != end) {
                return false;
            }

        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("Madam"));
    }
}
