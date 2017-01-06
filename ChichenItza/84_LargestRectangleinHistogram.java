public class Solution {
    /**
     *  Explanation -> http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        
        for (int i = 0; i <= heights.length; i++) {
            int height = 0;
            if (i < heights.length) height = heights[i];
            
            while (!stack.isEmpty() && height < heights[stack.peek()]) {
                int prev = stack.pop();
                maxArea = Math.max(maxArea, heights[prev]*(stack.isEmpty() ? i : i-1-stack.peek()));
            }
            stack.push(i);
        }
        
        return maxArea;
    }
}
