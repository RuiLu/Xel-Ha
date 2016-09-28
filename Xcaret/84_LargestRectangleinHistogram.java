public class Solution {
    /**
     *  Using stack
     *  Reference -> https://discuss.leetcode.com/topic/7599/o-n-stack-based-java-solution
     *  Time complexity -> O(n)
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length ? 0 : heights[i]);
            
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                int prev = stack.pop();
                maxArea = Math.max(maxArea, heights[prev] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
                /** 
                 *  we need to do i-- here, because we need to calculate maxArea by retriving all previous heights
                 *  which are higher than the current height 
                 */
                i--;
            }
        }
        
        return maxArea;
    }
    
    /**
     *  Time complexity -> O(n^2)
     *  Time Limit Exceeded.
     */
    // public int largestRectangleArea(int[] heights) {
    //     if (heights == null || heights.length == 0) return 0;
        
    //     int maxArea = Integer.MIN_VALUE;
        
    //     for (int i = 0; i < heights.length; i++) {
    //         int minHeight = heights[i];
    //         for (int j = i; j < heights.length; j++) {
    //             if (heights[j] == 0) break;
    //             minHeight = Math.min(minHeight, heights[j]);
    //             maxArea = Math.max(maxArea, minHeight * (j-i+1));
    //         }
    //     }
        
    //     return maxArea == Integer.MIN_VALUE ? 0 : maxArea;
    // }
}
