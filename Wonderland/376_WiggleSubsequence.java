public class Solution {
    
    public int wiggleMaxLength(int[] nums) {
        
        int len = nums.length;
        
        if (len == 0) return 0;
        if (len == 1) return 1;
        
        int[] dp = new int[len + 1];
        
        int prev;
        
        if (nums[0] == nums[1]) {
            prev = 0;
            dp[1] = 1;
            dp[2] = 1;
        }
        else if (nums[0] < nums[1]) {
            prev = 1;
            dp[1] = 1;
            dp[2] = 2;
        }
        else {
            prev = -1;
            dp[1] = 1;
            dp[2] = 2;
        }
        
        for (int i = 2; i < len; i++) {
            if (nums[i] == nums[i-1]) {
                dp[i+1] = dp[i];
            } else if (nums[i] > nums[i-1]) {
                if (prev == -1 || prev == 0) {
                    dp[i+1] = dp[i] + 1;
                } else {
                    dp[i+1] = dp[i];
                }
                prev = 1;
            } else if (nums[i] < nums[i-1]) {
                if (prev == 1 || prev == 0) {
                    dp[i+1] = dp[i] + 1;
                } else {
                    dp[i+1] = dp[i];
                }
                prev = -1;
            }
        }
       
       return dp[len]; 
    }
}
