package STRIVER_SHEET.Arrays.GreedyAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class MinimumNoOfCoins {
    static List<Integer> coinsUsed(int[] v, int coin) {
       List<Integer> res = new ArrayList<>();
       for(int i= v.length-1; i>=0; i--){
           if(v[i]<=coin){
               res.add(v[i]);
               coin-=v[i];
           }
       }
       return res;
    }

    public static void main(String[] args) {


        int v[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        System.out.println(coinsUsed(v, 121));
    }
}
