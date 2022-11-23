package OneMonthPrepKit;

import java.util.Arrays;
import java.util.List;

public class PlusMinus {

    public static void plusMinus(List<Integer> arr) {
        // Write your code here

        double zero_count = 0;
        double neg_count = 0;
        double positive_count = 0;

        for (int i = 0; i < arr.size(); i++) {

            if (arr.get(i) < 0) {

                neg_count++;
            } else if (arr.get(i) == 0) {
                zero_count++;
            } else {
                positive_count++;
            }
        }

        System.out.printf("%.6f %n",positive_count/arr.size());
        System.out.printf("%.6f %n",neg_count/arr.size());
        System.out.printf("%.6f %n",zero_count/arr.size());


    }

    public static void main(String[] args) {
        plusMinus(Arrays.asList(-4, 3, -9, 0, 4, 1));
    }

}
