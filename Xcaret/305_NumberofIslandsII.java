public class Solution {
    /**
     *  Idea -> Union find
     *  Time complexity -> O(4klogmn) ~ O(klogmn)
     */
    private int[][] dirs = new int[][]{{1, 0}, {-1, 0},{0, 1},{0, -1}};
     
    private int find(int[] roots, int id) {
        if (roots[id] == id) return id;
        return find(roots, roots[id]);
    } 
     
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (m <= 0 || n <= 0) return res;
        
        int[] roots = new int[m*n];
        Arrays.fill(roots, -1);
        
        int count = 0;
        
        for (int[] pos : positions) {
            int root = pos[0] * n + pos[1];
            roots[root] = root; /* first assume that the new island is isolated */
            count++;
            
            for (int[] dir : dirs) {
                int x = pos[0] + dir[0];
                int y = pos[1] + dir[1];
                int nb = x * n + y;
                
                if (x < 0 || y < 0 || x >= m || y >= n || roots[nb] == -1) continue;
                
                int rootNb = find(roots, nb);
                if (rootNb != root) {   /* if neighbor belongs to another island */
                    roots[root] = rootNb;   /* add current island to neighbor island */
                    root = rootNb;  /* set root of current island to the root of neighbor island */
                    count--;
                }
            }
            
            res.add(count);
        }
        
        return res;
    }
    
}
