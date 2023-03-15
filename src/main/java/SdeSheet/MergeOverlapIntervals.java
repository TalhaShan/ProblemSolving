package SdeSheet;

import java.util.*;

public class MergeOverlapIntervals {
    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);

            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }


    static ArrayList<List<Integer>> merge(ArrayList<List<Integer>> intervals) {
        ArrayList<List<Integer>> merged = new ArrayList<>();
        Collections.sort(intervals, (a, b) -> Integer.compare(a.get(0), b.get(0)));

//        Collections.sort(intervals,(a,b)->a.get(0)-b.get(0));

        for (List<Integer> arr : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1).get(1) < arr.get(0)) {
                List<Integer> res1 = new ArrayList<>();
                res1.add(arr.get(0));
                res1.add(arr.get(1));
                merged.add(res1);
            } else {
                //set index 1 or 0 offcourse 1
                merged.get(merged.size() - 1).set(1, Math.max(merged.get(merged.size() - 1).get(1), arr.get(1)));
            }
        }

        return merged;
    }

    public static void main(String[] args) {

        ArrayList<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(new Integer[]{1, 3}));
        arr.add(Arrays.asList(new Integer[]{2, 4}));
        arr.add(Arrays.asList(new Integer[]{2, 6}));
        arr.add(Arrays.asList(new Integer[]{8, 9}));
        arr.add(Arrays.asList(new Integer[]{8, 10}));
        arr.add(Arrays.asList(new Integer[]{9, 11}));
        arr.add(Arrays.asList(new Integer[]{15, 18}));
        arr.add(Arrays.asList(new Integer[]{16, 17}));
        System.out.println(merge(arr));

        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(intervals)));  //To convert multiple dimensions array to string we use deeptoString

    }
}
