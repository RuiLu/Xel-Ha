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
     *  Idea -> DFS, preorder, from right to left, use the size of list to check if the current level is accessed.
     *          Therefore, no need for a Set.
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        dfs(root, list, 1);
        return list;
    }
    
    private void dfs(TreeNode node, List<Integer> list, int level) {
        if (node == null) return;
        
        if (list.size() < level) {
            list.add(node.val);
        }
        
        dfs(node.right, list, level + 1);
        dfs(node.left, list, level + 1);
    }
}
