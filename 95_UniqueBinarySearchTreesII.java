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
    
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        return helper(1, n);
    }
    
    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        
        if (start > end) {
            res.add(null);
            return res;
        }
        
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftRes = helper(start, i-1);
            List<TreeNode> rightRes = helper(i+1, end);
            for (TreeNode left : leftRes) {
                for (TreeNode right : rightRes) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        
        return res;
    }
    
}
