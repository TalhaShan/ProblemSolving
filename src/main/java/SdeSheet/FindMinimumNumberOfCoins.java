package SdeSheet;

import java.util.ArrayList;
import java.util.List;

public class FindMinimumNumberOfCoins {


    //Like we have 49 so we have to used minimum number of coins
    //so we will pick 20+20+5+2+2
    //Steps we will start from left and first element pick will obviously be the number less than coin required to make
    //then we will add and subtract from coin required then we will again check can we add this or not
    //if yes we will add
    //if not we will move ahead remember we are moving backward.

    //we might be wondering there can be case we pick up the coin twice or wrong combination and we move
    // pointer ahead and making up the required coin will not be possible now.

    //But this will never happened due to domination
    //if you see coin array {1,2,5,10,20,50,100,500,1000}; and this array = {1,5,6,9}
    //Required is to make 11
    //coin array will take 9,1,1  == 3 coins
    //this array will take  5,6 == 2 coins
    //why because of sequence in this array previous two number can be greater than next element
    // like 5+6 >9 where else in coin array this cannot be case 1+2< 5 always, 5+10  <20
    //so this is why 3 coins answer is correct in this problem and also wrong combination won't be possible.

    //T  0(v) //can be give to make coin 1 so worst case scenario to check till last
    static List<Integer> coinsUsed(int[] v, int coin) {
        List<Integer> res = new ArrayList<>();
        int left = v.length - 1;
        while (coin != 0) {
            if (v[left] <= coin) {
                coin -= v[left];
                res.add(v[left]);
            } else {
                left--;
            }
        }
        return res;
    }

    public static void main(String[] args) {


        int v[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        System.out.println(coinsUsed(v, 121));
    }


}
