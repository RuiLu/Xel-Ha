public class Solution {
    /**
     *  Idea -> As long as you have different numbers of people on your left and on your right, moving a little to the side
     *          with more people to decrease the sum of distance
     *          Solve it in one dimension first.
     *  Reference -> https://discuss.leetcode.com/topic/27722/o-mn-java-2ms
     *  Time complexity -> O(mn)
     *  Space complexity -> O(mn)
     */
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int row = grid.length;
        int col = grid[0].length;
        int[] tmp = new int[row*col];
        int total = 0;
        
        for (int times = 0; times < 2; times++) {
            int start = 0;
            int count = 0;
            if (times == 0) {
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        if (grid[i][j] == 1) tmp[count++] = i;
                    }
                }
            } else if (times == 1) {
                for (int j = 0; j < col; j++) {
                    for (int i = 0; i < row; i++) {
                        if (grid[i][j] == 1) tmp[count++] = j;
                    }
                }
            }
            
            count--;
            total += tmp[count--] - tmp[start++];
        }
        
        return total;
    } 
     
    /**
     *  Idea -> Naive one, brute force
     *  Time complexity -> O(mnp), where p is the number of people
     */
    // public int minTotalDistance(int[][] grid) {
    //     if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
    //     List<int[]> list = new ArrayList<>();
    //     int row = grid.length;
    //     int col = grid[0].length;
    //     int minDistance = Integer.MAX_VALUE;
        
    //     for (int i = 0; i < row; i++) {
    //         for (int j = 0; j < col; j++) {
    //             if (grid[i][j] == 1) {
    //                 list.add(new int[]{i, j});
    //             }
    //         }
    //     }
        
    //     for (int i = 0; i < row; i++) {
    //         for (int j = 0; j < col; j++) {
    //             int total = 0;
    //             for (int[] people : list) {
    //                 total += Math.abs(people[0] - i) + Math.abs(people[1] - j);
    //             }
    //             minDistance = Math.min(minDistance, total);
    //         }
    //     }
        
    //     return minDistance == Integer.MAX_VALUE ? 1 : minDistance;
    // }
}
