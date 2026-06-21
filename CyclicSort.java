package NeetCode150;

/*
Find duplicate
Implment this in java with swapping techinque on correct index
Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [3,3,3,3,3]
Output: 3
 */
public class CyclicSort {

        public int findDuplicate(int[] nums) {
            int i = 0;

            while (i < nums.length) {
                int correctIndex = nums[i] - 1;

                if (nums[i] != nums[correctIndex]) { ////first time the element is not placed even duplicate one so we need to repalce
                    swap(nums, i, correctIndex);
                } else {
                    if (i != correctIndex) {
                        return nums[i]; //not the index of number matches with good value should be
                    }
                    i++;
                }
            }

            return -1; // should never reach here as duplicate always exists
        }

        private void swap(int[] nums, int first, int second) {
            int temp = nums[first];
            nums[first] = nums[second];
            nums[second] = temp;
        }


        /** Better one **/

    class Solution {//more simpler version of imp
        public int findDuplicate(int[] nums) {
            int i = 0;

            while (i < nums.length) {
                if (nums[i] != i + 1) { //no on correct place element enter there
                    int correct = nums[i] - 1;  //find correct index of it

                    if (nums[i] == nums[correct]) { //oops --- already placed the corrected one before so duplicated detected
                        return nums[i];
                    }

                    swap(nums, i, correct);  // if not there correct one, normal case just swap it from correct index.
                } else { //handle cases---already on correct position no need to do anything move on like 1 2 3 4 5 correct sequence
                    i++;
                }
            }

            return -1;
        }

        private void swap(int[] nums, int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }

}
