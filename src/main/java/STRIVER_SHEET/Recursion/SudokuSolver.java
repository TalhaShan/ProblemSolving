package com.demo.project;

public class SudokuSolver {

    //we 9 * 9 board
    public static boolean solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {

                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;

                            if (solveSudoku(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c)
                return false;

            if (board[row][i] == c)
                return false;

            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        char[][] board= {
                {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };
        solveSudoku(board);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }
//Another approach

    class Solution2 {
        public void solveSudoku(char[][] board) {
            solve(board);
        }

        private boolean solve(char[][] board) {
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    if (board[row][col] == '.') {
                        for (char num = '1'; num <= '9'; num++) {
                            if (isValid(board, row, col, num)) {
                                board[row][col] = num;
                                if (solve(board)) return true;
                                board[row][col] = '.';
                            }
                        }
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean isValid(char[][] board, int row, int col, char num) {
            for (int i = 0; i < 9; i++) {
                if (board[row][i] == num || board[i][col] == num) return false;
            }
            int startRow = (row / 3) * 3;
            int startCol = (col / 3) * 3;
            for (int i = startRow; i < startRow + 3; i++) {
                for (int j = startCol; j < startCol + 3; j++) {
                    if (board[i][j] == num) return false;
                }
            }
            return true;
        }
    }

    /*
    🔲 3×3 Sub-grid Check: What You Asked About
The Goal:
Every Sudoku board is made of 9 smaller 3×3 grids (sub-boxes). You have to make sure that the number you're placing isn’t already in the same sub-grid.

These two lines:
java
Copy
Edit
int startRow = (row / 3) * 3;
int startCol = (col / 3) * 3;
Let’s say you're trying to place a number at cell (5, 7) (row 5, column 7). What’s its 3×3 box?

To find the top-left corner (start indices) of the 3×3 box containing that cell:

row / 3 = 1, then 1 * 3 = 3 → so startRow = 3

col / 3 = 2, then 2 * 3 = 6 → so startCol = 6

Which means, (5,7) is in the 3×3 box that starts at (3,6) and goes to (5,8).

Loop through the 3x3 grid:
java
Copy
Edit
for (int i = startRow; i < startRow + 3; i++) {
    for (int j = startCol; j < startCol + 3; j++) {
        if (board[i][j] == num) return false;
    }
}
     */
}
