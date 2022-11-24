package Nov;

public class NoOfIsland {

    public static  int numIslands(char[][] grid) {
        if(grid==null) return 0;
        int islandCount = 0;
        for(int i =0; i< grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    ++islandCount;
                    convertNeighboursToLand(grid,i,j);
                }
            }
        }
        return islandCount;
    }

    private static void convertNeighboursToLand(char[][] grid, int i, int j) {
        //base case i <0 <j <0

        if(i<0 || j< 0 || i>=grid.length || j >=grid[0].length || grid[i][j]=='0') return;


        grid[i][j] = '0';
        convertNeighboursToLand(grid,i-1,j);  //up
        convertNeighboursToLand(grid,i+1,j);// down
        convertNeighboursToLand(grid,i,j-1); // left
        convertNeighboursToLand(grid,i,j+1); //right

    }

    public static void main(String[] args) {

    }
}
