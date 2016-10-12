public class Solution {
    /**
     *  Idea -> Traverse the grid, if find an island, merge all '1' in this island into '0'
     *          the merge process can be done in both DFS and BFS
     *  Time complexity -> O(mn)
     *  Space complexity -> O(1)
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    mergeDFS(grid, i, j);
                    // mergeBFS(grid, i, j);
                }
            }
        }
        
        return res;
    }
    
    // DFS
    private void mergeDFS(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != '1') {
            return;
        }
        
        grid[x][y] = '0';
        mergeDFS(grid, x + 1, y);
        mergeDFS(grid, x - 1, y);
        mergeDFS(grid, x, y + 1);
        mergeDFS(grid, x, y - 1);
    }
    
    // BFS
    private void mergeBFS(char[][] grid, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        grid[x][y] = '0';
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0];
            int j = curr[1];
            
            
            if (i - 1 >= 0 && grid[i-1][j] == '1') {
                queue.offer(new int[]{i-1, j});
                grid[i-1][j] = '0';
            }
            if (j - 1 >= 0 && grid[i][j-1] == '1') {
                queue.offer(new int[]{i, j-1});
                grid[i][j-1] = '0';
            }
            if (i + 1 < grid.length && grid[i+1][j] == '1') {
                queue.offer(new int[]{i+1, j});
                grid[i+1][j] = '0';
            }
            if (j + 1 < grid[0].length && grid[i][j+1] == '1') {
                queue.offer(new int[]{i, j+1});
                grid[i][j+1] = '0';
            }
        }
    }
}
