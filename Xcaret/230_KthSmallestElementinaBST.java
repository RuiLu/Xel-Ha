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
     *  Idea -> Iteration, until find the kth element in BST
     *  Time complexity -> O(max(h, k)), where h is the height of the BST
     *  Space complexity -> O(h)
     */
    public int kthSmallest(TreeNode root, int k) {
        int counter = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            counter++;
            if (counter == k) return root.val;
            root = root.right;
        }
        
        return 0;
    }
}
