package NeetCode150;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> res = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int find = target-nums[i];
            if(res.containsKey(find)){
                return new int[]{res.get(find),i};
            }
            res.put(nums[i],i);
        }
         return  new int[]{};
    }
}
