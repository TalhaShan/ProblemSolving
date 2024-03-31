package DSAShardaAman;

public class RemoveConsecutiveCharacter {

    public static String removeChars(String s) {
        StringBuilder res = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                continue;

            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();

    }

    public static void main(String[] args) {
        System.out.println(removeChars("aabcd"));
    }
}
