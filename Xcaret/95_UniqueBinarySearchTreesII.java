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
     *  Divide and Conquer
     *  Idea -> Construct trees using recursion, get all possible combinations of left sub trees and right sub trees,
     *          which are returned by their root node. Then we combine the left with right one by one.
     *  Time complexity -> O(2^n)
     */
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) return new ArrayList<>();
        return buildTrees(1, n);
    }
    
    private List<TreeNode> buildTrees(int lo, int hi) {
        List<TreeNode> res = new ArrayList<>();
        if (lo > hi) {
            res.add(null);
            return res;
        }
        
        for (int i = lo; i <= hi; i++) {
            List<TreeNode> leftRes = buildTrees(lo, i - 1);
            List<TreeNode> rightRes = buildTrees(i + 1, hi);
            
            for (TreeNode left : leftRes) {
                for (TreeNode right : rightRes) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        
        return res;
    }
}
