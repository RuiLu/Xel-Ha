public class Solution {
    /**
     *  Idea -> DFS
     *  Time complexity -> O(mn)
     */
    private int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        
        return res;
    }
    
    private void dfs(char[][] grid, int i, int j, int m, int n) {
        grid[i][j] = '0';
        for (int[] dir : dirs) {
            int x = i+dir[0];
            int y = j+dir[1];
            if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == '0') continue;
            dfs(grid, x, y, m, n);
        }
    }
    
    /**
     *  Idea -> Union find
     */
    private class UF {
        private int count;
        private int[] id;
        
        public UF(char[][] grid, int m, int n) {
            count = 0;
            id = new int[m*n];
            
            /* initialize count */
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') count++;
                }
            }
            
            /* initialize id[] */
            for (int i = 0; i < m*n; i++) id[i] = i;
        }
        
        public int find(int p) {
            while (p != id[p]) p = id[id[p]];
            return p;
        }
        
        public void union(int p, int q) {
            int pid = find(p);
            int qid = find(q);
            if (pid == qid) return;
            id[pid] = qid;
            count--;
        }
        
        public int getCount() {
            return count;
        }
    }
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        UF uf = new UF(grid, m, n);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    int p = i*n+j;
                    int q;
                    
                    /* current island has island neighbor(s), then union these two islands. */
                    if (i > 0 && grid[i-1][j] == '1') {
                        q = p-n;
                        uf.union(p, q);
                    }
                    if (j > 0 && grid[i][j-1] == '1') {
                        q = p-1;
                        uf.union(p, q);
                    }
                    if (i < m-1 && grid[i+1][j] == '1') {
                        q = p+n;
                        uf.union(p, q);
                    }
                    if (j < n-1 && grid[i][j+1] == '1') {
                        q = p+1;
                        uf.union(p, q);
                    }
                }
            }
        }
        
        return uf.getCount();
    }
}
