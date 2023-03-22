package SdeSheet;

public class ReversePairCount {


    public static int reversePairs(int[] nums) {
        int i = 0; int j = nums.length-1;
        int count =0 ;
        while (i<j){
            if(nums[i]>2*nums[j]){
                System.out.println(nums[i] +" , "+ nums[j]);
                count+=1;
                j--;
            }
            i++;


        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{1,3,2,3,1}));
    }
}
