package StriverSDE.BinarySearch;

public class NthRootOfNumber {

//    input n = 3 , m = 27
//    is nth root exist for m?yes?ans:no:-1

    public static int findNthRootLinear(int n, int m) {  //T(O(M*log2n)

        for (int i = 2; i < m; i++) {
            //    int count = n;
//            int root = 1;
//            while (count > 0) {
//                root *= i;
//                count--;
//            }
            int root = (int) Math.pow(i, n);
            if (root > m) {
                return -1;   // not possible now already exceed
            }
            if (root == m) {
                return i;
            }
        }
        return -1;
    }


    public static int findNthRootOptimal(int n, int m) {
//actually we will be running binary on answes
//        https://takeuforward.org/data-structure/nth-root-of-a-number-using-binary-search/
        int low = 1;
        int high = m;
//        1 ---- m the answer lies in this range
        while (low <= high) {
            int mid = (low + high) / 2;
            int midAnswer = calculatePower(mid, m, n);
            if (midAnswer == 1) {
                return mid;
            } else if (midAnswer == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int calculatePower(int mid, int m, int n) {
        int ans = 1;
        for (int i = 1; i <= n; i++) {  //why not using buitl in power because for big caluclation 10^9 for 100 times how will you store

            ans = ans * mid;
            if (ans > mid) return 2;  //stopping oveflow or uselsess calculation
        }
        if (ans == m) {
            return 1;
        }
        return 0;  //lesss than
    }

    public static void main(String[] args) {
        System.out.println(findNthRootLinear(3, 729));
    }

    // 3 x 3 x 3 x3  = 81 and if you want 69 of 4 cube then just break the loop after 81 because 3 times already  on 81 so you cannot get 69 now.

}
