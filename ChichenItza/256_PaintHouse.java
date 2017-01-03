public class Solution {
    /**
     *  Idea -> In this problem, we only have three colors, 
     *          so we can do cumulative addition for each house.
     *          For example, if we want to paint nth house with red color, we will get minimal cumulative cost by
     *          costs[n][0] += Math.min(costs[n-1][1], costs[n-1][2]).
     * 
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length != 3) return 0;
        
        int len = costs.length;
        
        for (int i = 1; i < len; i++) {
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][1], costs[i-1][0]);
        }
        
        return Math.min(costs[len-1][0], Math.min(costs[len-1][1], costs[len-1][2]));
    }
}
