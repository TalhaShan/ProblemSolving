package STRIVER_SHEET.Arrays.GreedyAlgorithms;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AssignCookies {

    static  int maxNoOfCookies(int[] greed, int[] cookies){
        Arrays.sort(greed);
        Arrays.sort(cookies);

        int n = greed.length;
        int m = cookies.length;
        int l = 0;
        int r = 0;
        while (l<m){
            if(greed[r]<=cookies[l]){
                r = r+1;
            }
            l=l+1;
        }
        return r;
    }
    public static void main(String[] args) {

    }
}
