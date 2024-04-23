package SdeSheet;

import java.util.ArrayList;
import java.util.List;

public class
PascalTriangle {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> first_row = new ArrayList<>();
        first_row.add(1);
        triangle.add(first_row);
        for(int i=1; i<numRows; i++){
            List<Integer> prev_row = triangle.get(i-1);
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j = 1; j<i; j++){
                row.add(prev_row.get(j-1)+prev_row.get(j));
            }
            row.add(1);
            triangle.add(row);
        }

        return triangle;
    }

    private void printUseRecursion(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k <= i; k++) {
                System.out.print(" " + factorial(i) / (factorial(i - k) * factorial(k)));
            }

            System.out.println();
        }
    }


    public void printUseBinomialExpansion(int n) {
//        Another way to print Pascal's triangle without recursion is to use binomial expansion.
//
//        We always have the value 1 at the beginning of each line, then the value of k at the (n) line and the (i) position will be calculated as:
//
//        k = ( k * (n - i) / i )

        
        for (int line = 1; line <= n; line++) {
            for (int j = 0; j <= n - line; j++) {
                System.out.print(" ");
            }

            int k = 1;
            for (int i = 1; i <= line; i++) {
                System.out.print(k + " ");
                k = k * (line - i) / i;
            }

            System.out.println();
        }
    }
    public int factorial(int i) {
        if (i == 0) {
            return 1;
        }
        return i * factorial(i - 1);
    }

    //
    public static void main(String[] args) {

    }

}
