package com.demo.project;

public class MColoringProblem {

    public boolean graphColoring(boolean[][] graph, int m, int n) {
        // Your code here
        int[] color =new int[n];

        return helper(graph,color,m,n,0);  // current i at 0th node
    }

    private boolean helper(boolean[][] graph, int[] color, int m, int n, int i) {
        if(i==n) return true;

        for(int j =1; j<=m ;j++){
            if(isSafe(graph,color,n,i,j)){
                color[i] = j;
                if(helper(graph,color,m,n,i+1)){
                    return true;
                }
                color[i] = -1;
            }
        }
        return false;
    }
    public boolean isSafe(boolean[][] graph, int[] color, int n, int i, int j){

        for(int k=0;k<n;k++){
            if(graph[i][k]==true && color[k]==j){ //has connection and has same color the adjacent node.
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
