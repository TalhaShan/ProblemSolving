package STRIVER_SHEET.Arrays;

import java.util.ArrayList;
import java.util.List;

public class SuperiorLeaderElement {
    public static List<Integer> calculateSuperior(int[] arr) {
        int max = Integer.MIN_VALUE;
        List<Integer> res = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > max) {
                res.add(arr[i]);
                max = arr[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int a[]=  {10, 22, 12, 3, 0, 6};
        System.out.println(calculateSuperior(a));
    }
}
