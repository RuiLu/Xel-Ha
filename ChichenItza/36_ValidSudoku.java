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
        if (board == null || board.length != 9 || board[0].length != 9) return false;
        
        for (int i = 0; i < 9; i++) {
            HashSet<Integer> row = new HashSet<>();
            HashSet<Integer> col = new HashSet<>();
            HashSet<Integer> box = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                /* first, check row */
                if (board[i][j] != '.' && !row.add(board[i][j]-'0')) return false;
                
                /* second, check col */
                if (board[j][i] != '.' && !col.add(board[j][i]-'0')) return false;
                
                /* third, check box */
                int newRow = (i/3)*3+j/3;
                int newCol = (i%3)*3+j%3;
                if (board[newRow][newCol] != '.' && !box.add(board[newRow][newCol]-'0')) return false;
            }
        }
        
        return true;
    }
}
