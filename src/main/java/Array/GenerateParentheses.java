package Array;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        int openB = n;
        int closeB = n;
        generateApproachOne(res, n, n, "");
        generateApproachTwo(res, 0, 0, "", n);
        return res;
    }

    private void generateApproachOne(List<String> res, int open, int close, String currentStr) {
        if (open == 0 && close == 0) {
            res.add(currentStr);
            return;
        }
        if (open != 0) {  //we will give prioirty to open bracket becasue we have to balance out so open will be first
            generateApproachOne(res, open - 1, close, currentStr + "(");
        }
        if (close > open) {  //beacuse we cannot put close first so if we have like open =0  avb and close 1 , 2 avb we
            //should not used it beacuse will not be able to balanced this out
            //it means k is closing bracket ka open pair achucka hai so you  can use close bracket now
            generateApproachOne(res, open, close - 1, currentStr + ")");
        }
    }

    private void generateApproachTwo(List<String> res, int open, int close, String currentStr, int max) {
    //incremental appraoch
        if(currentStr.length()==max*2){
            res.add(currentStr);
            return;
        }
        if(open<max) { //starting from 0 so <
            generateApproachTwo(res,open+1,close,currentStr + "(",max);
        }
        if(close<open){
            generateApproachTwo(res,open,close+1,currentStr + ")",max);
        }

    }
}
