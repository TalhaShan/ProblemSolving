package SlidingWindows;

public class MaximumPointsFromCard {

    public int maxScore(int[] cardPoints, int k) {

        int lSum=0; int rSum=0;  int maxSum=0; int rightIndex = cardPoints.length-1;
        for(int i=0; i<k; i++){

        lSum+=cardPoints[i];
        maxSum=lSum;
        }
        for(int i = k-1; i>=0; i--){
            lSum -=cardPoints[i];
            rSum+=cardPoints[rightIndex];
            rightIndex--;

            maxSum= Math.max(maxSum,lSum+rSum);
        }
        return maxSum;
    }
}
