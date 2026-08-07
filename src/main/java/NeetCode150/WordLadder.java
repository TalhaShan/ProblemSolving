package NeetCode150;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        queue.offer(null);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {

            String word = queue.poll();

            if (word == null) {
                level++;
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
                continue;
            }

            if (word.equals(endWord))
                return level;

            for (int i = 0; i < word.length(); i++) {
                char[] chars = word.toCharArray();

                for (char c = 'a'; c <= 'z'; c++) {
                    chars[i] = c;
                    String newWord = new String(chars);

                    if (!visited.contains(newWord) && dict.contains(newWord)) {
                        visited.add(newWord);
                        queue.offer(newWord);
                    }
                }
            }
        }

        return 0;
    }
}
