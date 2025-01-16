package STRIVER_SHEET.Recursion;

public class Basic {

    int sum(int n){
        if(n==1){
            return 1;
        }
        int partialAns = sum(n-1);
        return n+ partialAns;
    }
}
