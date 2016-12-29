/**
 *  Starting BFS from (i, j) where rooms[i][j] == 0
 */
public class Solution {
    
    private int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0, -1}};
    
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        
        int m = rooms.length, n = rooms[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) queue.offer(new int[]{i, j});
            }
        }
        
        int level = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                for (int[] dir : dirs) {
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    
                    if (x >= m || y >= n || x < 0 || y < 0 || rooms[x][y] != Integer.MAX_VALUE) continue;
                    
                    rooms[x][y] = level;
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }
    
}
