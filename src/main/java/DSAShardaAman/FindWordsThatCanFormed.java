package DSAShardaAman;

public class FindWordsThatCanFormed {
    //
//    words = ["cat", "bt", "hat", "tree"];
//    chars = "atach";
    public static int countCharacters(String[] words, String chars) {
        int[] counts = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            counts[chars.charAt(i) - 'a']++;
        }
        int len = 0;
        for (String x : words) {
            if (canForm(x, counts)) {
                len += x.length();
            }
        }
        return len;
    }

    private static boolean canForm(String x, int[] counts) {
        int[] words = new int[26];
        for (int i = 0; i < x.length(); i++) {
            int m = x.charAt(i) - 'a';
            words[m]++;
            if (words[m] > counts[m]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
    }
}
