public class Solution {
    
    /**
     *  1. Union find
     */
    public boolean validTree(int n, int[][] edges) {
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        
        for (int[] edge : edges) {
            int x = find(nums, edge[0]);
            int y = find(nums, edge[1]);
            
            if (x == y) return false;   // has cycle
            
            nums[x] = y;    // put x and y into one set
        }
        
        return edges.length == (n - 1);
    }
    
    private int find(int[] nums, int i) {
        if (nums[i] == -1) return i;
        return find(nums, nums[i]);
    }
    
    /**
     *  2. DFS
     */ 
    public boolean validTree(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) lists.add(new ArrayList<>());
        for (int[] edge : edges) {
            lists.get(edge[0]).add(edge[1]);
            lists.get(edge[1]).add(edge[0]);
        }
        
        // checking cycle
        if (hasCycle(-1, 0, lists, visited)) return false;
        
        // checking if it is in one piece
        for (int i = 0; i < n; i++) {
            if (!visited[i]) return false;
        }
        
        return true;
    }
    
    private boolean hasCycle(int prev, int curr, List<List<Integer>> lists, boolean[] visited) {
        visited[curr] = true;
        for (int succ : lists.get(curr)) {
            if (prev != succ) {
                if (visited[succ]) return true;
                else {
                    if (hasCycle(curr, succ, lists, visited)) return true;
                }
            }
        }
        return false;
    }
    
    /**
     *  3. BFS
     */
    public boolean validTree(int n, int[][] edges) {
        int[] visited = new int[n];
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) lists.add(new ArrayList<>());
        for (int[] edge : edges) {
            lists.get(edge[0]).add(edge[1]);
            lists.get(edge[1]).add(edge[0]);
        }
        
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = 1;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int succ : lists.get(curr)) {
                if (visited[succ] == 1) return false; // has cycle
                if (visited[succ] == 0) {
                    queue.offer(succ);
                    visited[succ] = 1;  // in checking
                }
            }
            visited[curr] = 2; // finish checking
        }
        
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) return false; // not in one piece
        }
        
        return true;
    }
}
