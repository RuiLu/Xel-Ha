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
     * Idea -> Recursion, with help from ArrayList
     * Time complexity -> O(n)
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        dfs(res, root, 1);
        return res;
    }
    
    private void dfs(List<Integer> res, TreeNode node, int height) {
        if (node == null) return;
        if (res.size() < height) res.add(node.val);
        dfs(res, node.right, height+1);
        dfs(res, node.left, height+1);
    }
    }
}
