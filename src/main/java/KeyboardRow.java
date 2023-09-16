import java.util.ArrayList;
import java.util.List;

public class KeyboardRow {
    public String[] findWords(String[] words) {
        String[] rows = new String[2];
        rows[0] = "qwertyuiopQWERTYUIOP";
        rows[1] = "asdfghjklASDFGHJKL";
        rows[2] = "zxcvbnmZXCVBNM";

        List<String> res = new ArrayList<>();


        for (String str : words) {

            if (checkFirstRow(str.toCharArray(), rows[0])
                    || checkFirstRow(str.toCharArray(), rows[1])
                    || checkFirstRow(str.toCharArray(), rows[2])) {
                res.add(str);
            }
        }
        return res.toArray(new String[0]);
    }

    private boolean checkFirstRow(char[] words, String rows) {

        for (char ch : words) {
            if (rows.indexOf(ch) == -1) {
                return false;
            }
        }
        return true;
    }


//    The code snippet you've provided appears to be written in Java. This code is using the toArray method to convert a collection or list into an array of strings. Let me explain how this works:
//
//    java
//    Copy code
//res.toArray(new String[0])
//    Here, res seems to be a collection (e.g., a List<String>) that you want to convert into an array of strings (String[]).
//
//    The argument new String[0] is used to specify the type of the resulting array. It's essentially a template or placeholder array of strings with a length of 0. The toArray method will use this array to determine the type of the resulting array.
//
//    When you pass new String[0] as an argument to toArray, Java will create a new array of strings with the same type as new String[0], but with a size equal to the number of elements in the collection res. The elements from res will be copied into this new array, and the entire array will be returned.
}



/*** Another solution **/
//class Solution {
//    public String[] findWords(String[] words) {
//        String one = "qwertyuiopQWERTYUIOP";
//        String two = "asdfghjklASDFGHJKL";
//        String three = "zxcvbnmZXCVBNM";
//        List<String> list = new LinkedList<>();
//        for(int i=0;i<words.length;i++){
//            if(check(words[i],one) || check(words[i],two) || check(words[i],three)){
//                list.add(words[i]);
//            }
//        }
//        String[] arr = new String[list.size()];
//
//        // Converting ArrayList to Array
//        // using get() method
//        for (int i = 0; i < list.size(); i++)
//            arr[i] = list.get(i);
//
//        return arr;
//    }
//    public boolean check(String s,String checker){
//        boolean temp = true;
//        for(char c : s.toCharArray()){
//            boolean isTrue = false;
//            for(char ch : checker.toCharArray()){
//                if(c == ch){
//                    isTrue = true;
//                    break;
//                }
//            }
//            if(!isTrue){
//                return false;
//            }
//        }
//        return temp;
//
//    }