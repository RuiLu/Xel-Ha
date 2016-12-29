/**
 *  Two auxiliary matrix -> 1. distance[][], record the total distance from this position to each building
 *                          2. reachCount[][], record the number of building that can be reached from this position
 */
public class Solution {
    
    private int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        
        int m = grid.length, n = grid[0].length;
        int[][] distance = new int[m][n];
        int[][] reachCount = new int[m][n];
        int buildingCount = 0;
        
        // calculate the total number of buildings
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) buildingCount++;
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (!bfs(grid, distance, reachCount, i, j, m, n, buildingCount)) return -1;
                }
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && reachCount[i][j] == buildingCount) res = Math.min(res, distance[i][j]);
            }
        }
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    private boolean bfs(int[][] grid, int[][] distance, int[][] reachCount, int i, int j, int m, int n, int buildingCount) {
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        int level = 0;
        int count = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            
            for (int k = 0; k < size; k++) {
                int[] pos = queue.poll();
                for (int[] dir : dirs) {
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    
                    if (x >= 0 && y >= 0 && x < m && y < n && !visited[x][y]) {
                        if (grid[x][y] == 0) {
                            distance[x][y] += level;
                            reachCount[x][y]++;
                            visited[x][y] = true;
                            queue.offer(new int[]{x, y});
                        } else if (grid[x][y] == 1) {
                            count++;
                            visited[x][y] = true;
                        }
                    }
                }
            }
        }
        
        return count == buildingCount;
    }
}
