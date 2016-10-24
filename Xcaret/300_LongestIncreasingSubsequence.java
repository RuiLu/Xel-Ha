public class Solution {
    /**
     *  Idea -> Binary Search
     */
    private int findPosInTmp(int[] tmp, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (tmp[mid] == target) return mid;
            else if (tmp[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;
    } 
     
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int[] tmp = new int[nums.length];
        tmp[0] = nums[0];
        int max = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > tmp[max-1]) {
                tmp[max] = nums[i];
                max++;
            } else {
                int pos = findPosInTmp(tmp, 0, max - 1, nums[i]);
                tmp[pos] = nums[i];
            }
        }
        
        return max;
    }
    
    /**
     *  Idea -> Dynamic Programming
     *  Time complexity -> O(n^2)
     *  Space complexity -> O(1)
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int res = 1;
        int[] dp = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            res = Math.max(res, dp[i]);
        }
        
        
        return res;
    }
}
