public class Solution {
    /**
     *  Idea -> Binary Search
     *  Reference -> Reference -> https://discuss.leetcode.com/topic/29006/c-java-python-binary-search-solution-with-explanation
     *  Time complexity -> O(mlogn + nlogm)
     */

    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0) return 0;
        
        int row = image.length;
        int col = image[0].length;
        
        int left = searchCols(0, y, 0, row, image, true);
        int right = searchCols(y + 1, col, 0, row, image, false);
        int up = searchRows(0, x, left, right, image, true);
        int down = searchRows(x + 1, row, left, right, image, false);
        
        return (right - left) * (down - up);
    }
    
    private int searchCols(int i, int j, int top, int bottom, char[][] image, boolean isLeft) {
        while (i != j) {
            int mid = (i + j) / 2;
            int k = top;
            
            while (k < bottom && image[k][mid] != '1') k++;
            
            if ((k < bottom) == isLeft) j = mid;
            else i = mid + 1;
        }
        return i;
    }
    
    private int searchRows(int i, int j, int left, int right, char[][] image, boolean isUp) {
        while (i != j) {
            int mid = (i + j) / 2;
            int k = left;
            
            while (k < right && image[mid][k] != '1') k++;
            
            if ((k < right) == isUp) j = mid;
            else i = mid + 1;
        }
        return i;
    }
    
    /**
     *  Failed -> Time Limit Exceeded
     *  Idea -> Use BFS to retrieve all '1' elements, and get the up, down, left, right boundaries
     *  Time complexity -> O(mn)
     */
    // public int minArea(char[][] image, int x, int y) {
    //     if (image == null || image.length == 0 || image[0].length == 0) return 0;
        
    //     int up = Integer.MAX_VALUE;
    //     int down = Integer.MIN_VALUE;
    //     int left = Integer.MAX_VALUE;
    //     int right = Integer.MIN_VALUE;
    //     int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
    //     int row = image.length;
    //     int col = image[0].length;
    //     boolean[][] visited = new boolean[row][col];
    //     Queue<int[]> queue = new LinkedList<>();    /* for bfs */
    //     queue.offer(new int[]{x, y});
        
    //     while (!queue.isEmpty()) {
    //         int[] curr = queue.poll();
    //         visited[curr[0]][curr[1]] = true;
    //         up = Math.min(up, curr[0]);
    //         down = Math.max(down, curr[0]);
    //         left = Math.min(left, curr[1]);
    //         right = Math.max(right, curr[1]);
            
    //         for (int[] dir : dirs) {
    //             int i = curr[0] + dir[0];
    //             int j = curr[1] + dir[1];
                
    //             if (i >= 0 && j >= 0 && i < row && j < col && image[i][j] == '1' && !visited[i][j]) {
    //                 queue.offer(new int[]{i, j});
    //             }
    //         }
    //     }
        
    //     return (down - up + 1) * (right - left + 1);
    // }
}
