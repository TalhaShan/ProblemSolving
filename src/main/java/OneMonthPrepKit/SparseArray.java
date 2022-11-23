package OneMonthPrepKit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SparseArray {

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        // Write your code here

        List<Integer> stringCount = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {

            stringCount.add(Collections.frequency(strings, queries.get(i)));
        }

        return stringCount;
    }

    public static void main(String[] args) {
        System.out.println(matchingStrings(Arrays.asList("abc","def","ghi","ghi"),Arrays.asList("abc","def","ghi","jkl")));
    }
}
