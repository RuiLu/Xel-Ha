public class Solution {
    /**
     *  Time complexity -> O(9 * 9) -> O(c)
     *  Space complexity -> O(3 * 9)
     */
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> box = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (row.contains(board[i][j])) return false;
                    row.add(board[i][j]);
                }
                if (board[j][i] != '.') {
                    if (col.contains(board[j][i])) return false;
                    col.add(board[j][i]);
                }
                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);
                if (board[rowIndex + j / 3][colIndex + j % 3] != '.') {
                    if (box.contains(board[rowIndex + j / 3][colIndex + j % 3])) return false;
                    box.add(board[rowIndex + j / 3][colIndex + j % 3]);
                }
            }
        }
        return true;
    }
    
    /**
     *  Time complexity -> O(9 * 9)
     *  Space complexity -> Not sure, but with only one set
     */
    // public boolean isValidSudoku(char[][] board) {
    //     Set<String> seen = new HashSet<>();
    //     for (int i = 0; i < 9; i++) {
    //         for (int j = 0; j < 9; j++) {
    //             char number = board[i][j];
    //             if (number != '.') {
    //                 if (!seen.add(number + " in row " + i) ||
    //                     !seen.add(number + " in col " + j) ||
    //                     !seen.add(number + " in box " + i / 3 + "-" + j / 3)) return false;
    //             }
    //         }
    //     }
    //     return true;
    // }
}
