public class Solution {
    /**
     *  1. O(nk^2), try to save it to O(nk) in method 2.
     */
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        
        int res = Integer.MAX_VALUE;
        int n = costs.length;
        int k = costs[0].length;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int tmp = Integer.MAX_VALUE;
                for (int x = 0; x < k; x++) {
                    if (x == j) continue;
                    tmp = Math.min(tmp, costs[i - 1][x]);
                }
                costs[i][j] += tmp;
            }
        }
        
        for (int cost : costs[n - 1]) res = Math.min(res, cost);
        return res;
    }
    
    /**
     *  2. O(nk)
     *  Track the 1st and 2nd smallest costs' indice
     *  Reference -> https://discuss.leetcode.com/topic/22580/ac-java-solution-without-extra-space
     */
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        
        int min1 = -1, min2 = -1;
        int n = costs.length;
        int k = costs[0].length;
        
        for (int i = 0; i < n; i++) {
            int last1 = min1, last2 = min2;
            min1 = -1;
            min2 = -1;
            for (int j = 0; j < k; j++) {
                if (j != last1) {
                    costs[i][j] += last1 == -1 ? 0 : costs[i - 1][last1];
                } else {
                    costs[i][j] += last2 == -1 ? 0 : costs[i - 1][last2];
                }
                
                if (min1 == -1 || costs[i][j] < costs[i][min1]) {
                    min2 = min1;
                    min1 = j;
                } else if (min2 == -1 || costs[i][j] < costs[i][min2]) {
                    min2 = j;
                }
            }
        }
        
        return costs[n - 1][min1];
    }
}
