package STRIVER_SHEET.Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        findCombination(0, candidates,target,ans,new ArrayList<>());
        return ans;

    }

    private void findCombination(int index, int[] candidates, int target, List<List<Integer>> ans, List<Integer> ds) {
        if(index == candidates.length){
            if(target==0){
             ans.add(new ArrayList<Integer>(ds));
            }
            return;
        }

        if(candidates[index] <= target){
            ds.add(candidates[target]);
            findCombination(index,candidates,target-candidates[index],ans,ds);
            ds.remove(ds.size()-1);
        }
        findCombination(index+1,candidates,target,ans,ds);
    }


}
