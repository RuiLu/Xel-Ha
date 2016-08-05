public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0 || height.length == 1) return 0;
        
        int len = height.length;
        int trapAmount = 0;
        int[] leftToRight = new int[len];
        leftToRight[0] = height[0];
        int[] rightToLeft = new int[len];
        rightToLeft[len-1] = height[len-1];
        for (int i = 1; i < len; i++) {
            leftToRight[i] = Math.max(leftToRight[i-1], height[i]);
            rightToLeft[len-i-1] = Math.max(rightToLeft[len-i], height[len-i-1]);
        }
        for (int i = 0; i < len; i++) {
            leftToRight[i] = Math.min(leftToRight[i], rightToLeft[i]);
            if (leftToRight[i] > height[i]) trapAmount += leftToRight[i] - height[i];
        }
        return trapAmount;
    }
}
