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
        
        queue.offer(root);
        map.put(root, null);
        
        /* We first use BFS to create child-parent map containing both p and q */
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
        
        /* Then we store all p's ancenstors into Set */
        Set<TreeNode> pAncestors = new HashSet<>();
        while (p != null) {
            pAncestors.add(p);
            p = map.get(p);
        }
        
        /* Finally, we retrieve q's ancestors to find the common ancestor */
        while (q != null) {
            if (pAncestors.contains(q)) break;
            q = map.get(q);
        }
        
        return q;
    }
}
