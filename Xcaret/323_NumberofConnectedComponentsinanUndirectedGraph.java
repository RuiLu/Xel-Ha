public class Solution {
    /**
     *  Idea -> Union find
     *  Time complexity -> O(n + klogn)
     */
    private int find(int[] roots, int id) {
        if (roots[id] == id) return id;
        return find(roots, roots[id]);
    }
     
    public int countComponents(int n, int[][] edges) {
        if (edges == null || edges.length == 0 || edges[0].length == 0) return n;
        
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) roots[i] = i;
        
        for (int[] edge : edges) {
            int x = find(roots, edge[0]);
            int y = find(roots, edge[1]);
            
            if (x != y) {
                roots[x] = y;
                n--;
            }
        }
        
        
        
        return n;
    }
}
