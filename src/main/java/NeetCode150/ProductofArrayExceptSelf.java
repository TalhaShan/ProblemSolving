package NeetCode150;

public class ProductofArrayExceptSelf {
    //Optimal Approach
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int pre = 1;
        int post = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = pre;
            pre = pre * nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = res[i] * post;
            post = post * nums[i];
        }
        return res;
    }

    //Better Approach
    public int[] productExceptSelf2(int[] nums) {
        int N = nums.length;
        int[] output = new int[N];
        int[] leftArr = new int[N];
        int[] rightArr = new int[N];

        leftArr[0] = 1;
        for (int i = 1; i < N; i++) {
            leftArr[i] = leftArr[i - 1] * nums[i-1];
        }
        rightArr[N - 1] = 1;
        for (int i = N - 2; i >=0; i--) {
            rightArr[i] = rightArr[i + 1] * nums[i+1];
        }

        for (int i = 0; i < N; i++) {
            output[i] = leftArr[i] * rightArr[i];
        }

        return output;
    }
}
