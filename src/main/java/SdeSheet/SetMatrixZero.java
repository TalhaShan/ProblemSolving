package SdeSheet;

public class SetMatrixZero {

    //first run for 0 row and 0 col and find any natural 0 put x = 0 and y =0;
    //then we will check for 3d matrix and marked the any zero found with corresponding position on O row or 0 col
    // then we will run to which one to convert 0 we will check on which row 0 is found or col 0 is found we will convert entire row or col to zero
    //then in last we will check for 0 row and 0 col that we have to make it zero or not and for that if x ==0 or y==0 then if x row entire zero and col entire 0 if y==0


    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int col = matrix[0].length;
        int x = 1, y = 1;
        //iterating first col
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                y = 0;
            }
        }
        //iterating first row
        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == 0) {
                x = 0;
            }
        }

        //iterating over inner matrix

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }


        //now markers are set now we need to check 0 row and 0 col and marked whole row and col 0

        for (int j = 1; j < col; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < rows; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < col; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        //set first row 0
        if (x == 0) {
            for (int j = 0; j < col; j++)
                matrix[0][j] = 0;
        }
        //set first col 0

        if (y == 0) {
            for (int i = 0; i < rows; i++)
                matrix[i][0] = 0;
        }
    }
}
    /*
00 01 02 03
10 11 12 13
20 21 22 23
30 31 32 33

        void setZeroes(vector<vector<int>>& matrix)
        {
        int rows = matrix.size();
        int cols = matrix[0].size();

        // for the first row & first col set x=1 & y=1 respectively as flag values.
        int x=1, y=1;

        //iterating first col
        for(int i=0; i<rows; i++)
        {
        if(matrix[i][0] == 0)
        y = 0;
        }

        //iterating first row
        for(int j=0; j<cols; j++)
        {
        if(matrix[0][j] == 0)
        x = 0;
        }

        //iterating over inner matrix
        for(int i=1; i<rows; i++)
        {
        for(int j=1; j<cols; j++)
        {
                  /* if in inner matrix you find any 0 then set
                    corresponding initial row & column markers as 0

        if(matrix[i][j] == 0)
        {
        matrix[i][0]=0;
        matrix[0][j]=0;
        }
        }
        }

        when the above markers are 0, then set corresponding
           whole row and column markers as 0


        for(int j=1; j<cols; j++)
        {
        if(matrix[0][j]==0)
        {
        for(int i=1; i<rows; i++)
        matrix[i][j]=0;
        }
        }

        for(int i=1; i<rows; i++)
        {
        if(matrix[i][0]==0)
        {
        for(int j=1; j<cols; j++)
        matrix[i][j] = 0;
        }
        }

        // if x=0 and y=0 then set whole row and column as 0

        if(x==0)
        {
        for(int j=0;j<cols;j++)
        matrix[0][j] = 0;
        }

        if(y==0)
        {
        for(int i=0;i<rows;i++)
        matrix[i][0] = 0;
        }
        */

