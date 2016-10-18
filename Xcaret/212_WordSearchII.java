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
    
    private void dfs(List<String> res, char[][] board, TrieNode node, int i, int j) {
        char curr = board[i][j];
        if (curr == '#' || node.next[curr - 'a'] == null) return;
        
        node = node.next[curr - 'a'];
        
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }
        
        board[i][j] = '#';
        if (i - 1 >= 0) dfs(res, board, node, i - 1, j);
        if (i + 1 < board.length) dfs(res, board, node, i + 1, j);
        if (j - 1 >= 0) dfs(res, board, node, i, j - 1);
        if (j + 1 < board[0].length) dfs(res, board, node, i, j + 1);
        board[i][j] = curr;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return res;
        }
        
        int row = board.length;
        int col = board[0].length;
        TrieNode root = buildTrie(words);
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(res, board, root, i, j);
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
