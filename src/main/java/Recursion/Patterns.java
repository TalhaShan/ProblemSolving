package Recursion;

public class Patterns {
    static void printPat(int row,int col){
        if(row==0){
            return;
        }

        while (col<=row){
            System.out.print("*");
            col++;
        }
        System.out.println();
        printPat(--row,0);

    }

    static void printPat2(int row,int col){
        if(row==0){
            return;
        }
        if(col<row){
            System.out.print("*");
            printPat2(row,col+1);
        }else {
            System.out.println();
            printPat2(row-1,0);
        }
    }

    static void printPat3(int row,int col){
        if(row==0){
            return;
        }
        if(col<row){
             printPat3(row,col+1);
            System.out.print("*");

        }else {
            printPat3(row-1,0);
            System.out.println();

        }
    }

    public static void main(String[] args) {
//        printPat(4,0);
//        printPat2(4,0);
        printPat3(4,0);

    }
}
