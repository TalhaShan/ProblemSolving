package SubSets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IterativeSubSet {
    public static void main(String[] args) {
//        List<List<Integer>> res = createSubsets(new int[]{1, 2, 3});
//        for (List<Integer> list : res) {
//            System.out.println(list);
//        }
        List<List<Integer>> res = createSubsetsHandleDuplicates(new int[]{0});
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }

    static List<List<Integer>> createSubsets(int[] arr) {

        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int num : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }
    static List<List<Integer>> createSubsetsHandleDuplicates(int[] arr) {

        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int num : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                if(!outer.contains(internal)){
                    outer.add(internal);
                }

            }
        }
        return outer;
    }

    static List<List<Integer>> subsetDuplicate(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            start = 0;
            // if current and previous element is same, s = e + 1
            if (i > 0 && arr[i] == arr[i-1]) {
                start = end + 1;  //if same previous will be skip in next loop to avoid duplicates
            }
            end = outer.size() - 1;
            int n = outer.size();
            for (int j = start; j < n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }

}
