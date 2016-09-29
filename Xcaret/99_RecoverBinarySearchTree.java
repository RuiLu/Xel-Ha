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
     *  Inorder traverse the tree and find the mistake
     *  Time complexity -> O(n)
     */
    public void recoverTree(TreeNode root) {
        TreeNode prev = null;
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode wrongOne = null;
        TreeNode wrongTwo = null;
        
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            TreeNode node = stack.pop();
            /* find the target, the first wrong one is prev, the other one is node*/
            if (prev != null && prev.val >= node.val) {
                if (wrongOne == null) {
                    wrongOne = prev;
                }
                if (wrongOne != null) {
                    wrongTwo = node;
                }
            }
            prev = node;
            root = node.right;
        }
        
        int tmp = wrongOne.val;
        wrongOne.val = wrongTwo.val;
        wrongTwo.val = tmp;
    }
}
