package STRIVER_SHEET.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumByLearnYard {

    private void help(int i, int sum, int target, int[] candidates, List<Integer> subSet, List<List<Integer>> res) {

        //Step 2
        //Now take the base case
        //INDEX GO BIGGER
        if (i >= candidates.length) {
            return;
        }
        //sum goes bigger
        if (sum > target) {
            return;
        }
        //sum == targe boom save in ans
        if (sum == target) {
            res.add(new ArrayList<>(subSet)); //Don't fprget to make new Object
            return;
        }
//Step 1
        //Not take the ith
        help(i + 1, sum, target, candidates, subSet, res);

        //Take the ith

        sum += candidates[i];
        subSet.add(candidates[i]);

        help(i, sum, target, candidates, subSet, res); //can pick the same index again
        //back track cleaning
        sum -= candidates[i];
        subSet.remove(subSet.size() - 1);


    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //There is also condition that we can return the combinations in any order
        //But inside combination or subSet it should be ascending order
        //A simmple fix for that is sort your candidates array before going for recusrion so
        //recursion will go increasing order
        int sumTillNow = 0; //Not needed can directly pass 0
        Arrays.sort(candidates);
        List<Integer> subSet = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        help(0, sumTillNow, target, candidates, subSet, result);
        return result;
    }
}
