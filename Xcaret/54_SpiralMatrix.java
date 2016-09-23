public class Solution {
    /**
     *  Since we access each position in the matrix once,
     *  the time complexity is O(mn)
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        
        int row = matrix.length;
        int col = matrix[0].length;
        int x = 0;
        int y = 0;
        
        while (row > 0 && col > 0) {
            if (row == 1) {
                for (int k = 0; k < col; k++) res.add(matrix[x][y++]);
                break;
            }
            
            if (col == 1) {
                for (int k = 0; k < row; k++) res.add(matrix[x++][y]);
                break;
            }
            
            for (int k = 0; k < col - 1; k++) res.add(matrix[x][y++]);
            for (int k = 0; k < row - 1; k++) res.add(matrix[x++][y]);
            for (int k = 0; k < col - 1; k++) res.add(matrix[x][y--]);
            for (int k = 0; k < row - 1; k++) res.add(matrix[x--][y]);
            
            row -= 2;
            col -= 2;
            x++;
            y++;
        }
        
        return res;
    }
}
