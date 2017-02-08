public class Solution {
    /**
     *  Idea -> check rows, cols, and boxes.
     *          The trick lies on how to calculate the box area, the way is as below:
     *          newRow = (i / 3) * 3 + j / 3
     *          newCol = (i % 3) * 3 + j % 3
     * 
     *  Time complexity -> O(81)
     *  Space complexity -> O(9)
     */
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        
        Set<Character> row = new HashSet<>();
        Set<Character> col = new HashSet<>();
        Set<Character> box = new HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            /* we should clear these three sets every round */
            row.clear();
            col.clear();
            box.clear();
            
            for (int j = 0; j < 9; j++) {
                /* check row */
                if (board[i][j] != '.' && !row.add(board[i][j])) return false;
                
                /* check col */
                if (board[j][i] != '.' && !col.add(board[j][i])) return false;
                
                /* check box, we should transform the indice */
                int nr = (i/3)*3+j/3;
                int nc = (i%3)*3+j%3;
                if (board[nr][nc] != '.' && !box.add(board[nr][nc])) return false;
            }
        }
        
        return true;
    }
}
