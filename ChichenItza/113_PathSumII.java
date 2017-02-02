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
     * Idea -> DFS + backtracking
     * Time complexity -> O(n)
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> tmp = new ArrayList<>();
        dfs(res, tmp, root, sum, 0);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> tmp, TreeNode node, int sum, int eval) {
        if (node == null) {
            return;
        }
        
        tmp.add(node.val);
        eval += node.val;
        
        if (eval == sum && node.left == null && node.right == null) {
            res.add(new ArrayList<>(tmp));
        }
        
        dfs(res, tmp, node.left, sum, eval);
        dfs(res, tmp, node.right, sum, eval);
        tmp.remove(tmp.size()-1);
    }
}
