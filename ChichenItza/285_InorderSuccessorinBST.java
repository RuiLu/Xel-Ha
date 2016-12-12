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
     *  Idea -> Find the first node whose value is bigger than p's value.
     *          Then search this node's left subtree.
     *  Time complexity -> O(h)
     *  Space complextity -> O(1)
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        while (root != null && root.val <= p.val) root = root.right;
        if (root == null) return null;
        TreeNode left = inorderSuccessor(root.left, p);
        return left == null ? root : left;
    }
    
    /**
     *  * Idea -> Iterative way, this method can apply to all kinds of binary tree
     *  Time complexity -> O(n)
     *  Space complexity -> O(h), where h is the maximal height of tree
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        if (root == null || p == null) return null;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            TreeNode next = null;
            if (curr.right != null) next = curr.right;
            while (next != null) {
                stack.push(next);
                next = next.left;
            }
            if (curr == p) return stack.isEmpty() ? null : stack.peek();
        }
        
        return null;
    }
}
