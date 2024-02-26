package DSAShardaAman;

import java.util.*;

public class ArrangeArrayToLargestPart2 {
    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) s[i] = String.valueOf(nums[i]);
        Arrays.sort(s, (a, b) -> (b + a).compareTo(a + b));
        return s[0].equals("0") ? "0" : String.join("", s);
    }

    public String largestNumberTwo(int[] nums) {
        List<String> s = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            s.add(String.valueOf(nums[i]));
        }
        Collections.sort(s, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                String xy = x + y;
                String yx = y + x;

                return xy.compareTo(yx) > 0 ? -1 : 1;
            }
        });

        return  s.get(0).equals("0")?"0" : String.join("",s);
    }
}

// Given an array of numbers, program to
// arrange the numbers to form the
// largest number
//import java.util.*;
//
//class GFG {
//
//    // The main function that prints the
//    // arrangement with the largest value.
//    // The function accepts a vector of strings
//    static void printLargest(Vector<String> arr)
//    {
//
//        Collections.sort(arr, new Comparator<String>()
//        {
//            // A comparison function which is used by
//            // sort() in printLargest()
//            @Override public int compare(String X, String Y)
//            {
//
//                // first append Y at the end of X
//                String XY = X + Y;
//
//                // then append X at the end of Y
//                String YX = Y + X;
//
//                // Now see which of the two
//                // formed numbers
//                // is greater
//                return XY.compareTo(YX) > 0 ? -1 : 1;
//            }
//        });
//
//        Iterator it = arr.iterator();
//
//        while (it.hasNext())
//            System.out.print(it.next());
//    }
//
//    // Driver code
//    public static void main(String[] args)
//    {
//
//        Vector<String> arr;
//        arr = new Vector<>();
//
//        // output should be 6054854654
//        arr.add("54");
//        arr.add("546");
//        arr.add("548");
//        arr.add("60");
//        printLargest(arr);
//    }
//}
//// This code is contributed by Shubham Juneja
