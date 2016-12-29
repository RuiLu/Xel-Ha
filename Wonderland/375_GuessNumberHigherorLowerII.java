/*
 * Given any n, we guess k. Then we can break the interval [1, n] into [1, k-1] and [k+1, n], then the min of
 * worst case cost can be calculated as cost[1,n] = k + max{cost[1,k-1], cost[k+1,n]}.
 * ???
 */

public class Solution {
    
    // 1. 
    public int getMoneyAmount(int n) {
        int[][] table = new int[n+1][n+1];
        return dp(table, 1, n);
    }
    
    private int dp(int[][] table, int start, int end) {
        if (start >= end) return 0;
        if (table[start][end] != 0) return table[start][end];
        int res = Integer.MAX_VALUE;
        for (int k = start; k <= end; k++) {
            int tmp = k + Math.max(dp(table, start, k-1), dp(table, k+1, end));
            res = Math.min(res, tmp);
        }
        table[start][end] = res;
        return res;
    }

    // 2. Bottom Up
    public int getMoneyAmount(int n) {
        int[][] table = new int[n+1][n+1];
        for (int end = 2; end <= n; end++) {
            for (int start = end - 1; start > 0; start--) {
                int outsideMin = Integer.MAX_VALUE;
                for (int k = start; k < end; k++) {
                    int insideMax = k + Math.max(table[start][k-1], table[k+1][end]);
                    outsideMin = Math.min(outsideMin, insideMax);
                }
                table[start][end] = outsideMin;
            }
        }
        return table[1][n];
    }

}
