public class Solution {
    /**
     *  Bucket Sort.
     *  Time complexity & Space complexity -> O(n)
     *  Reference -> https://discuss.leetcode.com/topic/5999/bucket-sort-java-solution-with-explanation-o-n-time-and-space
     * 
     */
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        int len = nums.length - 1;
        int gap = (int)Math.ceil((double)(max - min) / len);
        int[] minBucket = new int[len];
        int[] maxBucket = new int[len];
        
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);
        
        for (int num : nums) {
            if (num == min || num == max) continue;
            
            int idx = (num - min) / gap;
            
            minBucket[idx] = Math.min(num, minBucket[idx]);
            maxBucket[idx] = Math.max(num, maxBucket[idx]);
        }
        
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        
        for (int i = 0; i < len; i++) {
            if (minBucket[i] == Integer.MAX_VALUE && maxBucket[i] == Integer.MIN_VALUE) continue;
            
            maxGap = Math.max(minBucket[i] - previous, maxGap);
            previous = maxBucket[i];
        }
        
        maxGap = Math.max(max - previous, maxGap);
        
        return maxGap;
    } 
    
    /**
     *  But... still Time Limited Exceeded...
     *  Time complexity & Space complexity -> O(n)
     *  Idea -> First pass, find maximum value. 
     *          Second pass, put values into a new array whose length is the maximum value,
     *                       we also need minmum value to start the third pass.
     *          Third pass, go through this array.
     */
    // public int maximumGap(int[] nums) {
    //     if (nums == null || nums.length < 2) return 0;
        
    //     int maxGap = 0;
    //     int maxVal = Integer.MIN_VALUE;
    //     int minVal = Integer.MAX_VALUE;
        
    //     for (int num : nums) {
    //         maxVal = Math.max(maxVal, num);
    //         minVal = Math.min(minVal, num);
    //     }
        
    //     int[] temp = new int[maxVal + 1];
        
    //     for (int num : nums) {
    //         temp[num]++;
    //     }
        
    //     for (int curr = minVal; curr <= maxVal;) {
    //         int next = curr + 1;
            
    //         while (next <= maxVal && temp[next] == 0) next++;
            
    //         maxGap = Math.max(maxGap, next - curr);
            
    //         curr = next;
    //     }
        
    //     return maxGap;
    // }
}
