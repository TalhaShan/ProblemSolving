package Permutation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PhonePad {

    static void pad(String ans, String org) {
        if (org.isEmpty()) {
            System.out.println(ans);
            return;
        }

        int digit = org.charAt(0) - '0';  // convert '2' into 2
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {

            char ch = (char) ('a' + i);
            pad(ans + ch, org.substring(1));
        }
    }


    static ArrayList<String> padList(String ans, String org) {
        if (org.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }

        int digit = org.charAt(0) - '0';  // convert '2' into 2
        ArrayList<String> res = new ArrayList<>();
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {

            char ch = (char) ('a' + i);
            res.addAll(padList(ans + ch, org.substring(1)));

        }
        return res;
    }


    public static List<String> solve(String ans, String ip) {

        if (ip.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }

        int digit = ip.charAt(0) - '0';
        int i = (digit - 2) * 3;
        if (digit > 7) {
            i += 1;
        }
        int len = i + 3;
        if (digit == 7 || digit == 9) {
            len += 1;
        }

        ArrayList<String> list = new ArrayList<>();

        for (; i < len; i++) {
            char ch = (char) ('a' + i);
            list.addAll(solve(ans + ch, ip.substring(1)));
        }

        return list;

    }

    static void printKes(int num, String output, String[] options) {
        if (num == 0) {
            System.out.println(output);
            return;
        }

        int n1 = num % 10;
        String s1 = options[n1];
        for (int i = 0; i < s1.length(); i++) {
            printKes(num / 10, s1.charAt(i) + output, options);
        }

    }


    static ArrayList<String> printKesList(int num, String output, String[] options) {
        if (num == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(output);
            return list;
        }
        ArrayList<String> res = new ArrayList<>();

        int n1 = num % 10;
        String s1 = options[n1];
        for (int i = 0; i < s1.length(); i++) {
            res.addAll(printKesList(num / 10, s1.charAt(i) + output, options));
        }
        return res;
    }


    public static void main(String[] args) {
//        pad("","12");
        //   System.out.println(padList("", "12"));

        String output = "";
        String options[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //0   1    2       3      4                                   9
        System.out.println(printKesList(23, output, options));
    }
}
