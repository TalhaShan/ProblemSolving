package SdeSheet;

public class FindDuplicateInNplus1 {

    //1ST APPROCAH SORT IT AND THEN CHECK arr[i]==ar[i+1] break;
   // O(Nlogn + N)

    //2nd approach used frequency array
    //code for approach 2
//    Time Complexity: O(N), as we are traversing through the array only once.

//    Space Complexity: O(N), as we are using extra space for frequency array.
    static int findDuplicate(int[] arr) {
        int n =  arr.length;
        int[] freq = new int[n+1];
        for(int i = 0; i<n; i++){
            if(freq[arr[i]]==0){  //mapping index value of freq with actual value of
                freq[arr[i]]=1;
            }else {
                // freq is not 0 at index
                //duplicate found
                return arr[i];
            }
        }
        return 0;
    }

    //Approach 3 cyclle detection
    public static int findDuplicateWithCycle(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String args[]) {
        int arr[] = {1,3,4,2,3};
        System.out.println("The duplicate element is " + findDuplicateWithCycle(arr));
    }
}
