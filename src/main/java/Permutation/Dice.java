package Permutation;

public class Dice {
    static void diceComb(String ans ,int target){
        if(target==0){
            System.out.println(ans);
            return;
        }
        for(int i = 1; i<=6 && i<=target; i++) {
            diceComb(ans + i, target - i);
        }
    }

    public static void main(String[] args) {
        diceComb("",4);
    }
}
