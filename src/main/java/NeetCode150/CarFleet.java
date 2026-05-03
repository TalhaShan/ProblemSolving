package NeetCode150;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2]; //n cars 2 rows 2 cols pos & speed
        for(int i=0;i <n; i++){
            cars[i][0] = position[i]; //pos feed
            cars[i][1] = (double)(target-position[i])/speed[i]; //speed or time to target feed
        }

        Arrays.sort(cars,(a,b)->Double.compare(b[0],a[0]));

        int count =0;
        double prevTime=0;
        for(double[] car:cars){
            if(car[1]>prevTime){
                count++; //new fleet
                prevTime= car[1]; // new spped/time set to join fleet if somone faster will join
            }
        }
        return count;

    }
    public int carFleetByStack(int target, int[] position, int[] speed) {
        int n = position.length;

        int[][] cars = new int[n][2];
        for(int i = 0;i<n;i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars,(a, b) -> Integer.compare(b[0],a[0]));

        Stack<Double> st = new Stack<>();

        for(int []car : cars){
            int pos = car[0];
            int spd = car[1];
            double timeTaken = (double)(target - pos) / spd;

            if(st.isEmpty() || timeTaken > st.peek()){
                st.push(timeTaken);
            }
        }

        return st.size();
    }
}
