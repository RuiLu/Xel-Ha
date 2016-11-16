public class Solution {
    /**
     *  Idea -> Using DP
     *  Time complexity -> O(mn), where m is target, n is the length of nums
     */
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        
        Arrays.sort(nums);
        int[] dp = new int[target+1];
        
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num > i) {
                    break;
                } else if (num == i) {
                    dp[i]++;
                } else {
                    dp[i] += dp[i-num];
                }
            }
        }
        
        return dp[target];
    }
}
