package Strings;

public class LongestOddNumberInString {


//    Example 1:
//    Input: num = "52"
//    Output: "5"
//    Explanation: The only non-empty substrings are "5", "2", and "52". "5" is the only odd number.

//    Example 2:
//    Input: num = "4206"
//    Output: ""
//    Explanation: There are no odd numbers in "4206".

//    Example 3:
//    Input: num = "35427"
//    Output: "35427"
//    Explanation: "35427" is already an odd number.

        public static  String largestOddNumber(String num) {
            for (int i = num.length() - 1; i >= 0; i--) {
                if ((num.charAt(i) - '0') % 2 != 0) { //also works without  charAt(i) - '0'
                    // why because works by chance, because ASCII codes for odd digits happen to be odd numbers.
                    //but not a good approach cleaner safe side is  (num.charAt(i)-'0')
                    return num.substring(0, i + 1);
                }
            }
            return "";
        }


    public String largestOddNumberBuiltIn(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if (Character.getNumericValue(num.charAt(i)) % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println(largestOddNumber("1234567"));
    }
}
