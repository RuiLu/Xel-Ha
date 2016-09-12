public class Solution {
    /**
     *  One pass -> Time complexity -> O(n)
     *  Explanation:
     *  1. (0, -1) should be put in the map in the very beginning as the initia value
     *  2. Keeping track of cumulative sum, if there is already an equal sum in the map,
     *     ignore the latter, because we want the longest length
     *  3. Using (sum - k) to determine whether the sum of a certen subarray is k! Awesome. 
     */
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        int sum = 0;
        
        map.put(0, -1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if (!map.containsKey(sum)) map.put(sum, i);

            if (map.containsKey(sum - k)) maxLen = Math.max(maxLen, i - map.get(sum - k));                
        }
        
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    } 
    
    /**
     *  Naive way
     *  Time complexity -> O(n^2)
     */
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int len = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) len = Math.max(len, j - i + 1);
            }
        }
        
        return len == Integer.MIN_VALUE ? 0 : len;
    }
}
