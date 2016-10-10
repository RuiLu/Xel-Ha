public class Solution {
    /**
     *  Bucket Sort.
     *  Time complexity & Space complexity -> O(n)
     *  Reference -> https://discuss.leetcode.com/topic/5999/bucket-sort-java-solution-with-explanation-o-n-time-and-space
     * 
     */
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        
        int max = nums[0];
        int min = nums[0];
        int maxGap = Integer.MIN_VALUE;
        
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        
        int gap = (int)Math.ceil((double)(max - min) / (nums.length - 1));
        
        int[] minBucket = new int[nums.length - 1];
        int[] maxBucket = new int[nums.length - 1];
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);
        
        for (int num : nums) {
            if (num == min || num == max) continue;
            
            int idx = (num - min) / gap;
            minBucket[idx] = Math.min(num, minBucket[idx]);
            maxBucket[idx] = Math.max(num, maxBucket[idx]);
        }
        
        int previous = min;
        
        for (int i = 0; i < nums.length - 1; i++) {
            // empty bucket
            if (minBucket[i] == Integer.MAX_VALUE && maxBucket[i] == Integer.MIN_VALUE) {
                continue;
            }
            
            maxGap = Math.max(maxGap, minBucket[i] - previous);
            previous = maxBucket[i];
        }
        // don't forget compare max with last bucket
        maxGap = Math.max(maxGap, max - previous);
        
        return maxGap;
    }
}
