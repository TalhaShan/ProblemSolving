package STRIVER_SHEET.GreedyAlgorithms;


import java.util.Arrays;

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }

    class solve {
        // return an array of size 2 having the 0th element equal to the count
        // and 1st element equal to the maximum profit
        int[] JobScheduling(Job arr[], int n) {
            Arrays.sort(arr, (a, b) -> (b.profit - a.profit));
            int maxi = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i].deadline > maxi) {
                    maxi = arr[i].deadline;
                }
            }
            int res[] = new int[maxi + 1];
            Arrays.fill(res, -1);
            int countJobs = 0;
            int Profit = 0;

            for (int i = 0; i < n; i++) {
                for (int j = arr[i].deadline; j > 0; j--) { // uski maximum deadline se neche tk last 1
                    if (res[j] == -1) {
                        res[j] = i;
                        countJobs++;
                        Profit += arr[i].profit;
                        break;
                    }

                }
            }
            return new int[]{countJobs, Profit};
        }
    }
}