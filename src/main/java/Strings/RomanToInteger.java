package Strings;

public class RomanToInteger {

    public static int romanToInt(String s) {
//        Example 1:
//
//        Input: s = "III"
//        Output: 3
//        Explanation: III = 3.
//        Example 2:
//
//        Input: s = "LVIII"
//        Output: 58
//        Explanation: L = 50, V= 5, III = 3.
//        Example 3:
//
//        Input: s = "MCMXCIV"
//        Output: 1994
//        Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

        if(s.length()==1){
            return getValue(s.charAt(0));
        }
        int finalValue = 0;
        int preValue = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (getValue(s.charAt(i)) >= getValue(s.charAt(i + 1))) {
                finalValue += getValue(s.charAt(i));
            } else {
                finalValue += getValue(s.charAt(i + 1)) - getValue(s.charAt(i));
                i += 1;
            }
            preValue = i;
        }

        if (preValue == s.length() - 2) {
            finalValue+=getValue(s.charAt(s.length()-1));
        }


        return finalValue;
    }

    public static int getValue(char romanDigit) {
        switch (romanDigit) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0; // Invalid Roman numeral
        }
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("D"));
    }
}
