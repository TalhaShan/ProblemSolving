package DSAShardaAman;

public class MaximumProductSubArray {
    //    Input: nums = [2,3,-2,-4]
//    Output: 6
//    Explanation: [2,3] has the largest product 6.
    //O(n2)
    public static int maxProductNaive(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int prod = 1;
            for (int j = i; j < nums.length; j++) {
                prod = prod * nums[j];
                max = Math.max(prod, max);
            }
            max = Math.max(prod, max);

        }
        return max;
    }

    //O(n)
    //1. First Calculate prefix
    //2. Then calculate suffix
    //3, mAX OF PREFIX AND SUFFIX

    //observation if -ve even all included, if all +ve all included, if off we will try to eliminate -less part,
    //0 encountered new product start
    //Example 1:
//    [2,3,-2,4]
    //Prefix: 2, 2*3 = 6, -12, -48 , prefixMax = 6
    //suffix: 4, -8, -24, -48        suffixMax = - 4
    //ans = 6

    //Example 2:
    //-2,3,4-1, 0, -2,3,1,4 , 0 ,4,6,-1,4
    //at every stage we are update ourself so we won't lose any maxProduct
    //whenvener 0 we need to do prefix or suffix =1 else all will become 0, like reset counter in kandens

    //we camn also run prefix suffix at one time see below
    public static int maxProduct(int[] nums) {
        int prefix = 1;
        int suffix = 1;
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (prefix == 0) prefix = 1;  // To handle zero values encountered
            if (suffix == 0) suffix = 1;

            prefix = prefix * nums[i];
            suffix = suffix * nums[n - i - 1];
            ans = Math.max(ans,Math.max(prefix,suffix));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
    }
}
