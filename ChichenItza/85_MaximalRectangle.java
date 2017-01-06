public class Solution {
    /**
     *  Idea -> Get heights at every level,
     *          then use the same thought as "Largest Rectangle in Histogram", but turn 1d into 2d, to get maxArea
     * 
     *  Time complexity -> O(mn)
     *  Space complexity -> O(n)
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int maxArea = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] heights = new int[col+1];
        Stack<Integer> stack = new Stack<>();
        
        // Calculate area level by level
        for (int i = 0; i < row; i++) {
            // Clear stack before every round
            stack.clear();
            
            // End condition for j is <= col, the reason is we need to leave out the last position int heights
            for (int j = 0; j <= col; j++) {
                if (i == 0) {
                    heights[j] = j == col ? 0 : matrix[i][j]-'0';
                } else {
                    heights[j] = j == col ? 0 : (matrix[i][j] == '0' ? 0 : heights[j]+1); 
                }
                
                while (!stack.isEmpty() && heights[j] < heights[stack.peek()]) {
                    int prev = stack.pop();
                    maxArea = Math.max(maxArea, heights[prev]*(stack.isEmpty() ? j : j-1-stack.peek()));
                }
                // Donnot forget to push j into stack.
                stack.push(j);
            }
        }
        
        return maxArea;
    }
}
