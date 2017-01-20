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
     * Idea -> Maintain a HashMap, key is child and value is its parent, stop when two nodes are found.
     *         Create a HashSet for storing all p's ancestors and p itself.
     *         Starting from q, retrieve q's ancestor one by one to see if p and q share the same ancestor.
     * Time complexity -> O(n) in worst case.
     * Space complexity -> O(n)
     */ 
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode curr = queue.poll();
            if (curr.left != null) {
                parent.put(curr.left, curr);
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                parent.put(curr.right, curr);
                queue.offer(curr.right);
            }
        }
        
        Set<TreeNode> pAncestors = new HashSet<>();
        while (p != null) {
            pAncestors.add(p);
            p = parent.get(p);
        }
        
        while (q != null) {
            if (pAncestors.contains(q)) return q;
            q = parent.get(q);
        }
        
        return null;
    }
}
