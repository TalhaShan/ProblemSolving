package NeetCode150;


class TrieNode {

    private TrieNode[] links;
    private final int ALPHABET_SIZE = 26;
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[ALPHABET_SIZE];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }

}

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();

    }

    public TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (node.containsKey(currentChar)) {
                node = node.get(currentChar);
            } else {
                return null;
            }
        }
        return node;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

}
/*
                    Trie
                     |
                     root
                     |
                     ▼
                 ┌─────────┐
                 │ TrieNode│
                 ├─────────┤
                 │ links[] │──────► 26 possible children
                 │ isEnd   │
                 └─────────┘
                     |
                     ▼
              ┌─────────────┐
              │ TrieNode 'a'│
              ├─────────────┤
              │ links[]     │
              │ isEnd       │
              └─────────────┘
                     |
                     ▼
              ┌─────────────┐
              │ TrieNode 'p'│
              └─────────────┘
                     |
                     ▼
              ┌─────────────┐
              │ TrieNode 'p'│
              │ isEnd = true│ ← "app" ends here
              └─────────────┘
                     |
                     ▼
              ┌─────────────┐
              │ TrieNode 'l'│
              └─────────────┘
                     |
                     ▼
              ┌─────────────┐
              │ TrieNode 'e'│
              │ isEnd = true│ ← "apple" ends here
              └─────────────┘
 */
