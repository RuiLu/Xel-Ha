public class Solution {
    /**
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        
        int len = height.length;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        int total = 0;
        
        for (int i = 0; i < len; i++) {
            maxLeft[i] = i == 0 ? height[i] : Math.max(maxLeft[i-1], height[i]);
            maxRight[len-i-1] = i == 0 ? height[len-i-1] : Math.max(maxRight[len-i], height[len-i-1]);
        }
        
        for (int i = 0; i < len; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            total += Math.max(0, min - height[i]);
        }
        
        return total;
    }
}
