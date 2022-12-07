package BinarySearchInterviewQuestion;

public class SmallestLetterGreaterThanTarget {

    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (target < letters[middle]) {
                end = middle-1;
            } else{
                start = middle + 1;
            }

        }
        return letters[start%letters.length];
            //start % N where N is length of array so in case in range it will return range index else if

        //max last it will retun index 0
    }

    public static void main(String[] args) {

        char arr[] = {'c','f','j'};
        char target = 'a';
        System.out.println(nextGreatestLetter(arr,target));
    }
}
