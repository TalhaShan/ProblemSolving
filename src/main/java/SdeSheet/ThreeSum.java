package SdeSheet;

import java.util.*;

public class ThreeSum {
    //    Time Complexity : O(N^2)
//
//    Space Complexity : O(1) bacuse we are returning result so ignoring res// or o(m)   // k is the no.of triplets
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);

        List<List<Integer>> res = new LinkedList<>();

        for (int i = 0; i < num.length - 2; i++) {

            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {

                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];

                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(num[i]);
                        temp.add(num[lo]);
                        temp.add(num[hi]);
                        res.add(temp);

                        while (lo < hi && num[lo] == num[lo + 1]) lo++;
                        while (lo < hi && num[hi] == num[hi - 1]) hi--;

                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;

                    else hi--;
                }
            }
        }
        return res;
    }

    //    Time Complexity : O(n^3)   // 3 loops
//
//    Space Complexity : O(3*k)  // k is the no.of triplets
    static ArrayList<ArrayList<Integer>> threeSumBrute(int nums[]) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int i, j, k;
        for (i = 0; i < nums.length - 2; i++) {
            for (j = i + 1; j < nums.length - 1; j++) {
                for (k = j + 1; k < nums.length; k++) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                    }
                    if (temp.size() != 0)
                        ans.add(temp);
                }
            }
        }

        return ans;
    }

    public static List<List<Integer>> threeSumWithHashMap(int[] num,int target) {


        List<List<Integer>> res = new LinkedList<>();

        for(int i =0; i<num.length-2; i++){
            HashSet<Integer> s  = new HashSet<>();
            int curr_sum = target-num[i];
            for(int j =i+1 ; j<num.length; j++){
                if(s.contains(curr_sum-num[j])){
                res.add(Arrays.asList(num[i],num[j],curr_sum-num[j]));
                }else {
                    s.add(num[j]);
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int A[] = { 1, 4, 45, 6, 10, 8 };
        int sum = 22;
        System.out.println(threeSumWithHashMap(A,sum));
    }
}
