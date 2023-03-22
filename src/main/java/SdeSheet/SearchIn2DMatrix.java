package SdeSheet;

public class SearchIn2DMatrix {
    //Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]],
//    We can do a simple linear search on 2d matrix, but it will cost us O(n*m)

    //Approach 1 We can do binary search on each row (N*Log2M)
    //Approcah 2 for GFG question row wise col wise sorted
    //[10,20,30,40
    //     11,21,36,43
    //     25.29,39,50
    //     50,60,70,80
    // ]
//    target = 25
    //What we can do we can place our pointer on 40 right extreme of first row
    //then check if 40>25 yes move left
    //30>25 move left
    //20<25// move down 21//<25 move down
    //29>25 //move left
    //25==25 found
    //false case will be out of bound col wise or row wise stop
    static boolean gfgSearchIn2d(int[][] arr, int target) {

        int n = arr.length;
        int m = arr[0].length;
        int i = 0;
        int j = m - 1;
        while (i < n && j >= 0) {

            if (arr[i][j] == target) {
                return true;
            } else if (arr[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    //Approach for LeetCode
    //1 , 3, 5, 7
    //10, 11, 16, 20
    //23, 30, 34, 50
    // Cond 1:as we notice all row is sorted
    //Cond 2: The first integer of each row is greater than the last integer of the previous row.
    //A twisted statement if we see starting fromm 0,0 to end it's an sorted array -> direction
    //Approach we can move all this to array and then apply Binary search but iT will use extra space 0(n*M)
    //Can we just imagine the index and do Bs yES , and from index we can find actual position magic /,%

    //how to iamgine index hmm 4X4 matrix index would be 0,11 right (12 toatal) so we can say 0-(n*m-1)
    //Steps calculate mid
    //low =0 , high= n*m-1;
    //mid
    //now convert mid to actual value of arr /m %m formula.
    //Tc (Log2(n*m)
    //Space O(1)


    static boolean leetCodeOptimal(int[][] arr, int target) {
        int n = arr.length;
        int m = arr[0].length;
        int low = 0;
        int high = (n * m) - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid / m][mid % m] == target) {
                return true;
            } else if (arr[mid / m][mid % m] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return false;
    }
}
