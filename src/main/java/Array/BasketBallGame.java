package Array;

import java.util.ArrayList;
import java.util.List;

public class BasketBallGame {


//    Input: ops = ["5","2","C","D","+"]
//    Output: 30
//    Explanation:
//            "5" - Add 5 to the record, record is now [5].
//            "2" - Add 2 to the record, record is now [5, 2].
//            "C" - Invalidate and remove the previous score, record is now [5].
//            "D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
//            "+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
//    The total sum is 5 + 10 + 15 = 30
    public int calPoints(String[] operations) {

        List<Integer> arr = new ArrayList<>();

        for (String str:operations){
            if(isInteger(str)){
                arr.add(Integer.parseInt(str));

            }else {
                switch (str){
                    case "C":
                    if(!arr.isEmpty()) {
                        arr.remove(arr.size() - 1);
                    }
                    break;

                    case "D":
                    arr.add(arr.get(arr.size()-1)*2);
                    break;

                    case "+":
                    arr.add(arr.get(arr.size()-1)+arr.get(arr.size()-2));
                    break;

                    default:
                    break;

                }
            }
        }
            return arr.parallelStream().mapToInt(Integer::intValue).sum();
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
//
//    public int calPoints(String[] op) {
//        ArrayList<Integer> a=new ArrayList<>();
//        int sum=0;
//        for(int i=0;i<op.length;i++)
//        {
//            if(Character.isDigit(op[i].charAt(0)))
//            {
//                a.add(Integer.parseInt(op[i]));
//            }
//            else if(op[i].charAt(0)=='-')
//            {
//                a.add(Integer.parseInt(op[i]));
//            }
//            else if(op[i].equals("D"))
//            {
//                a.add(a.get(a.size()-1)*2);
//            }
//            else if(op[i].equals("C"))
//            {
//                a.remove(a.size()-1);
//            }
//            else if(op[i].equals("+"))
//            {
//                a.add(a.get(a.size()-1)+a.get(a.size()-2));
//            }
//        }
//        for(int i:a)
//        {
//            sum+=i;
//        }
//        return sum;
//    }