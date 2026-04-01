package NeetCode150;

public class WaterWithMostContainer {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while (left<right){

            int width = Math.min(height[left], height[right]);
            int length = right - left;

            max = Math.max(max, width*length);

            if(height[left] < height[right]){
                left++;
            }
            else{ //<= case
                right--;
            }
        }

        return max;
    }


    public int maxArea2OptimalBitMemoryWise(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;
        while (left < right) {
            int currentHLower = 0;
            if (height[left] < height[right]) {
                currentHLower   = height[left];
                maxArea = Math.max(maxArea, currentHLower * (right - left));

                left++;
            } else if (height[left] > height[right]) {
                currentHLower = height[right];
                maxArea = Math.max(maxArea,currentHLower*(right-left));
                right--;
            }
            else{ //equals case
                currentHLower = height[right];
                maxArea = Math.max(maxArea,currentHLower*(right-left));
                left++;
                right--;
            }
        }

        return maxArea;
    }

}
