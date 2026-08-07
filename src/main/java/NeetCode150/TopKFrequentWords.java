package NeetCode150;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentWords {

   /* Example 1:

    Input: words = ["i","love","leetcode","i","love","coding"], k = 2
    Output: ["i","love"]
    Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
    Example 2:

    Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
    Output: ["the","is","sunny","day"]
    Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
    */
   public List<String> topKFrequent(String[] words, int k) {

           HashMap<String, Integer> freq = new HashMap<>();
           for(String word : words)
           {
               freq.put(word, freq.getOrDefault(word, 0) + 1);
           }
           PriorityQueue<String> heap = new PriorityQueue<>((a, b) -> {
               if(freq.get(a).equals(freq.get(b)))
               {
                   return b.compareTo(a);
               }
               return freq.get(a) - freq.get(b);
           });
           for(String word : freq.keySet())
           {
               heap.offer(word);
               if(heap.size() > k)
               {
                   heap.poll();
               }
           }
           List<String> res = new ArrayList<>();
           while(!heap.isEmpty())
           {
               res.add(heap.poll());
           }
           Collections.reverse(res);
           return res;
       }


    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        int k = 2;
        System.out.println(new TopKFrequentWords().topKFrequent(words,k));
        String[] words1 = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        int k1 = 4;
        System.out.println(new TopKFrequentWords().topKFrequent(words1,k1));

    }
}
