class TrieNode {
    // Initialize your data structure here.
    TrieNode[] next = null;
    boolean isWord = false;
    
    public TrieNode() {
        next = new TrieNode[26];
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
        
        char[] wca = word.toCharArray();
        TrieNode node = root;
        
        for (int i = 0; i < wca.length; i++) {
            int idx = wca[i] - 'a';
            if (node.next[idx] == null) {
                node.next[idx] = new TrieNode();
            }
            node = node.next[idx];
        }
        node.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        
        char[] wca = word.toCharArray();
        TrieNode node = root;
        
        for (int i = 0; i < wca.length; i++) {
            int idx = wca[i] - 'a';
            if (node.next[idx] == null) return false;
            node = node.next[idx];
        }
        
        return node.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) return false;
        
        char[] pca = prefix.toCharArray();
        TrieNode node = root;
        
        for (int i = 0; i < pca.length; i++) {
            int idx = pca[i] - 'a';
            if (node.next[idx] == null) return false;
            node = node.next[idx];
        }
       
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
