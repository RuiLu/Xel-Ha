public class WordDictionary {
    /**
     *  Idea -> Trie
     */
    
    class TrieNode {
        TrieNode[] next;
        boolean isWord;
        
        public TrieNode() {
            next = new TrieNode[26];
            isWord = false;
        }
    }
    
    private TrieNode root = new TrieNode();
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        if (word == null || word.length() == 0) return;
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.next[ch-'a'] == null) node.next[ch-'a'] = new TrieNode();
            node = node.next[ch-'a'];
        }
        node.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        TrieNode node = root;
        return search(node, word);
    }
    
    private boolean search(TrieNode node, String word) {
        if (word.equals("")) return node.isWord;
        
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch != '.') {
                if (node.next[ch-'a'] == null) return false;
                else node = node.next[ch-'a'];
            } else {
                boolean isWord = false;
                for (int j = 0; j < node.next.length; j++) {
                    if (node.next[j] != null) isWord |= search(node.next[j], word.substring(i+1));
                }
                return isWord;
            }
        }
        
        return node.isWord;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
