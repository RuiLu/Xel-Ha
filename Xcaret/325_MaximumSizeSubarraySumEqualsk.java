public class Solution {
    /**
     *  Idea -> Use HashMap
     *          New a accumulative sum array, and record its value and position in Map.
     *          If we meet the duplicate values, we keep the first appearing position (longest length).
     *  Reference -> https://discuss.leetcode.com/topic/33537/java-o-n-explain-how-i-come-up-with-this-idea
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        
        int len = nums.length;
        int maxLen = Integer.MIN_VALUE;
        int[] tmp = new int[len+1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
    
        for (int i = 1; i <= len; i++) {
            tmp[i] += tmp[i-1] + nums[i-1];
            if (!map.containsKey(tmp[i])) map.put(tmp[i], i);
        }
        
        for (int i = len; i >= 0; i--) {
            int diff = tmp[i] - k;
            if (map.containsKey(diff)) maxLen = Math.max(maxLen, Math.max(0, i - map.get(diff)));
        }
        
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}
