package NeetCode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeString {

    public String encode(List<String> strs) {    //258 will be good num out of range so just taking at is unique
        if(strs.isEmpty()) return Character.toString((char)(258)); ///vlaue reutrn will be reached to decoder thatswhys same check at decode

        String separator = Character.toString((char)257); //choosing it because 255 chars are possible in input so taking out of ranage
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s).append(separator);
        }
        sb.deleteCharAt(sb.length()-1);//no need of separator for last one
        return sb.toString();
    }

    public  List<String>  decode(String strs) {
        if(strs.equals(Character.toString((char)258))) return new ArrayList<>();
        String separator = Character.toString((char)257);
        return Arrays.asList(strs.split(separator,-1));
    }


    public static void main(String[] args) {
        EncodeAndDecodeString e = new EncodeAndDecodeString();
        System.out.println(e.encode(Arrays.asList("abc","def")));
        System.out.println(e.decode(e.encode(Arrays.asList("abc","def"))));
    }

    /* Understanding -1 default behaviour without -1
        i/p : "abc#def#".split("#")
        o/p: ["abc", "def"]

        👉 The last empty string is dropped
     */

    /*
    i/p  "abc#def#".split("#", -1)
    o.p  ["abc", "def", ""]
      👉 The last empty string is preserved
     */
}
