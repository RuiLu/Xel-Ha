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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        dfs(list, root);
        return list;
    }
    
    private void dfs(List<Integer> list, TreeNode node) {
        if (node == null) return;
        
        list.add(node.val);
        dfs(list, node.left);
        dfs(list, node.right);
    }
}
