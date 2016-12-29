public class Solution {
    
    // First method: Time complexity is O(n^2), obviously
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length, col = matrix[0].length;
        int[][] areas = new int[row][col];
        // 1. calculate the area of each rectangle from (0,0) to (i,j)
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int area = matrix[i][j];
                if ((i-1) >= 0) area += areas[i-1][j];
                if ((j-1) >= 0) area += areas[i][j-1];
                if ((i-1) >= 0 && (j-1) >= 0) area -= areas[i-1][j-1];
                areas[i][j] = area;
            }
        }
        // 2. calculate every possible rectangle in this matrix, from (r1, c1) to (r2, c2)
        int maxArea = Integer.MIN_VALUE;
        for (int r1 = 0; r1 < row; r1++) {
            for (int c1 = 0; c1 < col; c1++) {
                for (int r2 = r1; r2 < row; r2++) {
                    for (int c2 = c1; c2 < col; c2++) {
                        int area = areas[r2][c2];
                        if ((r1-1) >= 0) area -= areas[r1-1][c2];
                        if ((c1-1) >= 0) area -= areas[r2][c1-1];
                        if ((r1-1) >= 0 && (c1-1) >= 0) area += areas[r1-1][c1-1];
                        if (area <= k) {
                            maxArea = Math.max(maxArea, area);
                        }
                    }
                }
            }
        }
        return maxArea;
    }
    
    /*
     * Second method: Time complexity is O(n^3logn), because we use TreeSet here
     *                We can use the same reason to find the sum of a subarray, which is sum <= k
     * But this one facing TLE, I don't know why
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length, col = matrix[0].length;
        int[][] areas = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int area = matrix[i][j];
                if ((i-1) >= 0) area += areas[i-1][j];
                if ((j-1) >= 0) area += areas[i][j-1];
                if ((i-1) >= 0 && (j-1) >= 0) area -= areas[i-1][j-1];
                areas[i][j] = area;
            }
        }
        int maxArea = Integer.MIN_VALUE;
        for (int r1 = 0; r1 < row; r1++) {
            for (int r2 = r1; r2 < row; r2++) {
                TreeSet<Integer> ts = new TreeSet<Integer>();
                ts.add(0);
                for (int c = 0; c < col; c++) {
                    int area = areas[r2][c];
                    if ((r1-1) >= 0) area -= areas[r1-1][c];
                    // should define it as Integer
                    Integer ceiling = ts.ceiling(area - k);
                    if (ceiling != null) {
                        maxArea = Math.max(maxArea, area - ceiling);
                    }
                    ts.add(area);
                }
            }
        }
        return maxArea;
    } 
    
}
