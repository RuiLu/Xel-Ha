/**
 *  Easy to understand when drawing a picture
 * 
 */
public class Solution {
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int x = 0;
        int y = 0;
        
        while (row > 0 && col > 0) {
            
            if (row == 1) {
                for (int i = 0; i < col; i++) {
                    res.add(matrix[x][y++]);
                }
                break;
            }
            
            if (col == 1) {
                for (int i = 0; i < row; i++) {
                    res.add(matrix[x++][y]);
                }
                break;
            }
            
            for (int i = 0; i < col - 1; i++) res.add(matrix[x][y++]);
            for (int i = 0; i < row - 1; i++) res.add(matrix[x++][y]);
            for (int i = 0; i < col - 1; i++) res.add(matrix[x][y--]);
            for (int i = 0; i < row - 1; i++) res.add(matrix[x--][y]);
            
            row -= 2;
            col -= 2;
            
            x += 1;
            y += 1;
        }
        
        return res; 
    }
}
