class TrieNode {
    // Initialize your data structure here.
    TrieNode[] next;
    String word;
    
    public TrieNode() {
        next = new TrieNode[26];
        word = null;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.next[ch-'a'] == null) node.next[ch-'a'] = new TrieNode();
            node = node.next[ch-'a'];
        }
        node.word = word;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.next[ch-'a'] == null) return false;
            node = node.next[ch-'a'];
        }
        return node.word != null;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) return false;
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (node.next[ch-'a'] == null) return false;
            node = node.next[ch-'a'];
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
