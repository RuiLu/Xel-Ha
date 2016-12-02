public class Solution {
    /**
     *  Idea -> Trie
     */
    private class TrieNode {
        TrieNode[] next;
        String word;
        
        public TrieNode() {
            next = new TrieNode[26];
            word = null;
        }
    } 
     
    private void buildTrie(String word, TrieNode node) {
        if (word == null || word.length() == 0) return;
        char[] wca = word.toCharArray();
        for (int i = 0; i < wca.length; i++) {
            if (node.next[wca[i]-'a'] == null) node.next[wca[i]-'a'] = new TrieNode();
            node = node.next[wca[i]-'a'];
        }
        node.word = word;
    }
     
    private void dfs(char[][] board, int i, int j, List<String> res, TrieNode node) {
        char curr = board[i][j];
        if (curr == '#' || node.next[curr -'a'] == null) return;
        
        node = node.next[curr-'a'];
        
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }
        
        /* We need both dfs and backtracking here */
        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j, res, node);
        if (i < board.length - 1) dfs(board, i + 1, j, res, node);
        if (j > 0) dfs(board, i, j - 1, res, node);
        if (j < board[0].length - 1) dfs(board, i, j + 1, res, node);
        board[i][j] = curr;
    }
     
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return res;
        }
        
        TrieNode root = new TrieNode();
        
        for (String word : words) {
            buildTrie(word, root);
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, res, root);
            }
        }
        
        return res;
    } 
     
    
}
