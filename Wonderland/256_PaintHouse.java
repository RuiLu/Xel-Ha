public class Solution {
    /**
     *  2. DP -> Time complexity -> O(n), where n is the number of houses
     */
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        
        int n = costs.length;
        
        for (int i = 1; i < n; i++) {
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }
        
        return Math.min(costs[n - 1][0], Math.min(costs[n - 1][1], costs[n - 1][2]));
    }
    
    /**
     *  1. TLE -> Time Complexity -> O(3 * 2 ^ (n-1))
     */
    // public int minCost(int[][] costs) {
    //     if (costs == null || costs.length == 0) return 0;
    //     int n = costs.length;
    //     return dfs(costs, 0, n, -1);
    // }
    
    // private int dfs(int[][] costs, int index, int limit, int lastColor) {
    //     if (index == limit) return 0;
        
    //     int res = Integer.MAX_VALUE;
    //     for (int color = 0; color < 3; color++) {
    //         if (color == lastColor) continue;
    //         res = Math.min(res, costs[index][color] + dfs(costs, index + 1, limit, color));
    //     }
        
    //     return res;
    // }
}
