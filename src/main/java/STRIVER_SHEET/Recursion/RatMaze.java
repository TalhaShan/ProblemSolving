package com.demo.project;

import java.util.ArrayList;
import java.util.List;

public class RatMaze {
    //Matrix will be filled with 1 and 0 on 0 you cannot move
    List<String> findPath(int[][] matrix){
        List<String> ans=new ArrayList<>();
        int n = matrix.length;
        boolean[][] visited = new boolean[n][n];
        String path="";
        helper(matrix,0,0,path,ans,visited);
        return ans;
    }

    private void helper(int[][] matrix, int row, int col, String path, List<String> ans, boolean[][] visited) {

        //But How do we stop Infinite recursion like up down up down can be stuck so we need something called visited flag matrix

        int n= matrix.length;
        if(row<0 || col <0 || row>=n || col>=n || matrix[row][col]==0 || visited[row][col]){
            return;
        }
        if(row==n-1 && col==n-1){
            ans.add(path);
            return;
        }
        visited[row][col] =true;
        helper(matrix,row+1,col,path+'D',ans, visited);
        helper(matrix,row-1,col,path+'U',ans, visited);
        helper(matrix,row,col-1,path+'L',ans, visited);
        helper(matrix,row,col+1,path+'R',ans, visited);
        visited[row][col] =false; //back track
    }

    List<String> findPathOptimize(int[][] matrix){
        //hmm 0 can be treated as already visited because we cannot visited right so we can remove our visited matrix
        //so let mark the visited to -1
        List<String> ans=new ArrayList<>();
        String path="";
        helperOptimize(matrix,0,0,path,ans);
        return ans;
    }

    private void helperOptimize(int[][] matrix, int row, int col, String path, List<String> ans) {

        //But How do we stop Infinite recursion like up down up down can be stuck so we need something called visited flag matrix

        int n= matrix.length;
        if(row<0 || col <0 || row>=n || col>=n || matrix[row][col]==0 || matrix[row][col]== -1){
            return;
        }
        if(row==n-1 && col==n-1){
            ans.add(path);
            return;
        }
        matrix[row][col] = -1;
        helperOptimize(matrix,row+1,col,path+'D',ans );
        helperOptimize(matrix,row-1,col,path+'U',ans);
        helperOptimize(matrix,row,col-1,path+'L',ans);
        helperOptimize(matrix,row,col+1,path+'R',ans);
        matrix[row][col] = 1; //back track
    }

   // Time Complexity 4 ^n ^2  // 4 ki power n square
    // n x n total cells with 4 options
    //Space with Optimize none ,
    // with visited matrix Space n^2

}
