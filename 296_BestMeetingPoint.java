public class Solution {
    /**
     *  Idea -> As long as you have different numbers of people on your left and on your right, moving a little to the side          with more people decreases the sum of distances. So to minimize it, you must have equally many people on your        left and on your right. Same with above/below.
     *
     *  Reference -> https://discuss.leetcode.com/topic/27722/o-mn-java-2ms
     *  Hint -> Solve it in one dimension first.
     *  Time complexity -> O(mn)
     *  Space complexity -> O(m*n)
     */
    public int minTotalDistance(int[][] grid) {
        if (grid == null ||  grid.length == 0 || grid[0].length == 0) return 0;
        
        int row = grid.length, col = grid[0].length;
        int total = 0;
        int[] helper = new int[row * col];
        
        for (int times = 0; times < 2; times++) {
            int start = 0, count = 0;
            if (times == 0) {
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        if (grid[i][j] == 1) helper[count++] = i;
                    }
                }
            } else {
                for (int j = 0; j < col; j++) {
                    for (int i = 0; i < row; i++) {
                        if (grid[i][j] == 1) helper[count++] = j;
                    }
                }
            }
            
            count--;
            while (start < count) total += helper[count--] - helper[start++];
        }
        
        return total;
    }
    
    /**
     *  Count how many people live in each row and col
     *  Time complexity -> O(mn)
     *  Space complexity -> O(m + n)
     */
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int row = grid.length, col = grid[0].length;
        int[] rowCount = new int[row];
        int[] colCount = new int[col];
        int total = 0;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        
        for (int[] tmp : new int[][]{rowCount, colCount}) {
            int i = 0, j = tmp.length - 1;
            while (i < j) {
                int min = Math.min(tmp[i], tmp[j]);
                total += min * (j - i);
                if ((tmp[i] -= min) == 0) i++;
                if ((tmp[j] -= min) == 0) j--;
            }
        }
        
        return total;
    }
}
