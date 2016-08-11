public class Solution {
    /**
     * 1. Merge (DFS) (faster than BFS) -> once find island, merging its surroundings to '0'
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int res = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    mergeDFS(grid, i, j);
                }
            }
        }
        
        return res;
    }
    
    private void mergeDFS(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            
            mergeDFS(grid, i + 1, j);
            mergeDFS(grid, i - 1, j);
            mergeDFS(grid, i, j + 1);
            mergeDFS(grid, i, j - 1);
        }
    }
    
    /**
     * 2. Merge (BFS) -> same thought
     */
     public int numIslands(char[][] grid) {
         if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
         
         int res = 0;
         
         for (int i = 0; i < grid.length; i++) {
             for (int j = 0; j < grid[0].length; j++) {
                 if (grid[i][j] == '1') {
                     res++;
                     mergeBFS(grid, i, j);
                 }
             }
         }
         
         return res;
     }
     
     private void mergeBFS(char[][] grid, int i, int j) {
         LinkedList<int[]> queue = new LinkedList<>();
         queue.offer(new int[]{i, j});
         grid[i][j] = '0';
         
         while (!queue.isEmpty()) {
             int[] pair = queue.poll();
             int x = pair[0], y = pair[1];
             
             if (x > 0 && grid[x - 1][y] == '1') {
                 queue.offer(new int[]{x - 1, y});
                 grid[x - 1][y] = '0';
             }
             if (x < grid.length - 1 && grid[x + 1][y] == '1') {
                 queue.offer(new int[]{x + 1, y});
                 grid[x + 1][y] = '0';
             }
             if (y > 0 && grid[x][y - 1] == '1') {
                 queue.offer(new int[]{x, y - 1});
                 grid[x][y - 1] = '0';
             }
             if (y < grid[0].length - 1 && grid[x][y + 1] == '1') {
                 queue.offer(new int[]{x, y + 1});
                 grid[x][y + 1] = '0';
             }
         }
     }
}
