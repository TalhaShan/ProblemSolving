package DSAShardaAman;


import java.util.Arrays;

public class ChocolateDistribution {

    int minDist(int[] arr, int m) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= arr.length - m; i++) {

            int minW = arr[i];
            int maxW = arr[i + m - 1];
            min = Math.min(min, maxW - minW);
        }
        return min;
    }
}
