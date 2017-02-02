public class Solution {
    /**
     * Idea -> Use HashMap, the HashMap stores the sum of all elements before index i as key, and i as value.
     *         For each, check not only the current sum but also (currentSum-previousSum) to see if there is any
     *         subsequence sum that equals k, and update maximal length.
     * Time complexity -> O(n)
     */
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        
        int sum = 0;
        int maxLen = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) maxLen = i+1;
            else if (map.containsKey(sum-k)) maxLen = Math.max(maxLen, i-map.get(sum-k));
            /* we need to find the maximal length, so if the sum exists in the HashMap already, we donot change it. */
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}
