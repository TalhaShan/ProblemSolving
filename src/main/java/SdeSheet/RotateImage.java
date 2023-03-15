package SdeSheet;

public class RotateImage {
    //1. Brute force approcah will be to take another matrix and put 1st row in last col
    //2nd row in second col
    //3rd row in first col
    //T(N^2)
    //S(N^2)


    //2.  Optimal approach T(N^2) + T(N^2) ~= T(N^2)
    //Space O(1) in place change

    //steps a. Do transpose
    //  b. Reverse the  row

    public static void rotate(int[][] matrix) {
        int N = matrix.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][N - 1 - j];
                matrix[i][N - 1 - j] = temp;
            }
        }
        System.out.println("DOne");
    }

    //Swap is like

    //Swap is like reverse
/*
    void reverseRow(int mat[N][N], int row) {
        int i = 0, j = N - 1;
        while (i < j) {
            swap(mat[row][i], mat[row][j]);
            i++, j--;
        }
    }
*/
    public static void main(String[] args) {
//        int mat[][] = {{1, 2, 3},
//                       {4, 5, 6},
//                       {7, 8, 9}};

        int mat[][] =
                {{5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {5, 14, 12, 16}};
        rotate(mat);
    }
}
