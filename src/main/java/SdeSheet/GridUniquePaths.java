package SdeSheet;

public class GridUniquePaths {
    //Approcah 1 Recursion Check all the paths

    public static int uniquePaths(int m, int n) {
        //return countPaths(m,n,0,0);
        int[][] dp = new int [ n-1][m-1];

    return countPathsDp(m,n,0,0,dp);


    }

    static int countPaths(int m, int  n, int  i,int j){
        if(i>=n || j>=m){
            return 0;
        }
        if(i==n-1 &&  j==m-1){
            return 1;
        }
        return countPaths(m,n,i+1,j)+countPaths(m,n,i,j+1);
    }
    static int countPathsDp(int m, int  n, int  i,int j,int[][] dp){
        if(i>=n || j>=m){
            return 0;
        }
        if(i==n-1 &&  j==m-1){
            return 1;
        }
        if(dp[i][j]!=0) {
            return dp[i][j];
        }

        else return dp[i][j]=countPaths(m,n,i+1,j)+countPaths(m,n,i,j+1);
    }



    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
    }



}
