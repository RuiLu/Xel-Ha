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
     *  BFS
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        
        // queue is used to store the original UndirectedGraphNode for BFS
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        // map is used to store the cloned UndirectedGraphNode
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        
        queue.offer(node);
        map.put(root.label, root);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.poll();
            
            for (UndirectedGraphNode neighbor : curr.neighbors) {
                // if map doesn't contain a UndirectedGraphNode's lable, means that we haven't access this UndirectedGraphNode before
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
