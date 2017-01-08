public class Solution {
    /**
     *  Idea -> Union Find. Steps please see comments.
     *  Time complexity -> O(n)
     */
    public int countComponents(int n, int[][] edges) {
        if (edges == null || edges.length == 0 || edges[0].length == 0) return n;
        
        // Each connected component has the same id, so create a HashMap storing index/id pair
        int[] union = new int[n];
        Arrays.fill(union, -1);
        int unionId = 0;
        int count = n;
        
        // Check both end points of an edge, there are four possible situations
        for (int[] edge : edges) {
            int p1 = edge[0];
            int p2 = edge[1];
            // 1. Both are not in any component
            if (union[p1] == -1 && union[p2] == -1) {
                union[p1] = unionId;
                union[p2] = unionId;
                unionId++;
                count--;
            } else if (union[p1] != -1 && union[p2] != -1) {
                int id1 = union[p1];
                int id2 = union[p2];
                
                // 2. Both are in the same component
                // 3. One in a component, while the other in another component
                if (id1 == id2) continue;   
                else {                      
                    // Move every index in component id2 to component id2
                    for (int i = 0; i < n; i++) {
                        if (union[i] == id2) union[i] = id1;
                    }
                    count--;
                }
            } else {
                // 4. One has a component, while the other doesn't belong to any component
                if (union[p1] != -1) union[p2] = union[p1];
                else if (union[p2] != -1) union[p1] = union[p2];
                count--;
            }
        }
        
        return count;
    }
}
