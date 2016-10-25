public class Solution {
    /**
     *  Idea -> Binary Search, sometimes you need to sacrifice space to speed up
     *  Time complexity -> O(nlogn)
     *  Space complexity -> O(n)
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
        
        int len = nums.length;
        int[] tmp = new int[len];
        int max = 0;
        
        tmp[max++] = nums[0]; 
        
        for (int i = 1; i < nums.length; i++) {
            // we should use tmp[max-1] to compare, because it the last element inserted in tmp
            if (nums[i] > tmp[max-1]) {
                tmp[max++] = nums[i];
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
        
        int len = nums.length;
        int[] dp = new int[len];
        int res = 1;
        
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            res = Math.max(res, dp[i]);
        }
        
        return res;
    }
}
