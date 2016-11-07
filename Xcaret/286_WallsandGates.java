public class Solution {
    /**
     *  Idea -> BFS
     *  Time complexity -> O(mn)
     *  Space complexity -> O(mn)
     */
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        
        int row = rooms.length;
        int col = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        
        int currLevel = queue.size();
        int nextLevel = 0;
        int depth = 0;
        
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            rooms[x][y] = depth;
            currLevel--;
            
            if (x > 0 && rooms[x-1][y] != -1 && !visited[x-1][y]) {
                queue.offer(new int[]{x - 1, y});
                nextLevel++;
                visited[x-1][y] = true;
            }
            if (y > 0 && rooms[x][y-1] != -1 && !visited[x][y-1]) {
                queue.offer(new int[]{x, y - 1});
                nextLevel++;
                visited[x][y-1] = true;
            }
            if (x < row - 1 && rooms[x+1][y] != -1 && !visited[x+1][y]) {
                queue.offer(new int[]{x + 1, y});
                nextLevel++;
                visited[x+1][y] = true;
            }
            if (y < col - 1 && rooms[x][y+1] != -1 && !visited[x][y+1]) {
                queue.offer(new int[]{x, y + 1});
                nextLevel++;
                visited[x][y+1] = true;
            }
            
            if (currLevel == 0) {
                depth++;
                currLevel = nextLevel;
                nextLevel = 0;
            }
        }
    }
}
