package NeetCode150;

import java.util.HashMap;
import java.util.Map;

class TrieNodes {
    boolean word = false;
    Map<Character, TrieNodes> children = new HashMap();

    public TrieNodes() {

    }

    class AddSearchWordDictionary {
        TrieNodes root;

        public AddSearchWordDictionary() {
            root = new TrieNode();
        }


        public void addWord(String word) {
            TrieNodes node = root;
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNodes());
                }
                node = node.children.get(c);
            }
            node.word = true;
        }

        public boolean searchInNode(TrieNodes node, String word) {
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.children.containsKey(ch)) {
                    if (ch == '.') {
                        for (char x : node.children.keySet()) {
                            if (searchInNode(node.children.get(x), word.substring(i + 1))) {
                                return true;
                            }
                        }
                    } else {
                        return false;
                    }
                } else {
                    node = node.children.get(ch);
                }
            }
            return node.word;
        }

        public boolean search(String word) {
            return searchInNode(root, word);

        }
    }
}
