package DSAShardaAman;

public class RepeatAndMissingNumber {
    public static int[] repeatedNumbers(final int[] arr) {
//                  Index:[0,1,2,3,4]
//                  Input:[2,1,2,4,5]
//      Correct placement:[1,2,3,4,5]
//        Output:[3, 4]
//
//        A = 3, B = 4
        // [ 1,2,3,3,5]

        int[] ans = new int[2];
        for (int i = 0; i < arr.length; i++) {
            int x = Math.abs(arr[i] - 1);
            if (arr[x] < 0) {
                //found repeating
                ans[0] = x + 1;
            } else {
                arr[arr[i] - 1] *= -1;
            }
        }

        //missing
//        [-2,-1,2,-4,-5] // 3 was not there so element at index 2 remains positive.
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>0){
                ans[1] = i+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        repeatedNumbers(new int[]{3, 1, 2, 5, 3});
    }

    // 1. Sorting  // nlogn
    // 2. Take Extra Array // O(n) , 0(n)
    //3. summation a. add all(both array) b. take square add all (both array) c. make eqautin etc but problem in square may be overflow

}
