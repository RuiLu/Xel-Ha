public class Solution {
    /**
     *  Idea -> The key is to find the smallest cost and second smallest cost for each house
     *  Time complexity -> O(nk)
     *  Space complexity -> O(1)
     */
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        
        int len = costs.length;
        int firstSmallestCost;
        int secondSmallestCost;
        int firstSmallestIdx;
        
        for (int i = 1; i < len; i++) {
            firstSmallestCost = Integer.MAX_VALUE;
            secondSmallestCost = Integer.MAX_VALUE;
            firstSmallestIdx = -1;
            for (int k = 0; k < costs[0].length; k++) {
                if (costs[i-1][k] < firstSmallestCost) {
                    secondSmallestCost = firstSmallestCost;
                    firstSmallestCost = costs[i-1][k];
                    firstSmallestIdx = k;
                } else if (costs[i-1][k] < secondSmallestCost) {
                    secondSmallestCost = costs[i-1][k];
                }
            }
            for (int k = 0; k < costs[i].length; k++) {
                if (k == firstSmallestIdx) {
                    costs[i][k] += secondSmallestCost;
                } else {
                    costs[i][k] += firstSmallestCost;
                }
            }
        }
        
        firstSmallestCost = Integer.MAX_VALUE;
        for (int k = 0; k < costs[len-1].length; k++) {
            firstSmallestCost = Math.min(firstSmallestCost, costs[len-1][k]);
        }
         
        return firstSmallestCost;       
    }
}
