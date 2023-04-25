package SdeSheet;

public class TappingRainWater {

//    Solution 1: Brute force

//    Approach: For each index, we have to find the amount of water that can be stored and we have to
//    sum it up.If we observe carefully the amount the water stored at a particular index
//    is the minimum of maximum elevation to the left and right of the index minus the elevation
//    at that index
    //at every stage we have to find max
    //left max = max till left (0 - current)
    //right max = max till right (current-end)

    //water = Math.min(lefMax,rightMax)-currentElevation;
    //TO(n*n) == n^2;

    static int trapBrute(int[] arr) {
        int leftMax = 0;
        int rightMax = 0;
        int n = arr.length;
        int waterTapped = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n) {
                rightMax = Math.max(rightMax, arr[j]);
                j++;
            }
            j = i;
            while (j >= 0) {
                leftMax = Math.max(leftMax, arr[j]);
                j--;
            }
            waterTapped += Math.min(leftMax, rightMax) - arr[i];

        }
        return waterTapped;
    }
    //Solution 2:Better solution

//    Intuition: We are taking O(N) for computing leftMax and rightMax at each index. The complexity can be boiled down to O(1) if we precompute the leftMax and rightMax at each index.

//            Approach: Take 2 array prefix and suffix array and precompute the leftMax and rightMax for each index beforehand. Then use the formula min(prefix[I], suffix[i])-arr[i] to compute water trapped at each index.
    //T O(2n)+n  == o(n)

    //calulate suffix and prefix at each point   // just like left and right max above
    static int trapOptimalSuffixSuffix(int[] arr) {
        int n = arr.length;
        int[] suffix = new int[n];
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], arr[i]);
        }
        suffix[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], arr[i]);
        }
        int waterTapped = 0;

        for (int i = 0; i < n; i++) {
            waterTapped += Math.min(prefix[i], suffix[i]) - arr[i];
        }
        return waterTapped;
    }
        //T O(N) //S O(1)
    static int twoPointerApproach(int[] arr) {
        int right = arr.length - 1;
        int left = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int tappedWater = 0;

        while (left < right) {
            if (arr[left] <= arr[right]) {
                if (arr[left] >= maxLeft) {
                    maxLeft = arr[left];
                } else {
                    tappedWater += maxLeft - arr[left];
                }
                left++;
            } else {
                if (arr[right] >= maxRight) {
                    maxRight = arr[right];
                } else {
                    tappedWater += maxRight - arr[right];
                }
                right--;
            }
        }

        return tappedWater;
    }

    public static void main(String[] args) {
        int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(twoPointerApproach(arr));
    }
}
