package LinkedList;

public class IsHappyNumber {
    public boolean isHappy(int n) {

        int fast = n;
        int slow = n;
        do {
            fast = square(square(fast));
            slow = square(slow);
        } while (fast != slow);
        if (slow == 1) {
            return true;
        }
        return false;
    }

    private int square(int num) {
        int ans  = 0;
        while (num>0){
            int rem = num%10;
            ans+=rem*rem;
            num = num/10;
        }

        return ans;
    }


}
