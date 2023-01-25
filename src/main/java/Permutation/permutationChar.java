package Permutation;

import java.util.ArrayList;

public class permutationChar {
    public static void main(String[] args) {
//        printPermutations("", "abc");
        System.out.println(printPermutationsList("", "abc"));

    }

    static void printPermutations(String ans, String org) {

        if (org.isEmpty()) {
            System.out.println(ans);
            return;
        }

        char ch = org.charAt(0);
        for (int i = 0; i <= ans.length(); i++) {
            String first = ans.substring(0, i);
            String second = ans.substring(i, ans.length());
            printPermutations(first + ch + second, org.substring(1));
        }
    }

    static ArrayList<String> printPermutationsList(String ans, String org) {

        if (org.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }
        ArrayList<String> res = new ArrayList<>();
        char ch = org.charAt(0);
        for (int i = 0; i <= ans.length(); i++) {
            String first = ans.substring(0, i);
            String second = ans.substring(i, ans.length());
            res.addAll(printPermutationsList(first + ch + second, org.substring(1)));
        }

        return res;
    }


    static int printPermutationCount(String ans, String org) {

        if (org.isEmpty()) {
            return 1;
        }
        int count = 0;
        char ch = org.charAt(0);
        for (int i = 0; i <= ans.length(); i++) {
            String first = ans.substring(0, i);
            String second = ans.substring(i, ans.length());
          count  = count +  printPermutationCount(first + ch + second, org.substring(1));
        }
        return count;
    }
}
