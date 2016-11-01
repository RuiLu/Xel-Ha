/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     *  Idea -> Maintain a HashMap, key is child and value is its parent, stop when two nodes are found
     *          Create a set to store all p's ancestors.
     *          Retrieve q's ancestor one by one to see if p and q share the same ancestor
     *  Time complexity -> O(n) (worst case)
     *  Space complexity -> O(h)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        map.put(root, null);
        queue.offer(root);
        
        while (!map.containsKey(p) || !map.containsKey(q)) {
            TreeNode node = queue.poll();
            
            if (node.left != null) {
                map.put(node.left, node);
                queue.offer(node.left);
            }
            if (node.right != null) {
                map.put(node.right, node);
                queue.offer(node.right);
            }
        }
        
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = map.get(p);
        }
        
        while (!ancestors.contains(q)) {
            q = map.get(q);
        }
        
        return q;
    }
}
