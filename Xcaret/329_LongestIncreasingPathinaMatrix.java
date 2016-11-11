public class Solution {
    /**
     *  Idea -> DFS + Map.
     *          Use DFS to retrieve all possible routes, 
     *          and use Map to record the longest increasing path starting in each position
     *  Time complexity -> O(m^2n^2) in worst case
     */
    private int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; 
     
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int row = matrix.length;
        int col = matrix[0].length;
        int longest = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int id = i * col + j;
                if (map.containsKey(id)) longest = Math.max(longest, map.get(id));
                else longest = Math.max(longest, dfs(Integer.MIN_VALUE, id, matrix, new boolean[row*col], map));
                
            }
        }
        
        return longest;
    }
    
    private int dfs(int prev, int id, int[][] matrix, boolean[] visited, Map<Integer, Integer> map) {
        if (map.containsKey(id)) return map.get(id);
        
        int i = id / matrix[0].length;
        int j = id % matrix[0].length;
    
        if (visited[id]) return 0;
    
        visited[id] = true;
        int curr = matrix[i][j];
        int len = 1;
        
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            int nextId = x * matrix[0].length + y;
            
            if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) continue;
            if (curr < matrix[x][y]) len = Math.max(len, dfs(curr, nextId, matrix, visited, map) + 1);
        }
    
        visited[id] = false;
        map.put(id, len);
        return len;
    }
}
