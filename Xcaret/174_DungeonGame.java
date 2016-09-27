public class Solution {
    /**
     *  Dynamic Programming from bottom-right
     *  Time complexity -> O(mn)
     */ 
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] hp = new int[row][col];
        
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i == row - 1 && j == col - 1) {
                    hp[i][j] = Math.max(1 - dungeon[i][j], 1);
                } else if (i == row - 1) {
                    hp[i][j] = Math.max(hp[i][j+1] - dungeon[i][j], 1);
                } else if (j == col - 1) {
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
