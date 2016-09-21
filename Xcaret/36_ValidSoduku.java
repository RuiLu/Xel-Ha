public class Solution {
    /**
     *  Determine whether the give Sudoku is valid
     *  Time complexity -> O(9 * 9) -> O(c)
     */
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> box = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                /* 1. check row */
                if (board[i][j] != '.') {
                    if (row.contains(board[i][j])) return false;
                    row.add(board[i][j]);
                }
                
                /* 2. check col */ 
                if (board[j][i] != '.') {
                    if (col.contains(board[j][i])) return false;
                    col.add(board[j][i]);
                }
                
                /* 3. check box */
                int newRow = (i / 3) * 3 + j / 3;
                int newCol = (i % 3) * 3 + j % 3;
                if (board[newRow][newCol] != '.') {
                    if (box.contains(board[newRow][newCol])) return false;
                    box.add(board[newRow][newCol]);
                }
            }
        }
        
        return true;
    }
}
