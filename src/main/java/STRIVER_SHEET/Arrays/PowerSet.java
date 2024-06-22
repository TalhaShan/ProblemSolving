package STRIVER_SHEET.Arrays;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {


    public List<List<Integer>> subsets(int[] arr) {
        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (((1 << j) & i) == 1) {
                    temp.add(arr[j]);
                }
            }
            res.add(temp);

        }
        return res;
    }

    public static List<List<Integer>> subsetsIterative(int[] arr) {

        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int num : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                if (!outer.contains(internal)) {
                    outer.add(internal);
                }

            }
        }
        return outer;
    }

    public static void main(String[] args) {
        System.out.println(subsetsIterative(new int[]{1, 2, 3}));
    }

}
