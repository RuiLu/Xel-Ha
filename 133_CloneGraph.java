/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    
    // 1. DFS
    HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return dfs(node);
    }
    
    private UndirectedGraphNode dfs(UndirectedGraphNode node) {
        if (node == null) return null;
        if (map.containsKey(node.label)) return map.get(node.label);
        
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor));
        }
        
        return clone;
    }
    
    // 2. BFS
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
        LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
        
        map.put(root.label, root);
        queue.add(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.pop();
            for (UndirectedGraphNode neighbor : curr.neighbors) {
                if (!map.containsKey(neighbor.label)) {
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    queue.add(neighbor);
                }
                map.get(curr.label).neighbors.add(map.get(neighbor.label));
            }
        }
        
        return root;
    }
    
}
