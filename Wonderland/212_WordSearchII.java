/**
 *  Vocabulary or Word related questions, using TRIE, easy to build and retrieve.
 */
public class Solution {
    // Second attemp -> Trie
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        
        for (String word : words) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (node.next[index] == null) node.next[index] = new TrieNode();
                node = node.next[index];
            }
            node.word = word;
        }
        
        return root;
    }
    
    private void dfs(char[][] board, TrieNode node, int i, int j, List<String> res) {
        char ch = board[i][j];
        if (ch == '#' || node.next[ch - 'a'] == null) return;
        
        node = node.next[ch - 'a'];
        if (node.word != null) {
            res.add(node.word);
            node.word = null;       // de-duplicate -> Once found, this word becomes invalid next time
        }
        
        board[i][j] = '#';      // '#' indicates that this position has been visited
        
        if (i > 0) dfs(board, node, i - 1, j, res);
        if (i < board.length - 1) dfs(board, node, i + 1, j, res);
        if (j > 0) dfs(board, node, i, j - 1, res);
        if (j < board[0].length - 1) dfs(board, node, i, j + 1, res);
        
        board[i][j] = ch;       // backtracking!
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) return res;
        
        TrieNode root = buildTrie(words);
        int row = board.length, col = board[0].length;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(board, root, i, j, res);
            }
        }
        
        return res;
    }
    
    
    // First attemp ! -> TLE, but works!
    // public List<String> findWords(char[][] board, String[] words) {
    //     List<String> res = new ArrayList<>();
    //     Set<String> set = new HashSet<>();
    //     if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
    //         return res;
    //     }
        
    //     int row = board.length;
    //     int col = board[0].length;
        
    //     for (int i = 0; i < row; i++) {
    //         for (int j = 0; j < col; j++) {
    //             for (String word : words) {
    //                 char first = word.charAt(0);
    //                 if (first == board[i][j]) {
    //                     dfs(board, word, 1, i, j, first+"", set);       
    //                 }
    //             }
    //         }
    //     }
        
    //     res.addAll(set);
    //     return res;
    // }
    
    // private void dfs(char[][] board, String word, int index, int i, int j, 
    //                  String sb, Set<String> set) {
    //     if (word.equals(sb)) {
    //         set.add(word);
    //         return;
    //     }
        
    //     if (index >= word.length()) return;
        
    //     char curr = board[i][j];
    //     board[i][j] = '#';
        
    //     if (i > 0 && board[i-1][j] == word.charAt(index)) {
    //         dfs(board, word, index+1, i-1, j, sb + (board[i-1][j]+""), set);
    //         sb.substring(0, sb.length() - 1);
    //     }
    //     if (i < board.length - 1 && board[i+1][j] == word.charAt(index)) {
    //         dfs(board, word, index+1, i+1, j, sb + (board[i+1][j]+""), set);
    //         sb.substring(0, sb.length() - 1);
    //     }
    //     if (j > 0 && board[i][j-1] == word.charAt(index)) {
    //         dfs(board, word, index+1, i, j-1, sb + (board[i][j-1]+""), set);
    //         sb.substring(0, sb.length() - 1);
    //     }
    //     if (j < board[0].length - 1 && board[i][j+1] == word.charAt(index)) {
    //         dfs(board, word, index+1, i, j+1, sb + (board[i][j+1]+""), set);
    //         sb.substring(0, sb.length() - 1);
    //     }
        
    //     board[i][j] = curr;
    
    // }

}
