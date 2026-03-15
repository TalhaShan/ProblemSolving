package NeetCode150;

import java.util.HashSet;

class IsValidSudoku {
    public boolean isValidSudokuValidation(char[][] board) {
        //explained in your personal spiral book
        int N= 9; //the given board is 9*9
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];

        for(int i=0; i<N; i++){
            rows[i] = new HashSet<Character>();
            cols[i] = new HashSet<Character>();
            boxes[i] = new HashSet<Character>();
        }
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){

                char val = board[r][c];
                if(val =='.'){
                    continue;
                }
                //validate rows
                if(rows[r].contains(val)){
                    return false;
                }
                rows[r].add(val);

                //validate cols
                if(cols[c].contains(val)){
                    return false;
                }
                cols[c].add(val);

                //check boxes 3*3
                int boxIndex = (r/3)*3 + c/3;
                if(boxes[boxIndex].contains(val)){
                    return false;
                }
                boxes[boxIndex].add(val);

            }

        }
        return true;
    }

    //Another Approach
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int boxIndex = (i / 3) * 3 + (j / 3);

                    if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) { //any true failed validation
                        return false;
                    }

                    rows[i][num] = cols[j][num] = boxes[boxIndex][num] = true; //marking box true or visited
                }
            }
        }
        return true;
    }
}
