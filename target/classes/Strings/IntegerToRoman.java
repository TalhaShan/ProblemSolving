package Strings;

public class IntegerToRoman {
    public static String intToRoman(int num) {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds =
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens =
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] units =
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        System.out.println("Thousand: "+  thousands[num / 1000]);
        System.out.println("hundreds: "+   hundreds[(num % 1000) / 100]);
        System.out.println("tens: "+   tens[(num % 100) / 10]);
        System.out.println("units: "+  units[num % 10]);

        //beats 5%
        //beats 5%

        return thousands[num / 1000] +
                hundreds[(num % 1000) / 100] +
                tens[(num % 100) / 10] +
                units[num % 10];
    }

    public static void main(String[] args) {
        intToRoman(3749);
    }
    /*
    Starting conversion for number: 3749

Step 1 - Thousands index: num / 1000 = 3749 / 1000 = 3
         Thousands Roman: MMM

Step 2 - Hundreds remainder: num % 1000 = 3749 % 1000 = 749
         Hundreds index: 749 / 100 = 7
         Hundreds Roman: DCC

Step 3 - Tens remainder: num % 100 = 3749 % 100 = 49
         Tens index: 49 / 10 = 4
         Tens Roman: XL

Step 4 - Units index: num % 10 = 3749 % 10 = 9
         Units Roman: IX

Final Roman numeral: MMMDCCXLIX
     */

    public String intToRomanTheStringBuilderMakes3ms_98_percentFaster(int num) {
        String[] thousands = { "", "M", "MM", "MMM" };
        String[] hundreds = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
        String[] tens = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
        String[] units = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };


        //beats 98%
        StringBuilder ans = new StringBuilder();

        ans.append(thousands[num / 1000]);
        ans.append(hundreds[(num % 1000) / 100]);
        ans.append(tens[(num % 100) / 10]);
        ans.append(units[num % 10]);

        return ans.toString();
    }

}
