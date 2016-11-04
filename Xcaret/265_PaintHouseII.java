public class Solution {
    /**
     *  Idea -> Find the smallest cost and second smallest cost for each house and record their id
     *          Then add second smallest cost to the house who has the smallest cost,
     *          Add smallest cost to other houses
     *  Time complexity -> O(n*3k) = O(nk)
     *  Space complexity -> O(1)
     */
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        
        int len = costs.length;
        int k = costs[0].length;
        
        for (int i = 1; i < len; i++) {
            /* find the smallest and second smallest costs for house i */
            int i1 = -1;
            int i2 = -1;
            int s1 = Integer.MAX_VALUE;
            int s2 = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                if (costs[i-1][j] < s1) {
                    s1 = costs[i-1][j];
                    i1 = j;
                }
            }
            for (int j = 0; j < k; j++) {
                if (j == i1) continue;
                if (costs[i-1][j] < s2) {
                    s2 = costs[i-1][j];
                    i2 = j;
                }
            }
            
            for (int j = 0; j < k; j++) {
                if (j == i1) costs[i][j] += s2;
                else costs[i][j] += s1;
            }
        }
        
        int minCost = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            minCost = Math.min(minCost, costs[len-1][j]);
        }
        
        return minCost;
    }
}
