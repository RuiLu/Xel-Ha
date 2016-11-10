public class Solution {
    /**
     *  Idea -> Breadth-first Search
     *          Detailed explanation please see comments in code.
     *  Time complexity -> O(m^2n^2)
     *  Space complexity -> O(mn)
     */
    private int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; 
     
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int minDistance = Integer.MAX_VALUE;
        int row = grid.length;
        int col = grid[0].length;
        Set<Integer> buildings = new HashSet<>();   /* record the buildings' positions */
        Set<Integer> obstacles = new HashSet<>();   /* record the obstacles' positions */
        int[] reachCount = new int[row*col];        /* record the number of buildings that each empty space can reach */
    
        /* 1. find buildings' and obstacles' positions */
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    buildings.add(i * col + j);
                } else if (grid[i][j] == 2) {
                    obstacles.add(i * col + j);
                }
            }
        }
        
        /*  BFS for all buildings, and add levels to each empty space accumulatively. */
        /*  In the meantime, we must ensure that each building can reach out to other buildings. */
        for (int bid : buildings) {
            if (!bfs(bid, grid, buildings, obstacles, new boolean[row*col], reachCount)) return -1;
        }
        
        /* Finally, find the minimum distance among empty spaces that can reach all buildings. */
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int id = i * col + j;
                if (buildings.contains(id) || obstacles.contains(id) || reachCount[id] != buildings.size()) continue;
                minDistance = Math.min(minDistance, grid[i][j]);
            }
        }
        
        return minDistance != Integer.MAX_VALUE ? minDistance : -1;
    }
    
    private boolean bfs(int bid, int[][] grid, Set<Integer> buildings, Set<Integer> obstacles, 
                        boolean[] visited, int[] reachCount) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(bid);
        int buildingCount = 0;
        int level = 0;
        int currNum = 1;
        int nextNum = 0;
        int row = grid.length;
        int col = grid[0].length;
        
        while (!queue.isEmpty()) {
            int id = queue.poll();
            int i = id / col;
            int j = id % col;
            currNum--;
            
            grid[i][j] += level;
            
            for (int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                int nextId = x * col + y;
                
                if (x < 0 || y < 0 || x >= row || y >= col || visited[nextId] || obstacles.contains(nextId)) continue;
                if (buildings.contains(nextId)) {
                    buildingCount++;
                    visited[nextId] = true;
                    continue;
                }
                
                reachCount[nextId]++;
                queue.offer(nextId);
                visited[nextId] = true;
                nextNum++;
            }
            
            if (currNum == 0) {
                level++;
                currNum = nextNum;
                nextNum = 0;
            }
        }
        
        return buildingCount == buildings.size();
    }
}
