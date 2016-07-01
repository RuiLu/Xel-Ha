/*
 * The followong explanation is refered from https://github.com/lydxlx1/LeetCode/blob/master/src/_310.java, which gives me so much help.
 *
 * It is easy to see that the root of an MHT has to be the middle point (or two middle points) of the longest path of the tree.
 * Though multiple longest paths can appear in an unrooted tree, they must share the same middle point(s).
 *
 * Computing the longest path of a unrooted tree can be done, in O(n) time, by tree dp, or simply 2 tree traversals (dfs or bfs).
 * The following code does the latter.
 *
 * Randomly select a node x as the root, do a dfs/bfs to find the node y that has the longest distance from y.
 * Then y must be one of the endpoints on some longest path.
 * Let y the new root, and do another dfs/bfs. Find the node z that has the longest distance from y.
 *
 * Now, the path from y to z is the longest one, and thus its middle point(s) is the answer.
*/
public class Solution {
    
    int n;
    List<Integer>[] e;
    
    private void bfs(int start, int[] dist, int[] prev) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        dist[start] = 0;
        prev[start] = -1;
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : e[u]) {
                if (!visited[v]) {
                    dist[v] = dist[u] + 1;
                    prev[v] = u;
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }
    
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n <= 0) return new ArrayList<>();
        this.n = n;
        e = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            e[i] = new ArrayList<>();
        }
        for (int[] pair : edges) {
            int u = pair[0];
            int v = pair[1];
            e[u].add(v);
            e[v].add(u);
        }
        
        int[] d1 = new int[n];
        int[] d2 = new int[n];
        int[] prev = new int[n];
        
        bfs(0, d1, prev);
        int u = 0;
        for (int i = 0; i < n; i++) {
            if (d1[i] > d1[u]) u = i;
        }
        
        bfs(u, d2, prev);
        int v = 0;
        for (int i = 0; i < n; i++) {
            if (d2[i] > d2[v]) v = i;
        }
        
        List<Integer> list = new ArrayList<>();
        while (v != -1) {
            list.add(v);
            v = prev[v];
        }
        
        if (list.size() % 2 != 0) return Arrays.asList(list.get(list.size() / 2));
        else return Arrays.asList(list.get(list.size() / 2 - 1), list.get(list.size() / 2));
    }
    
}
