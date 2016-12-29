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
     *  1. Naive way.
     *  Iteration, find leaves -> detach -> find leaves -> detach -> .. -> only root left
     */
    // public List<List<Integer>> findLeaves(TreeNode root) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     if (root == null) return res;
        
    //     while (root.left != null || root.right != null) {
    //         List<Integer> tmp = new ArrayList<>();
            
    //         TreeNode iter = root;
    //         helper(tmp, iter);
            
    //         res.add(tmp);
    //     }
        
    //     List<Integer> tmp = new ArrayList<>();
    //     tmp.add(root.val);
    //     res.add(tmp);
        
    //     return res;
    // }
    
    // private boolean helper(List<Integer> tmp, TreeNode iter) {
    //     if (iter.left == null && iter.right == null) {
    //         tmp.add(iter.val);
    //         return true;
    //     }
        
    //     if (iter.left != null && helper(tmp, iter.left)) iter.left = null;
    //     if (iter.right != null && helper(tmp, iter.right)) iter.right = null;
        
    //     return false;
    // }
    
    /**
     *  2. Recursion
     *  Calculate height for each node, bottom-up
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        height(res, root);
        return res;
    }
    
    private int height(List<List<Integer>> res, TreeNode node) {
        if (node == null) return -1;
        int height = 1 + Math.max(height(res, node.left), height(res, node.right));
        if (res.size() < height + 1) res.add(new ArrayList<>());
        res.get(height).add(node.val);
        return height;
    }
}
