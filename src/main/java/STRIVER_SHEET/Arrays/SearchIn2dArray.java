package STRIVER_SHEET.Arrays;

public class SearchIn2dArray {
    static int findTarget(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n; i++) {
            if (target >= mat[i][0] && target <= mat[i][m - 1]) {
                return BS(mat[i], target);
            }
        }
        return -1;
    }

    private static int BS(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid = left + (left - right) / 2;
        while (left < right) {
            if (arr[mid] == target) {
                return target;
            }
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }
    //Tc(O(logn) * o(N)


    public boolean searchMatrix(int[][] arr, int target) {
        int n = arr.length;
        int m = arr[0].length;
        int low = 0;
        int high = (n * m) - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            /* Convert index into 2d array -- >
            row = mid / m,
            col = mid % m
            */
            if (arr[mid / m][mid % m] == target) {
                return true;
            } else if (arr[mid / m][mid % m] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return false;
    }
    //TC(O(log2(N*M)g
}



