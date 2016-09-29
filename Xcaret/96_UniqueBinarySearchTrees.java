public class Solution {
    /**
     *  Dynamic Programming
     *  Idea: To build a tree, we need to pick up a root, then need to know how many left sub trees and right sub trees,
     *        then multiply them to get total possible results
     *        For example, we want to build tree from [1,2,3,4,5]. When we pick 1 as root, left sub tree is none, right 
     *        sub tree consists of [2,3,4,5], which has the same result as [1,2,3,4], so the total number of trees that 
     *        pick 1 as root is dp[0]*dp[4]. When picking 2, we can get dp[1]*dp[3], so on and so forth. Finally, we sum
     *        them up to get the answer.
     *  Reference -> https://discuss.leetcode.com/topic/37310/fantastic-clean-java-dp-solution-with-detail-explaination
     *  Time complexity -> O(n^2)
     */
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int level = 2; level <= n; level++) {
            for (int j = 1; j <= level; j++) {
                dp[level] += dp[j-1] * dp[level-j];
            }
        }
        
        return dp[n];
    }
}
