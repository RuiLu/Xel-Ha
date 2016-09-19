public class Solution {
    /**
     *  Two pointers
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;
        
        int lo = 0;
        int hi = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        
        while (lo <= hi) {
            int minHeight = Math.min(height[lo], height[hi]);
            maxArea = Math.max(maxArea, minHeight * (hi - lo));
            
            if (height[lo] >= height[hi]) hi--;
            else lo++;
        }
        
        return maxArea == Integer.MIN_VALUE ? 0 : maxArea;
    }
}
