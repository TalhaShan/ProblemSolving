package STRIVER_SHEET.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2ByLearnYard {

    public void help(int i, int[] arr, int n, List<Integer> subSet, List<List<Integer>> powerSet, int sum, int target)
    {

        // If sum is equal to target, we have reached a Valid Combination

        if(sum == target)
        {
            powerSet.add(new ArrayList(subSet)) ;
            return;
        }

        // If at any moment, sum becomes greater than target, we don't need to proceed further

        if(sum > target) return ;

        // If we reach the end of arr[], we cannot go any further so we return back

        if(i == n) return;

        // Include the i-th Element into our Subset & Sum

        subSet.add(arr[i]) ;
        sum += arr[i] ;

        // Ask recursion to do rest of the task
        help(i + 1, arr, n, subSet, powerSet, sum, target) ;

        // Backtrack and undo the change we have done

        subSet.remove(subSet.size()-1);
        sum -= arr[i];

        // Use the While Loop to skip all the duplicate occurrences of i-th Element

        while(i + 1 < arr.length && arr[i] == arr[i + 1]) i++ ;

        // Don't pick the i-th Element and ask recursion to do rest of the task

        help(i + 1, arr, n, subSet, powerSet, sum, target) ;
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        List<Integer> subSet = new ArrayList<>() ;
        List<List<Integer>> powerSet = new ArrayList<>() ;
        int sum = 0;
        int n = candidates.length ;
        Arrays.sort(candidates) ; //as we want in ascending order the subsets

        help(0, candidates, n, subSet, powerSet, sum, target) ;

        return powerSet ;
    }
}
