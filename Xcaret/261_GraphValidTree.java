public class Solution {
    /**
     *  Idea -> Union find
     */
    private static int find(int[] union, int id) {
        if (union[id] == -1) return id;
        return find(union, union[id]);
    } 
     
    public boolean validTree(int n, int[][] edges) {
        int[] union = new int[n];
        Arrays.fill(union, -1);
        
        for (int[] edge : edges) {
            int x = find(union, edge[0]);
            int y = find(union, edge[1]);
            
            /* find circle */
            if (x == y) return false;
            
            union[x] = y;
        }
        
        return edges.length == (n - 1);
    }
    
    /**
     *  Idea -> DFS, find circle
     */
    private static boolean hasCircle(int prev, int curr, List<List<Integer>> lists, boolean[] visited) {
        visited[curr] = true;
        for (int next : lists.get(curr)) {
            if (next == prev) continue;
            if (visited[next]) return true;
            if (hasCircle(curr, next, lists, visited)) return true;
        }
        return false;
    }     
     
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) lists.add(new ArrayList<>());
        for (int[] edge : edges) {
            lists.get(edge[0]).add(edge[1]);
            lists.get(edge[1]).add(edge[0]);
        }
        
        /* check circle */
        boolean[] visited = new boolean[n];
        if (hasCircle(-1, 0, lists, visited)) return false;
        
        /* check if all nodes are connected */
        for (boolean visit : visited) {
            if (!visit) return false;
        }
        
        return true;
    }
    
    /**
     *  Idea -> BFS
     */
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) lists.add(new ArrayList<>());
        for (int[] edge : edges) {
            lists.get(edge[0]).add(edge[1]);
            lists.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int[] visited = new int[n];
        visited[0] = 1;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : lists.get(curr)) {
                if (visited[next] == 1) return false;
                if (visited[next] == 0) {
                    queue.offer(next);
                    visited[next] = 1;
                }
            }
            visited[curr] = 2;
        }
        
        /* check if all nodes are connected */
        for (int i : visited) {
            if (i == 0) return false;
        }
        
        return true;
    }
}
