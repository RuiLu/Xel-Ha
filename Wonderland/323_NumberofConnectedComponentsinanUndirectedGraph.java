public class Solution {
    /**
     *  Union find
     *  Time complexity -> O(n + klogn), where k is the length of edges
     */
    public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) roots[i] = i;
        
        for (int[] edge : edges) {
            int root1 = find(edge[0], roots);
            int root2 = find(edge[1], roots);
            
            if (root1 != root2) {
                roots[root1] = root2;
                n--;
            }
        }
        
        return n;
    }
    
    private int find(int id, int[] roots) {
        while (roots[id] != id) id = roots[id];
        return id;
    }
    
    
    /**
     *  BFS
     *  Time complexity -> O(max(n, len(edges))). 
     */
    // public int countComponents(int n, int[][] edges) {
    //     if (n <= 1) return n;
        
    //     List<List<Integer>> lists = new ArrayList<>();
    //     boolean[] visited = new boolean[n];
    //     int res = 0;
        
    //     for (int i = 0; i < n; i++) lists.add(new ArrayList<>());
        
    //     for (int i = 0; i < edges.length; i++) {
    //         lists.get(edges[i][0]).add(edges[i][1]);
    //         lists.get(edges[i][1]).add(edges[i][0]);
    //     }
        
    //     for (int i = 0; i < n; i++) {
    //         if (visited[i]) continue;
    //         res++;
    //         Queue<Integer> queue = new LinkedList<>();
    //         queue.offer(i);
    //         while (!queue.isEmpty()) {
    //             int curr = queue.poll();
    //             visited[curr] = true;
    //             for (int next : lists.get(curr)) {
    //                 if (!visited[next]) queue.offer(next);
    //             }
    //         }
    //     }
        
    //     return res;
    // }
}
