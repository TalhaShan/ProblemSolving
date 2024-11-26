package STRIVER_SHEET.LinkedList;

public class TappingRainWater {

    public int trap(int[] arr) {

        int left = 0;
        int right = arr.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        int water = 0;
        while (left < right) {

            if (arr[left] <= arr[right]) {
                if (maxLeft <= arr[left]) {
                    maxLeft = arr[left];
                } else {
                    water += maxLeft - arr[left];
                }
                left++;
            } else {
                if (maxRight <= arr[right]) {
                    maxRight = arr[right];
                } else {
                    water += maxRight - arr[right];
                }
                right--;
            }
        }
        return water;
    }
}