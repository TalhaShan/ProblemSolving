package STRIVER_SHEET.Recursion;

import java.util.*;

public class SubSetSumII {
//T0(2^N * N) //Generating 2 ki power n subset  * putting these subset into some datastrutucre
//    S0(2^N) * o(k) //average length k

    //Brute Force
    static void printAns(List < String > ans) {
        System.out.println("The unique subsets are ");
        System.out.println(ans.toString().replace(",", " "));
    }
    public static void fun(int[] nums, int index, List < Integer > ds, HashSet < String > res) {
        if (index == nums.length) {
            Collections.sort(ds);
            res.add(ds.toString());
            return;
        }
        ds.add(nums[index]);
        fun(nums, index + 1, ds, res);
        ds.remove(ds.size() - 1);
        fun(nums, index + 1, ds, res);
    }
    public static List < String > subsetsWithDup(int[] nums) {
        List < String > ans = new ArrayList < > ();
        HashSet < String > res = new HashSet< >();
        List < Integer > ds = new ArrayList< >();
        fun(nums, 0, ds, res);
        for (String it: res) {  //add it to set for unique
            ans.add(it); //for return set to list
        }
        return ans;
    }


    //Optimal

    public static void findSubsets(int ind, int[] nums, List<Integer> ds, List<List<Integer>> ansList) {
        ansList.add(new ArrayList<>(ds));
        for(int i = ind;i<nums.length;i++) {
            if(i!=ind && nums[i] == nums[i-1]) continue; // no duplicates
            ds.add(nums[i]);
            findSubsets(i+1, nums, ds, ansList);
            ds.remove(ds.size() - 1);
        }

    }
    public static List<List<Integer>> subsetsWithDupOptimal(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>(), ansList);
        return ansList;
    }

    public static void main(String args[]) {
        int nums[]={1,2,2};
        List< String > ans = subsetsWithDup(nums);
        printAns(ans);

    }
}
