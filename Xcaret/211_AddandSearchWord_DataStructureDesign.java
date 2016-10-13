public class WordDictionary {
    /**
     *  Implement a Trie
     *  With backtracking to deal with the situation that faces '.'
     */
    class TrieNode {
        TrieNode[] next = null;
        boolean isWord = false;
        
        public TrieNode() {
            next = new TrieNode[26];
        }
    }

    TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        if (word == null || word.length() == 0) return;
        
        char[] wca = word.toCharArray();
        TrieNode curr = root;
        
        for (int i = 0; i < wca.length; i++) {
            int val = wca[i] - 'a';
            if (curr.next[val] == null) {
                curr.next[val] = new TrieNode();
            }
            curr = curr.next[val];
        }
        curr.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    // In this method, we should notice the existence of '.', so we need backtracking
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        TrieNode curr = root;
        return searchHelper(word, curr, 0);
    }
    
    private boolean searchHelper(String s, TrieNode node, int idx) {
        if (s.length() == idx) return node.isWord;
        
        char curr = s.charAt(idx);
        if (curr == '.') {
            boolean hasWord = false;
            for (int i = 0; i < 26; i++) {
                if (node.next[i] != null) hasWord |= searchHelper(s, node.next[i], idx + 1);
            }
            return hasWord;
        } else {
            int val = curr - 'a';
            if (node.next[val] == null) {
                return false;
            } else {
                return searchHelper(s, node.next[val], idx + 1);
            }
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
