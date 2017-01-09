public class Solution {
    /**
     *  Idea -> Backtracking + Trie.
     *          Trie is pre-built, used for storing words in words array.
     *          Backtracking is checking process.
     */
    class TrieNode {
        TrieNode[] next;
        String word;
        
        public TrieNode() {
            next = new TrieNode[26];
            word = null;
        }
    }
        
    private void buildTrie(String word, TrieNode node) {
        for (char ch : word.toCharArray()) {
            int idx = ch-'a';
            if (node.next[idx] == null) node.next[idx] = new TrieNode();
            node = node.next[idx];
        }
        node.word = word;
    }
     
    private void backtracking(char[][] board, TrieNode node, int i, int j, boolean[][] visited, List<String> res) {
        /* Case 1, we have already visited this position */
        if (visited[i][j]) return;
        
        int idx = board[i][j]-'a';
        node = node.next[idx];
        
        /* Case 2, Trie doesn't have the current character in this node. */
        if (node == null) return;
        
        /* Case 3, current node contains a word */
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }
        
        /* Case 4, check neighbors */
        visited[i][j] = true;
        if (i > 0) backtracking(board, node, i-1, j, visited, res);
        if (j > 0) backtracking(board, node, i, j-1, visited, res);
        if (i < board.length-1) backtracking(board, node, i+1, j, visited, res);
        if (j < board[0].length-1) backtracking(board, node, i, j+1, visited, res);
        visited[i][j] = false;
    } 
     
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return res;
        }
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        TrieNode root = new TrieNode();
        
        /* Build Trie */
        for (String word : words) {
            if (word == null || word.length() == 0) continue;
            buildTrie(word, root);
        }
        
        /* Check every position on board */
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtracking(board, root, i, j, visited, res);
            }
        }
        
        return res;
    }
    
}
