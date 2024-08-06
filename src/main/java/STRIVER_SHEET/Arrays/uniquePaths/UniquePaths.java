package STRIVER_SHEET.Arrays.uniquePaths;

public class UniquePaths {
    /* Recursive
    * Time Complexity: The time comp[lexity of this recursive solution is exponential.

    Space Complexity: As we are using stack space for recursion so the space complexity will also be exponential.
    * */
    public int uniquePaths(int m, int n) {  // TC (0 (n
        int i = 0, j = 0;
        return count(i, j, m, n);
    }

    private int count(int i, int j, int m, int n) {
        if (i == n - 1 && j == m - 1) return 1;
        if (i >= n || j >= m) return 0;

        else return count(i + 1, j, m, n) + count(i, j + 1, m, n);
    }

    /*
    Dynamic
    Tc O(n*M)
    sC O(N*m)

     */

    public int uniquePathsDp(int m, int n) {  // TC (0 (n
        int i = 0, j = 0;
        int[][] dp = new int[n][m];
        return countDp(i, j, m, n, dp);
    }

    private int countDp(int i, int j, int m, int n, int[][] dp) {
        if (i == n - 1 && j == m - 1) return 1;
        if (i >= n || j >= m) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        else return dp[i][j] = countDp(i + 1, j, m, n, dp) + countDp(i, j + 1, m, n, dp);
    }


    public int uniquePathsIterative(int m, int n) {
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

}
