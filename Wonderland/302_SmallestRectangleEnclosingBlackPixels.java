public class Solution {
    /**
     *  3. Binary search
     *  Reference -> https://discuss.leetcode.com/topic/29006/c-java-python-binary-search-solution-with-explanation
     *  Time complexity -> O(mlogn + nlogm)
     */
    private char[][] image;
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0) return 0;
        
        this.image = image;
        int m = image.length;
        int n = image[0].length;
        
        int left = searchCols(0, y, 0, m, true);
        int right = searchCols(y + 1, n, 0, m, false);
        int top = searchRows(0, x, left, right, true);
        int bottom = searchRows(x + 1, m, left, right, false);
        
        return (right - left) * (bottom - top);
    } 
    
    private int searchCols(int i, int j, int top, int bottom, boolean isLeft) {
        while (i != j) {
            int mid = (i + j) / 2;
            int k = top;
            while (k < bottom && image[k][mid] == '0') k++;
            if ((k < bottom) == isLeft) j = mid;
            else i = mid + 1;
        }
        return i;
    }
    
    private int searchRows(int i, int j, int left, int right, boolean isTop) {
        while (i != j) {
            int mid = (i + j) / 2;
            int k = left;
            while (k < right && image[mid][k] == '0') k++;
            if ((k < right) == isTop) j = mid;
            else i = mid + 1;
        }
        return i;
    }
    
    /**
     *  2. BFS, same idea
     *  Accepted, but use a lot of time
     */
    // public int minArea(char[][] image, int x, int y) {
    //     if (image == null || image.length == 0 || image[0].length == 0) return 0;
        
    //     int minX = x, maxX = x;
    //     int minY = y, maxY = y;
        
    //     Queue<int[]> queue = new LinkedList<>();
    //     queue.offer(new int[]{x, y});
        
    //     int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    //     int m = image.length;
    //     int n = image[0].length;
    //     boolean[][] visited = new boolean[m][n];
    //     visited[x][y] = true;
        
    //     while (!queue.isEmpty()) {
    //         int[] pos = queue.poll();
            
    //         minX = Math.min(minX, pos[0]);
    //         minY = Math.min(minY, pos[1]);
    //         maxX = Math.max(maxX, pos[0]);
    //         maxY = Math.max(maxY, pos[1]);
            
    //         for (int[] dir : dirs) {
    //             int nextX = pos[0] + dir[0];
    //             int nextY = pos[1] + dir[1];
                
    //             if (nextX < 0 || nextY < 0 || nextX >= m || nextY >= n || 
    //                 visited[nextX][nextY] || image[nextX][nextY] == '0') continue;
                
    //             visited[nextX][nextY] = true;
    //             queue.offer(new int[]{nextX, nextY});
    //         }
    //     }
        
    //     return (maxX - minX + 1) * (maxY - minY + 1);
    // }
    
    /**
     *  1. DFS, find minX, minY, maxX, and maxY -> TLE
     */
    // private int minX = Integer.MAX_VALUE;
    // private int minY = Integer.MAX_VALUE;
    // private int maxX = Integer.MIN_VALUE;
    // private int maxY = Integer.MIN_VALUE;
    // private int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    
    // public int minArea(char[][] image, int x, int y) {
    //     if (image == null || image.length == 0 || image[0].length == 0) return 0;
        
    //     int m = image.length;
    //     int n = image[0].length;
    //     boolean[][] visited = new boolean[m][n];
    //     dfs(image, x, y, m, n, visited);
        
    //     return (maxX - minX + 1) * (maxY - minY + 1);
    // }
    
    // private void dfs(char[][] image, int x, int y, int m, int n, boolean[][] visited) {
    //     if (visited[x][y]) return;
        
    //     findValue(x, y);
    //     visited[x][y] = true;
        
    //     for (int[] dir : dirs) {
    //         int nextX = x + dir[0];
    //         int nextY = y + dir[1];
            
    //         if (nextX < 0 || nextY < 0 || nextX >= m || nextY >= n) continue;
            
    //         if (image[nextX][nextY] == '1') {
    //             dfs(image, nextX, nextY, m, n, visited);
    //         }
    //     }
        
    //     visited[x][y] = false;
    // }
    
    // private void findValue(int x, int y) {
    //     minX = Math.min(minX, x);
    //     minY = Math.min(minY, y);
    //     maxX = Math.max(maxX, x);
    //     maxY = Math.max(maxY, y);
    // }
}
