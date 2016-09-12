tion for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     *  1. Recursive + DFS
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        return helper(root, p, new boolean[]{false});
    }
    
    private TreeNode helper(TreeNode node, TreeNode target, boolean[] findTarget) {
        if (node == null) return null;
        
        TreeNode left = helper(node.left, target, findTarget);
        
        if (findTarget[0]) {
            findTarget[0] = false;
            return node;
        }
        
        if (node == target) findTarget[0] = true;
        
        TreeNode right = helper(node.right, target, findTarget);
        
        if (left != null || right != null) return left == null ? right : left;
        else return null;
    }
    
    /**
     *  2. Recursive. No need to do DFS
     *  Reference -> https://discuss.leetcode.com/topic/25076/share-my-java-recursive-solution
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root : left;
        }
    }
    
    /**
     *  3. Using While to reduce recursion
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        while (root != null && root.val <= p.val) root = root.right;
        
        if (root == null) return null;
        
        TreeNode left = inorderSuccessor(root.left, p);
        
        return left == null ? root : left;
    }
    
}
