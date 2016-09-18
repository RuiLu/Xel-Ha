public class Solution {
    /**
     *  Bucket Sort.
     *  Time complexity & Space complexity -> O(n)
     *  Reference -> https://discuss.leetcode.com/topic/5999/bucket-sort-java-solution-with-explanation-o-n-time-and-space
     * 
     */
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        
        int maxLen = Integer.MIN_VALUE;
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        
        int gap = (int)Math.ceil((double)(max - min) / (len - 1));
        int[] minBucket = new int[len - 1];
        int[] maxBucket = new int[len - 1];
        
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);
        
        for (int num : nums) {
            if (num == min || num == max) continue;
            
            int idx = (num - min) / gap;
            
            minBucket[idx] = Math.min(minBucket[idx], num);
            maxBucket[idx] = Math.max(maxBucket[idx], num);
        }
        
        int prev = min;
        
        for (int i = 0; i < len - 1; i++) {
            if (minBucket[i] == Integer.MAX_VALUE && maxBucket[i] == Integer.MIN_VALUE) {
                continue;
            }
            
            maxLen = Math.max(maxLen, minBucket[i] - prev);
            
            prev = maxBucket[i];
        }
        
        /* Don't forget compare the last "curr" to max */
        maxLen = Math.max(maxLen, max - prev);
        
        return maxLen;
    } 
    
}
