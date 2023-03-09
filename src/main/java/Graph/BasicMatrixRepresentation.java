package Graph;

import java.util.Arrays;

public class BasicMatrixRepresentation {
    public static void main(String[] args) {
        int n = 3, m = 3;
        int adj[][] = new int[n + 1][m + 1];


// Fill each row with 1.0
        for (int[] row : adj){
            Arrays.fill(row, 0);
    }

    //edge  1-2 undirected graph
        adj[1][2] = 1;
        adj[2][1] = 1;

        //edge 2-3
        adj[2][3] = 1;
        adj[3][2] = 1;

        //edge 1-3
        adj[1][3] = 1;
        adj[3][1] = 1;
    }
}
