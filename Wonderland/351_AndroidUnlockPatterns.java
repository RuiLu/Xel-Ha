public class Solution {
    /**
     *  1. Backtracking
     *  Reference -> http://www.cnblogs.com/grandyang/p/5541012.html
     */
     
    public int numberOfPatterns(int m, int n) {
        if (m > n) return 0;
        
        boolean[] visited = new boolean[10];
        int[][] jump = new int[10][10];
        jump[1][3] = jump[3][1] = 2;
        jump[4][6] = jump[6][4] = 5;
        jump[7][9] = jump[9][7] = 8;
        jump[1][7] = jump[7][1] = 4;
        jump[2][8] = jump[8][2] = 5;
        jump[3][9] = jump[9][3] = 6;
        jump[1][9] = jump[9][1] = jump[3][7] = jump[7][3] = 5;
        
        int res = 0;
        
        res += dfs(jump, visited, 1, 1, 0, m, n) * 4;   // 1, 3, 7, 9 -> same pattern
        res += dfs(jump, visited, 2, 1, 0, m, n) * 4;   // 2, 4, 6, 8 -> same pattern
        res += dfs(jump, visited, 5, 1, 0, m, n) * 1;   // 5 -> unique pattern
        
        return res;
    }
    
    private int dfs(int[][] jump, boolean[] visited, int num, int len, int res, int m, int n) {
        if (len > n) return res;
        if (len >= m && len <= n) res++;
        
        visited[num] = true;
        
        for (int next = 1; next <= 9; next++) {
            int jumpNext = jump[num][next];
            if (!visited[next] && (jumpNext == 0 || visited[jumpNext])) {
                res = dfs(jump, visited, next, len + 1, res, m, n);
            }
        }
        
        visited[num] = false;
        return res;
    }
}
