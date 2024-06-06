package STRIVER_SHEET.Arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    //case 1 : Given row and colum like  r= 5 , c=2 tell the element
    /* Actual logic behind
    1. n-1
          C
       r-1

   2.  n!/r! * (n-r)!

    */
//        1
//        1 1
//        1 2 1
//        1 3 3 1
//        1 4 6 4 1

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        res.add(ans);
        for(int i=1; i<numRows; i++){
            ans = new ArrayList<>();
            List<Integer> prevRow = res.get(i-1);
            ans.add(1);
            for(int j=1; j<i; j++){
                ans.add(prevRow.get(j)+prevRow.get(j-1));
            }
            ans.add(1);
            res.add(ans);
        }

        return res;
    }

}
