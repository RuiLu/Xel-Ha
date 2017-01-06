public class Solution {
    /**
     *  Idea -> See comments.
     *  Time complexity -> O(mn)
     *  Space compelxity -> O(1)
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int maxArea = 0;
        
        // Check each element in the matrix once.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') continue;
                if (i == 0 || j == 0) {
                    maxArea = Math.max(maxArea, 1);
                } else {
                    // Do in-space calculation, get minimal area among position (i-1,j), (i,j-1), and (i-1,j-1), finally add one to this area
                    int minLenAround = Math.min(matrix[i-1][j-1]-'0', 
                                              Math.min(matrix[i][j-1]-'0', matrix[i-1][j]-'0'));
                    // Store the area of current square in the right-bottom position.
                    int len = minLenAround+1;
                    matrix[i][j] = (char) (len+'0');
                    maxArea = Math.max(maxArea, len*len);
                }
            }
        }
        
        return maxArea;
    }
}
