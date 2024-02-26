package DSAShardaAman;

public class TrapRainWater {
    public int trap(int[] arr) {

        //Optimal
        int left = 0;
        int right = arr.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;

        while (left < right) {
            if (arr[left] <= arr[right]) {  // left pr dewar dhondo right pr hai bari  support
                if (arr[left] >= leftMax) {
                    leftMax = arr[left];
                } else {
                    res += leftMax - arr[left];
                }
                left++;
            } else {
                if (arr[right] >= rightMax) {
                    rightMax = arr[right];
                } else {
                    res += rightMax - arr[right];
                }
                right--;
            }

        }
        return res;
    }

    // suufice space 2n
    static int trapWithSufficePrefix(int[] arr) {
        int n = arr.length;
        int prefix[] = new int[n];
        int suffix[] = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], arr[i]);
        }
        suffix[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], arr[i]);
        }
        int waterTrapped = 0;
        for (int i = 0; i < n; i++) {
            waterTrapped += Math.min(prefix[i], suffix[i]) - arr[i];
        }
        return waterTrapped;
    }
}
