public class Solution {
    /**
     *  First -> Reference -> https://discuss.leetcode.com/topic/49456/c-solution-with-explanations/2
     *  Time complexity -> O(n^2)
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        
        Arrays.sort(nums);
        int len = nums.length;
        int[] dp = new int[len];
        int[] parent = new int[len];
        int max = 0;
        int index = 0;
        
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (nums[j] % nums[i] == 0 && dp[i] < 1 + dp[j]) {
                    dp[i] = 1 + dp[j];
                    parent[i] = j;
                    
                    if (dp[i] > max) {
                        max = dp[i];
                        index = i;
                    }
                }
            }
        }
        
        for (int i = 0; i < max; i++) {
            res.add(nums[index]);
            index = parent[index];
        }
        
        return res;
    }
}
