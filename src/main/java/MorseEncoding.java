import java.util.HashMap;
import java.util.HashSet;

public class MorseEncoding {
    String encoding[] = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
    HashMap<String,Integer> map = new HashMap<>();

    public int uniqueMorseRepresentations(String[] words) {
       int count=0;
        for (int i = 0; i < words.length; i++) {

            if (checkUniqueCombination(words[i].toCharArray())) {
                count++;
            }
        }
        return count;
    }

    public boolean checkUniqueCombination(char[] arr) {
        String collection="";
        for(char ch:arr){
            collection+=encoding[ch-'a'];
        }
        if(!map.containsKey(collection)){
            map.put(collection,1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
     MorseEncoding morseEncoding = new MorseEncoding();
        System.out.println(morseEncoding.uniqueMorseRepresentations(new String[]{"gin","zen","gig","msg"}));
    }
}

//        Input: words = ["gin","zen","gig","msg"]
//                Output: 2
//                Explanation: The transformation of each word is:
//                "gin" -> "--...-."
//                "zen" -> "--...-."
//                "gig" -> "--...--."
//                "msg" -> "--...--."
//                There are 2 different transformations: "--...-." and "--...--.".