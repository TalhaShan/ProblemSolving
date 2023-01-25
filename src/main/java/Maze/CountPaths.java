package Maze;

import java.util.ArrayList;
import java.util.Arrays;

public class CountPaths {

    public static void main(String[] args) {
        //System.out.println(countWays(3, 3));
        // System.out.println(printWaysDiagonal("", 3, 3));

//

        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int[][] path = new int[board.length][board[0].length];
        allPathPrint("", board, 0, 0, path, 1);
    }

    static int countWays(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }
        int left = countWays(r - 1, c);
        int right = countWays(r, c - 1);
        return left + right;
    }

    static void printWays(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }
        if (r > 1) {
            printWays(p + "D", r - 1, c);
        }
        if (c > 1) {
            printWays(p + "R", r, c - 1);
        }
    }

    static ArrayList<String> printWaysDiagonal(String p, int r, int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> res = new ArrayList<>();
        if (r > 1 && c > 1) {
            res.addAll(printWaysDiagonal(p + "D", r - 1, c - 1));
        }
        if (r > 1) {
            res.addAll(printWaysDiagonal(p + "V", r - 1, c));
        }
        if (c > 1) {
            res.addAll(printWaysDiagonal(p + "H", r, c - 1));
        }
        return res;
    }

    public static void pathRestrictions(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }
        if (!maze[r][c]) {
            return;
        }
        if (r < maze.length - 1) {
            pathRestrictions(p + "D", maze, r + 1, c);
        }
        if (c < maze[0].length - 1) {
            pathRestrictions(p + "R", maze, r, c + 1);
        }
    }

    public static void pathMazeAllDirections(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }
        if (!maze[r][c]) {
            return;   //if already visited return then
        }
        //We are considered one of this block in our path
        maze[r][c] = false;
        if (r < maze.length - 1) {
            pathMazeAllDirections(p + "D", maze, r + 1, c);
        }
        if (c < maze[0].length - 1) {
            pathMazeAllDirections(p + "R", maze, r, c + 1);
        }
        if (r > 0) {
            pathMazeAllDirections(p + "U", maze, r - 1, c);
        }

        if (c > 0) {
            pathMazeAllDirections(p + "L", maze, r, c - 1);
        }
        //this is where func getting over or returning the result so we need to revert the changes we made
        maze[r][c] = true;
    }

    public static void pathMazeAllDirectionsWithSteps(String p, boolean[][] maze, int r, int c, int path[][], int steps) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c] =steps;
            for(int[] arr:path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if (!maze[r][c]) {
            return;   //if already visited return then
        }
        //We are considered one of this block in our path
        maze[r][c] = false;
        path[r][c] = steps;
        if (r < maze.length - 1) {
            pathMazeAllDirectionsWithSteps(p + "D", maze, r + 1, c, path, steps + 1);
        }
        if (c < maze[0].length - 1) {
            pathMazeAllDirectionsWithSteps(p + "R", maze, r, c + 1, path, steps + 1);
        }
        if (r > 0) {
            pathMazeAllDirectionsWithSteps(p + "U", maze, r - 1, c, path, steps + 1);
        }

        if (c > 0) {
            pathMazeAllDirectionsWithSteps(p + "L", maze, r, c - 1, path, steps + 1);
        }
        //this is where func getting over or returning the result so we need to revert the changes we made
        maze[r][c] = true;
        path[r][c] = 0;
    }




    /*** real **/
    static void allPathPrint(String p, boolean[][] maze, int r, int c, int[][] path, int step) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c] = step;
            for(int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        // i am considering this block in my path
        maze[r][c] = false;
        path[r][c] = step;
        if (r < maze.length - 1) {
            allPathPrint(p + 'D', maze, r+1, c, path, step+1);
        }

        if (c < maze[0].length - 1) {
            allPathPrint(p + 'R', maze, r, c+1, path, step+1);
        }

        if (r > 0) {
            allPathPrint(p + 'U', maze, r-1, c, path, step+1);
        }

        if (c > 0) {
            allPathPrint(p + 'L', maze, r, c-1, path, step+1);
        }

        // this line is where the function will be over
        // so before the function gets removed, also remove the changes that were made by that function
        maze[r][c] = true;
        path[r][c] = 0;
    }
}
