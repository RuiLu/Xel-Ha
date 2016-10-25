public class Solution {
    /**
     *  Since we access each position in the matrix once,
     *  the time complexity is O(mn)
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return list;
        
        int x = 0;
        int y = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        
        while (row > 0 && col > 0) {
            if (row == 1) {
                for (int i = 0; i < col; i++) list.add(matrix[x][y++]);
                break;
            }
            if (col == 1) {
                for (int i = 0; i < row; i++) list.add(matrix[x++][y]);
                break;
            }
            
            for (int i = 0; i < col - 1; i++) list.add(matrix[x][y++]);
            for (int i = 0; i < row - 1; i++) list.add(matrix[x++][y]);
            for (int i = 0; i < col - 1; i++) list.add(matrix[x][y--]);
            for (int i = 0; i < row - 1; i++) list.add(matrix[x--][y]);
            
            x += 1;
            y += 1;
            row -= 2;
            col -= 2;
        }
        
        return list;
    }
}
