package SubSets;

import java.util.ArrayList;
import java.util.List;

public class SubSeq {

    public static void main(String[] args) {
        //     printSubset("","abc");
        System.out.println(printSubsetList("","abc"));
    }

    static void printSubset(String ans, String org) {
        if (org.isEmpty()) {
            System.out.println(ans);
            return;
        }
        char ch = org.charAt(0);

        //ignore it
        printSubset(ans, org.substring(1));
        //take it
        printSubset(ch + ans, org.substring(1));

    }


    static List<String> printSubsetList(String ans, String org) {
        if(org.isEmpty()){
            List<String> list  = new ArrayList<>();
            list.add(ans);
            return list;
        }
        char ch = org.charAt(0);
        List<String> left = printSubsetList(ans+ch,org.substring(1));
        List<String> right = printSubsetList(ans,org.substring(1));

        left.addAll(right);
        return left;
    }
}
