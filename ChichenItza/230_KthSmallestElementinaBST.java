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
     *  Idea -> Binary Search (most preferable)
     *          First, count total number of left subtree nodes (O(h))
     *          If count is bigger than k, go into the left subtree, otherwise go into the right subtree.
     *          Do it recursivly until count == k
     *  Time complexity -> O(h)
     *  Space complexity -> O(1)
     */
    public int kthSmallest(TreeNode root, int k) {
        int count = 1 + getCount(root.left);
        if (k == count) return root.val;
        else if (count > k) return kthSmallest(root.left, k);
        else return kthSmallest(root.right, k - count);
    }
    
    private int getCount(TreeNode node) {
        if (node == null) return 0;
        return 1 + getCount(node.left) + getCount(node.right);
    }
    
    /**
     *  Idea -> Inorder traverse. 1. Recursion
     *          Recursion need global variables to keep track of status.
     *          Otherwise, we should pass a reference-type variable to keep track of status.
     *  Time complexity -> O(k)
     */
    private static int res = 0;
    private static int count = 0;
     
    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k <= 0) return 0;
        count = k;
        dfsHelper(root);
        return res;
    }
    
    private void dfsHelper(TreeNode node) {
        if (node == null) return;
        dfsHelper(node.left);
        if (--count == 0) {
            res = node.val;
            return;
        }
        dfsHelper(node.right);
    }
    
    /**
     *  Idea -> Inorder traverse. 2. Iteration
     *          Use a stack.
     *  Time complexity -> O(k)
     *  Space complexity -> O(h), where h is the height of tree
     */
    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k <= 0) return 0;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (--k == 0) return node.val;
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        
        return 0;
    }
}
