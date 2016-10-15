public class Solution {
    /**
     *  Idea -> Trie
     */
    class TrieNode {
        TrieNode[] next = null;
        String word = null;
        
        public TrieNode() {
            next = new TrieNode[26];
        }
    } 
     
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        
        for (String word : words) {
            TrieNode node = root;
            
            for (int i = 0; i < word.length(); i++) {
                int val = word.charAt(i) - 'a';
                if (node.next[val] == null) node.next[val] = new TrieNode();
                node = node.next[val];
            }
            
            node.word = word;
        }
        
        return root;
    }
     
    private void dfs(char[][] board, TrieNode node, int i, int j, List<String> res) {
        char ch = board[i][j];
        if (ch == '#' || node.next[ch - 'a'] == null) return;
        
        node = node.next[ch - 'a'];
        
        // when we found a qualified word, we add it into res, then set it to null to avoid duplicates
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }
        
        // backtracking idea
        board[i][j] = '#';
        if (i - 1 >= 0) dfs(board, node, i - 1, j, res);
        if (j - 1 >= 0) dfs(board, node, i, j - 1, res);
        if (i + 1 < board.length) dfs(board, node, i + 1, j, res);
        if (j + 1 < board[0].length) dfs(board, node, i, j + 1, res);
        board[i][j] = ch;
    } 
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return res;
        }
        
        TrieNode root = buildTrie(words);
        int row = board.length;
        int col = board[0].length;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(board, root, i, j, res);
            }
        }
        
        return res;
    } 
     
    /**
     *  Idea ->  backtracking
     *  Time Limit Exceeded
     */
    // public List<String> findWords(char[][] board, String[] words) {
    //     List<String> res = new ArrayList<>();
    //     if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
    //         return res;
    //     }
        
    //     int row = board.length;
    //     int col = board[0].length;
    //     Set<String> set = new HashSet<>();
    //     Set<String> tmp = new HashSet<>();
        
    //     for (String word : words) set.add(word);
        
    //     for (int i = 0; i < row; i++) {
    //         for (int j = 0; j < col; j++) {
    //             char curr = board[i][j];
    //             for (String word : set) {
    //                 if (curr == word.charAt(0)) {
    //                     if (existWord(board, new boolean[row][col], word, 0, i, j)) {
    //                         tmp.add(word);
    //                     }
    //                 }
    //             }
    //         }
    //     }
        
    //     for (String s : tmp) res.add(s);
        
    //     return res;
    // }
    
    // private boolean existWord(char[][] board, boolean[][] visited, String word, int idx, int i, int j) {
    //     if (idx == word.length() || word.length() == 1) return true;
    //     if (visited[i][j]) return false;
    //     if (board[i][j] != word.charAt(idx)) return false;
        
    //     visited[i][j] = true;
    //     boolean work = false;
        
    //     if (i - 1 >= 0) work |= existWord(board, visited, word, idx + 1, i - 1, j);
    //     if (j - 1 >= 0) work |= existWord(board, visited, word, idx + 1, i, j - 1);
    //     if (i + 1 < board.length) work |= existWord(board, visited, word, idx + 1, i + 1, j);
    //     if (j + 1 < board[0].length) work |= existWord(board, visited, word, idx + 1, i, j + 1);
        
    //     visited[i][j] = false;
        
    //     return work;
    // }
}
