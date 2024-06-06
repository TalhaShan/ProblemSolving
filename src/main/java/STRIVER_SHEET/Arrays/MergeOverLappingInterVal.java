package STRIVER_SHEET.Arrays;

import java.util.*;

public class MergeOverLappingInterVal {
    public static int[][] merge(int[][] intervals) {

        LinkedList<int[]> merge = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] arr : intervals) {
            if (merge.isEmpty() || merge.getLast()[1] < arr[0]) {
                merge.add(arr);
            } else {
                merge.getLast()[1] = Math.max(merge.getLast()[1], arr[1]);
            }
        }


        return merge.toArray(new int[merge.size()][]);

    }

    public static List<List<Integer>> mergeList(List<List<Integer>> intervals) {

        Collections.sort(intervals, (a, b) -> Integer.compare(a.get(0), b.get(0)));
        List<List<Integer>> ans = new ArrayList<>();
        for (List<Integer> res : intervals) {
            if (res.isEmpty() || ans.get(ans.size() - 1).get(1) < res.get(1)) {
                ans.add(res);
            } else {
                ans.get(ans.size() - 1).set(1, Math.max(ans.get(ans.size() - 1).get(1), res.get(1)));
            }
        }
        return  ans;
    }
}
