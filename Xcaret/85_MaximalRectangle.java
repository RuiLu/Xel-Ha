public class Solution {
    /**
     *  Using the same thought as "Largest Rectangle in Histogram", but turn 1d into 2d,
     *  which means we need to build int[][] heights for each row
     *  Time complexity -> O(mn)
     *  Space complexity -> O(m)
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int maxArea = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] heights = new int[col+1];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < row; i++) {
            /* need to clear stack every time */
            stack.clear();
            for (int j = 0; j <= col; j++) {
                /* get current height */
                if (i == 0) {
                    heights[j] = (j == col ? 0 : matrix[i][j] - '0');
                } else {
                    heights[j] = (j == col ? 0 : (matrix[i][j] == '0' ? 0 : heights[j] + 1)); 
                }
                
                /* do the calculation as "Largest Rectangle in Histogram" does */
                if (stack.isEmpty() || heights[j] >= heights[stack.peek()]) {
                    stack.push(j);
                } else {
                    while (!stack.isEmpty() && heights[j] < heights[stack.peek()]) {
                        int prev = stack.pop();
                        maxArea = Math.max(maxArea, heights[prev] * (stack.isEmpty() ? j : j - 1 - stack.peek()));
                    }
                    stack.push(j);
                }
            }   
        }
        
        return maxArea;
    }
}
