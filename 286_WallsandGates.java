/**
 *  Starting BFS from (i, j) where rooms[i][j] == 0
 */
public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        
        int row = rooms.length;
        int col = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0) queue.offer(new int[]{i, j});
            }
        }
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0], j = curr[1];
            int dist = rooms[i][j];
            
            if (i > 0 && rooms[i-1][j] == Integer.MAX_VALUE) {
                rooms[i-1][j] = dist + 1;
                queue.offer(new int[]{i-1, j});
            }
            if (i < row - 1 && rooms[i+1][j] == Integer.MAX_VALUE) {
                rooms[i+1][j] = dist + 1;
                queue.offer(new int[]{i+1, j});
            }
            if (j > 0 && rooms[i][j-1] == Integer.MAX_VALUE) {
                rooms[i][j-1] = dist + 1;
                queue.offer(new int[]{i, j-1});
            }
            if (j < col - 1 && rooms[i][j+1] == Integer.MAX_VALUE) {
                rooms[i][j+1] = dist + 1;
                queue.offer(new int[]{i, j+1});
            }
        }    
    }
    
}
