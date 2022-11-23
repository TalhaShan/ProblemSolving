package OneMonthPrepKit;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class LonelyElement {
    public static int lonelyinteger(List<Integer> a) {
        // Write your code here
        int res = 0;
        for (int value : a) {
            if (Collections.frequency(a, value) == 1) {
                res = value;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lonelyinteger(Arrays.asList(1, 2, 3, 4, 1, 2, 3)));
    }
}
