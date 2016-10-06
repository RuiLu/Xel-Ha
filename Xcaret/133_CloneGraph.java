/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     *  DFS
     */
    private Map<Integer, UndirectedGraphNode> map = new HashMap<>();
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return dfs(node);
    }
    
    private UndirectedGraphNode dfs(UndirectedGraphNode node) {
        if (node == null) return null;
        if (map.containsKey(node.label)) return map.get(node.label);
        
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(node.label, root);
        
        for (UndirectedGraphNode neighbor : node.neighbors) {
            root.neighbors.add(dfs(neighbor));
        }
        
        return root;
    }
    
    /**
     *  BFS
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(root.label, root);
        queue.offer(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.poll();
            
            for (UndirectedGraphNode neighbor : curr.neighbors) {
                if (!map.containsKey(neighbor.label)) {
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    queue.offer(neighbor);
                }
                map.get(curr.label).neighbors.add(map.get(neighbor.label));
            }
        }
        
        return root;
    }
}
