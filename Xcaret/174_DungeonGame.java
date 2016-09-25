public class Solution {
    /**
     *  Dynamic Programming from bottom-right
     *  Time complexity -> O(mn)
     */ 
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
        
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] hp = new int[m][n];
        hp[m-1][n-1] = dungeon[m-1][n-1] < 0 ? 1-dungeon[m-1][n-1] : 1;
        
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (i == m-1 && j == n-1) continue;
                else if (i == m-1) {
                    hp[i][j] = Math.max(hp[i][j+1] - dungeon[i][j], 1);
                } else if (j == n-1) {
                    hp[i][j] = Math.max(hp[i+1][j] - dungeon[i][j], 1);
                } else {
                    int down = Math.max(hp[i+1][j] - dungeon[i][j], 1);
                    int right = Math.max(hp[i][j+1] - dungeon[i][j], 1);
                    hp[i][j] = Math.min(down, right);
                }
            }
        }
        
        return hp[0][0];
    }
}
