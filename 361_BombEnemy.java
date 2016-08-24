public class Solution {
    /**
     *  Second -> only traversal the matrix once, only when i = 0 or j = 0 or the previous element is 'W', we do the 
     *            hit calculation
     *  
     *            So the time complexity is O(mn), the space complexity is O(n)
     */
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int rowHits = 0;
        int[] colHits = new int[n];
        int res = Integer.MIN_VALUE;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'W') continue;
                
                // only calculate rowHits when starting a row or there is a 'W' ahead
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rowHits = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; k++) rowHits += (grid[i][k] == 'E' ? 1 : 0);
                }
                
                // only calculate colHits[j] when starting a col or there is a 'W' above
                if (i == 0 || grid[i - 1][j] == 'W') {
                    colHits[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; k++) colHits[j] += (grid[k][j] == 'E' ? 1 : 0);
                }
                
                if (grid[i][j] == '0') res = Math.max(res, rowHits + colHits[j]);
            }
        }
        
        return res == Integer.MIN_VALUE ? 0 : res;
    }
    
    /**
     *  First -> traversal all elements in the matrix, and calculate the result at each position
     *  
     *  Time complexity -> O(m^2n^2)  TOO SLOW!!!!!
     */
    // public int maxKilledEnemies(char[][] grid) {
    //     if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
    //     int m = grid.length;
    //     int n = grid[0].length;
    //     int res = Integer.MIN_VALUE;
        
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             if (grid[i][j] == '0') {
    //                 // 1 -> north; 2 -> east; 3 -> south; 4 -> west
    //                 int target = dfs(grid, m, n, i, j, 1) + 
    //                              dfs(grid, m, n, i, j, 2) +
    //                              dfs(grid, m, n, i, j, 3) +
    //                              dfs(grid, m, n, i, j, 4);
    //                 res = Math.max(res, target);
    //             }
    //         }
    //     }
        
    //     return res == Integer.MIN_VALUE ? 0 : res;
    // }
    
    // private int dfs(char[][] grid, int row, int col, int i, int j, int dir) {
    //     if (i >= row || i < 0 || j >= col || j < 0 || grid[i][j] == 'W') return 0;
        
    //     int sum = 0;
    //     if (grid[i][j] == 'E') sum++;
        
    //     switch(dir) {
    //         case 1: 
    //             sum += dfs(grid, row, col, i - 1, j, dir);
    //             break;
    //         case 2: 
    //             sum += dfs(grid, row, col, i, j + 1, dir);
    //             break;
    //         case 3: 
    //             sum += dfs(grid, row, col, i + 1, j, dir);
    //             break;
    //         case 4: 
    //             sum += dfs(grid, row, col, i, j - 1, dir);
    //             break;
    //     }
        
    //     return sum;
    // }
}
