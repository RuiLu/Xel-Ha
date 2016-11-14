/**
 *  Self-define TrieNode
 */
class TrieNode {
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
            char curr = wca[i];
            if (node.next[curr-'a'] == null) node.next[curr-'a'] = new TrieNode();
            node = node.next[curr-'a'];
        }
        
        node.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        
        char[] wca = word.toCharArray();
        TrieNode node = root;
        
        for (int i = 0; i < wca.length; i++) {
            char curr = wca[i];
            if (node.next[curr-'a'] == null) return false;
            node = node.next[curr-'a'];
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
            char curr = pca[i];
            if (node.next[curr-'a'] == null) return false;
            node = node.next[curr-'a'];
        }
        
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
