package SdeSheet;

import java.util.Arrays;

public class JobSequenceProblem {

    static class Job{
        int id;
        int deadline;
        int profit;

        public Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }

        int[] JobScheduling(Job arr[], int n) {

            Arrays.sort(arr,(a,b) -> (b.profit-a.profit));  //sort in descending order of profit
            //find max deadline
            int maxDead = 0 ;
            for(int i = 0 ; i <n; i++){
                if(arr[i].deadline>maxDead){
                    maxDead = arr[i].deadline;
                }
            }
            //Now we have deadline max we can create array of that length to stroe jobs with time and id
            int res[] = new int[maxDead+1];
            //Now we will iterate on sorted and place job id in res in last possible then second
            // last possible seq and so on until array is filled or iterated in mean time we will also add result
            int countJobs = 0;
            int maxProfit= 0;
            Arrays.fill(res, -1);
            for(int i = 0 ; i< n ; i++){

                for(int j = arr[i].deadline; j>0; j--){
                        if(res[j]!=-1){ //slot is empty put job
                            res[j] = arr[i].id;
                            countJobs++;
                            maxProfit+=arr[i].profit;
                            break;
                        }
                }
            }
            int ans[] = new int[2];
            ans[0] = countJobs;
            ans[1] = maxProfit;
            return ans;
        }
    }
}
