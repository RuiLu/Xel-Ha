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
     *  Idea -> Divide and conquer
     *  Time complexity -> O(2^n)
     */ 
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) return new ArrayList<TreeNode>();
        return helper(1, n);
    }
    
    private List<TreeNode> helper(int lo, int hi) {
        List<TreeNode> list = new ArrayList<>();
        if (lo > hi) {
            list.add(null);
            return list;
        }
        
        for (int i = lo; i <= hi; i++) {
            /* Get all possible roots for left subtrees */
            List<TreeNode> left = helper(lo, i-1);
            /* Get all possible roots for right subtrees */
            List<TreeNode> right = helper(i+1, hi);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    /* Combine all possibilities together */
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right =r;
                    list.add(root);
                }
            }
        }
        
        return list;
    }
}
