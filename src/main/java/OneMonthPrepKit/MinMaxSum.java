package OneMonthPrepKit;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MinMaxSum {


    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        Long minSum = 0L;
        Long maxSum = 0L;
        Long  sum=0L;
        arr = arr.stream().sorted().collect(Collectors.toList());
       //Long.valueOf(arr.stream().reduce(Integer::sum).get());
        for(long x:arr){
          sum+=x;
        }

        maxSum = sum - arr.get(0);
        minSum = sum - arr.get(arr.size() - 1);

        System.out.println(minSum + " " + maxSum);

    }

    public static void main(String[] args) {
      //  miniMaxSum(Arrays.asList(1, 2, 3, 4, 5));
        miniMaxSum(Arrays.asList(256741038 ,623958417, 467905213, 714532089 ,938071625));

    }
}
