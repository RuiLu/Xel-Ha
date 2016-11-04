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
     *  Idea -> DFS + Backtracking
     *          DFS to retrieve all possible paths
     *  Time complexity -> O(n)
     *  Space complexity -> O(h)
     */
    private static void dfs(TreeNode node, List<String> res, List<Integer> tmp) {
        if (node == null) return;
        
        tmp.add(node.val);
        
        dfs(node.left, res, tmp);
        dfs(node.right, res, tmp);
        
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tmp.size(); i++) {
                sb.append(i == tmp.size() - 1 ? tmp.get(i) : tmp.get(i) + "->");
            }
            res.add(sb.toString());
        }
        
        tmp.remove(tmp.size() - 1);
    } 
     
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> tmp = new ArrayList<>();
        dfs(root, res, tmp);
        return res;
    }
}
