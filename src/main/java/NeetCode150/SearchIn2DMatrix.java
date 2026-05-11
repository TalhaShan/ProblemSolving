package NeetCode150;

public class SearchIn2DMatrix {

    public boolean searchMatrix(int[][] arr, int target) {
        int m = arr.length;
        int n = arr[0].length;
        int low = 0;
        int high = m * n - 1;


        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midValue = arr[mid / n][mid % n];
            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return false;
    }
}
