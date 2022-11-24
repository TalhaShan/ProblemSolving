package Nov;

public class MinPathSum {

    public int minPathSum(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //will check left and up and will pick min of that
                //because we can only move right and down  //bottom  - behind
                int top = i - 1 < 0 ? Integer.MAX_VALUE : grid[i - 1][j];  //if going out of bound just select the max so bottom value will be selected later becuase we use Min
                int bottom = j - 1 < 0 ? Integer.MAX_VALUE : grid[i][j - 1];

                int min = top == Integer.MAX_VALUE && bottom == Integer.MAX_VALUE ? 0 : Math.min(top, bottom);  //IF BOTH ARE OUT OF BOUND THE WE WILL GO WITH 0 like posiotn [0][0]
                grid[i][j] += min;

            }
        }
        return grid[n - 1][m - 1];  //the last grid will contain the min sum
    }

    //our goal is  grid[0][0]->gird[last][last]
}
