package Array;

import java.util.ArrayList;
import java.util.List;

public class Spiral {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int top =0,left = 0;
        int right = matrix[0].length-1;
        int bottom = matrix.length-1;
        while (top<=bottom && left<=right) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {  // the condition on this will always work to stop vertical line to print
                res.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom) {  // to stop duplication row wise elements always check top<bottom //see below test case
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
            }
            bottom--;
            if(left<=right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
       // System.out.println(spiralOrder(new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}}));  //first check example
        System.out.println(spiralOrder(new int[][] {{7,9,6}}));  //second check example


    }

}
