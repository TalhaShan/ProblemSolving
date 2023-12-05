package Array;

public class SortedArrayRotate {
//    Input: nums = [3,4,5,1,2]
//    Output: true
//    Input: nums = [2,1,3,4]
//    Output: false
//    Input: nums = [1,2,3]
//    Output: true

    public static boolean checkV1(int[] nums) {
        int stopPoint = -1;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] || nums[i] == nums[i - 1]) {
                continue;
            } else {
                stopPoint = i;
                break;
            }
        }
        if (stopPoint == -1) return true;
        int max = nums[stopPoint - 1];
        while (stopPoint < nums.length - 1) {
            if (nums[stopPoint] > nums[stopPoint + 1] || nums[stopPoint] > max) {
                return false;
            }
            stopPoint++;
        }
        if (nums[nums.length - 1] > max ) return false;

        return true;
    }
    public static boolean check(int[] nums) {
        int count = 0;

        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] > nums[i+1])
                count++;
        }

        if(count == 0)
            return true;
        else if(count > 1)
            return false;
        else if(nums[0] >= nums[nums.length-1])
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
//        System.out.println(check(new int[]{3, 6, 10, 1, 8, 9, 9, 8, 9})); // f
//        System.out.println(check(new int[]{3, 4, 5, 1, 2})); //T
//        System.out.println(check(new int[]{1, 2, 3})); //T
//        System.out.println(check(new int[]{2, 1, 3, 4})); // F
//        System.out.println(check(new int[]{5, 5, 6, 6, 6, 9, 1, 2}));  // T
//        System.out.println(check(new int[]{3,1,2,2,4})); // F
        System.out.println(check(new int[]{2, 4, 1, 3})); //F

    }


}
