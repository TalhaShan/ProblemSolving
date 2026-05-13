package NeetCode150;

public class KokaEatingBanana {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1; int maxSpeed = 1;
        for(int pile:piles){
            maxSpeed = Math.max(maxSpeed,pile);  //maxspeed will be pile max Value
        }
        while(minSpeed<maxSpeed){
            int mid = minSpeed+(maxSpeed-minSpeed)/2;
            if(canFinish(piles,mid,h)){
                maxSpeed=mid; //mid se hogaya but lets find better value
            }else{
                minSpeed = mid+1; //mid se nai huwa
            }
        }
        return minSpeed;
    }

    public static boolean canFinish(int[] piles, int speed, int h){
        int hours = 0;
        for(int pile:piles){
            hours+=Math.ceil((double)pile/speed);
        }
        return hours<=h; //h limit
    }
}
