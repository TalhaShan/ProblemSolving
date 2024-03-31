package DSAShardaAman;

public class ConsecutiveCharacters {

    public static int maxPower(String s) {
//        Input: s = "abbcccddddeeeeedcba"
        int max = 0;
        int count = 0;
        boolean exist = false;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
                max = Math.max(count, max);
                exist = true;
            } else {
                count = 0;
            }
        }
        return exist == false ? 0 : max + 1;
    }

    public static void main(String[] args) {
        System.out.println(maxPower("abbcccddddeeeeedcba"));
    }
}
