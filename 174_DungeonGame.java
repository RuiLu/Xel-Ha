public class Solution {
    /**
     *  Start from the bottom-right corner.
     *  Time complexity -> O(mn)
     */
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
        
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] health = new int[m][n];
        
        health[m-1][n-1] = Math.max(1 - dungeon[m-1][n-1], 1);
        
        // First -> calculate last column, because in the last column, K can only walk downwards
        for (int i = m - 2; i >= 0; i--) {
            health[i][n-1] = Math.max(health[i+1][n-1] - dungeon[i][n-1], 1);
        }
        
        // Second -> calculate last row, because in the last row, K can only walk rightwards
        for (int j = n - 2; j >= 0; j--) {
            health[m-1][j] = Math.max(health[m-1][j+1] - dungeon[m-1][j], 1);
        }
        
        // Third -> calculate other dungeons
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int down = Math.max(health[i+1][j] - dungeon[i][j], 1);
                int right = Math.max(health[i][j+1] - dungeon[i][j], 1);
                health[i][j] = Math.min(down, right);
            }
        }
        
        return health[0][0];
    }
}
