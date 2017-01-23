public class Solution {
    /**
     * Idea -> See comments.
     * Time complexity -> O(n)
     */
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        
        for (Integer num : nums) {
            /* if num is equal to max1 or max2 or max3, then we should continue to avoid duplicate. 
             * since we are using Integer here, we should compare two Integers using equals(). */
            if (num.equals(max1) || num.equals(max2) || num.equals(max3)) continue;
            
            if (max1 == null || num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (max2 == null || num > max2) {
                max3 = max2;
                max2 = num; 
            } else if (max3 == null || num > max3) {
                max3 = num;
            }
        }
        
        return max3 == null ? max1 : max3;
    }
}
