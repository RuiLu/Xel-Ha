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
        if (node == null) return null;
        if (map.containsKey(node.label)) return map.get(node.label);
        
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }
        
        return clone;
    }
    
    /**
     *  BFS -> We use Queue to store original nodes, and use HashMap to store cloned nodes.
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        
        queue.offer(node);
        map.put(clone.label, clone);
        
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
        
        return clone;
    }
}
