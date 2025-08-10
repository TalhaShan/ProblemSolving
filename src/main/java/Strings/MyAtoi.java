package Strings;

public class MyAtoi {
    /*
    The algorithm for myAtoi(string s) is as follows:

Whitespace: Ignore any leading whitespace (" ").
Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
Return the integer as the final result.
     */
    public int myAtoi(String s) {
        if (s == null)
            return 0;

        s = s.trim();  //remvoe leading space

        if (s.isEmpty())
            return 0;

        int sign = +1;
        long ans = 0;
        if (s.charAt(0) == '-')
            sign = -1;

        int MAX = Integer.MAX_VALUE, MIN = Integer.MIN_VALUE;

        // initiate the starting pointer
        int i = (s.charAt(0) == '+' || s.charAt(0) == '-') ? 1 : 0;

        while (i < s.length()) {
            if (s.charAt(i) == ' ' || !Character.isDigit(s.charAt(i)))
                break;
            ans = ans * 10 + s.charAt(i) - '0';
            // check the conditions
            if (sign == -1 && -1 * ans < MIN)
                return MIN;
            if (sign == 1 && ans > MAX)
                return MAX;

            i++;
        }

        return (int) (sign * ans);
    }
}
