package SdeSheet;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
//        height = [1,8,6,2,5,4,8,3,7]
        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;
        while (left < right) {
            int currentH = 0;
            if (height[left] < height[right]) {
                currentH = height[left];
                maxArea = Math.max(maxArea, currentH * (right - left));

                left++;
            } else if (height[left] > height[right]) {
                currentH = height[right];
                maxArea = Math.max(maxArea, currentH * (right - left));
                right--;
            } else {
                currentH = height[right];
                maxArea = Math.max(maxArea, currentH * (right - left));
                left++;
                right--;
            }
        }

        return maxArea;
    }


    public static int maxAreaCodeRefactor(int[] height) {
//        height = [1,8,6,2,5,4,8,3,7]
        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                maxArea = Math.max(maxArea, height[left] * (right - left));
                left++;
            } else if (height[left] > height[right]) {
                maxArea = Math.max(maxArea,  height[right] * (right - left));
                right--;
            } else {
                maxArea = Math.max(maxArea,  height[right] * (right - left));
                left++;
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
}
