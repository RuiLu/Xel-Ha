public class Solution {
    /**
     * Idea -> See comments.
     * Time complexity -> O(n)
     */
    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        
        for (Integer num : nums) {
            /* de-duplicate, because we use Integer to initialize, so we should use equals() to compare to Integers. */
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
        
        /* if there is not max3 exists, then we return the biggest one, which is max1. */
        return max3 == null ? max1 : max3;
    }
}
