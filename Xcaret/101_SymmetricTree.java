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
     *  DFS
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }
    
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
    
    /**
     *  DFS. Preorder traverse tree from left to right first, create a sequence, then test from right to left
     *  Time complexity -> O(2n)
     *  Space complexity -> O(n)
     */
    // public boolean isSymmetric(TreeNode root) {
    //     if (root == null) return true;
        
    //     List<Integer> left = new ArrayList<>();
    //     List<Integer> right = new ArrayList<>();
        
    //     dfs(root, left, true);
    //     dfs(root, right, false);
        
    //     if (left.size() != right.size()) return false;
    //     else {
    //         for (int i = 0; i < left.size(); i++) {
    //             if (left.get(i) != right.get(i)) return false;
    //         }
    //         return true;
    //     }
    // }
    
    // private void dfs(TreeNode node, List<Integer> list, boolean left) {
    //     if (node == null) {
    //         list.add(null);
    //         return;
    //     }
        
    //     list.add(node.val);
    //     if (left) {
    //         dfs(node.left, list, true);
    //         dfs(node.right, list, true);
    //     } else {
    //         dfs(node.right, list, false);
    //         dfs(node.left, list, false);
    //     }
    // }
}
