public class Solution {
    
    /**
     *  First thought -> fill first, then calculate each time, time complexity is O(kmn)
     */
     
    /**
     *  Second thought -> Union find -> time complexity -> O(klogmn)
     *  Reference -> https://discuss.leetcode.com/topic/29613/easiest-java-solution-with-explanations
     */
    private int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
     
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (m <= 0 || n <= 0) return res;
        
        int[] roots = new int[m * n];   // one island == one tree
        Arrays.fill(roots, -1);
        int count = 0;
        
        for (int[] position : positions) {
            int root = position[0] * n + position[1];
            roots[root] = root;     // assume the new point is a isolated island
            count++;
            
            for (int[] dir : dirs) {
                int x = position[0] + dir[0];
                int y = position[1] + dir[1];
                
                int nb = x * n + y;
                if (x < 0 || y < 0 || x >= m || y >= n || roots[nb] == -1) continue;
                
                int rootNb = findIsland(roots, nb);
                if (root != rootNb) {       // if neighbor is in another island
                    roots[root] = rootNb;   // add current node to the island
                    root = rootNb;          // current tree node == joint tree node
                    count--;
                }
            }
            
            res.add(count);
        }
        
        return res;
    }
    
    private int findIsland(int[] roots, int id) {
        while (id != roots[id]) id = roots[id];
        return id;
    }
}
