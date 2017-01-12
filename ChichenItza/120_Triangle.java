public class Solution {
    /**
     *  Idea -> Dynamic programming
     *  Time complexity -> O(n^2)
     *  Space complexity -> O(n)
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        
        int height = triangle.size();
        int[] dp = new int[height];
        int minSum = Integer.MAX_VALUE;
        
        for (int i = 0; i < height; i++) {
            // each time we will update the value of dp[i], but we need the value before being updated
            // so i use prevValue here to record the original value of dp[i]
            int prevValue = 0;
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int tmp = dp[j];
                if (j == 0) {
                    dp[j] += triangle.get(i).get(j);
                } else if (j == triangle.get(i).size()-1) {
                    dp[j] = prevValue+triangle.get(i).get(j);
                } else {
                    dp[j] = Math.min(dp[j], prevValue)+triangle.get(i).get(j);
                }
                prevValue = tmp;
            }
        }
        
        for (int sum : dp) minSum = Math.min(minSum, sum);
        
        return minSum;
    }
}
