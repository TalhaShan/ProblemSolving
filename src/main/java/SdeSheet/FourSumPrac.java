package SdeSheet;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSumPrac {
    public static List<List<Integer>> fourSumApproach2(int[] nums, long target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if(i>0 && nums[i-1]==nums[i]){
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if(j>i+1 && nums[j-1]==nums[j]){
                    continue;
                }

                long required = target - nums[i] - nums[j];
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    if (nums[k] + nums[l] == required) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));

                        while (k<l && nums[k]==nums[k+1]){
                            k++;
                        }
                        while (k<l && nums[l]==nums[l-1]){
                            l--;
                        }
                        k++;
                        l--;

                    } else if (nums[k] + nums[l] < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }

        return res;

    }
}
