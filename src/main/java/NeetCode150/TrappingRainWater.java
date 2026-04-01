package NeetCode150;

public class TrappingRainWater {
    public int trap(int[] height) {
        int left =0;
        int right = height.length-1;
        int leftMaxHeight=height[0] ;
        int rightMaxHeight = height[right];
        int total=0;

        while(left<right){
            if(height[left]<height[right]){
                leftMaxHeight = Math.max(leftMaxHeight,height[left]);
                if (leftMaxHeight-height[left]>0){
                    total +=leftMaxHeight-height[left];
                }
                left++;
            }
            else{ //<= height[right] <=height[left]
                rightMaxHeight = Math.max(rightMaxHeight,height[right]);
                if(rightMaxHeight-height[right]>0){
                    total+=rightMaxHeight-height[right];
                }
                right--;
            }
        }
        return total;
    }

    public int trap2(int[] height) { //fast memory
        int n = height.length;
        int left = 0, right = n-1;
        int leftMax = 0, rightMax = 0;
        int res = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) { //updating lefMax so no need to else part it will be negative value leftMax - height[left]
                    leftMax = height[left];
                } else {
                    res += leftMax - height[left]; //only make sense to do when value is postive so else case
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    res += rightMax - height[right];
                }
                right--;
            }
        }
        return res;
    }
}
