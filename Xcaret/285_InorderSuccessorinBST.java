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
     *  Idea -> Binary search tree!!!!
     *  Time complexity -> O(h)
     *  Space complexity -> O(1)
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        while (root != null && root.val <= p.val) root = root.right;
        if (root == null) return null;
        TreeNode left = inorderSuccessor(root.left, p);
        return left == null ? root : left;
    }
     
    /**
     *  Idea -> Iterative search, need a stack, can be used in ANY TREE.
     *  Time complexity -> O(n)
     *  Space complexity -> O(h), where h is the height of tree
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while (root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }
        
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.right != null) {
                TreeNode next = curr.right;
                while (next != null) {
                    stack.push(next);
                    next = next.left;
                }
            }
            if (curr == p) return stack.isEmpty() ? null : stack.peek();
        }
        
        return null;
    }
}
