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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> tmp = new ArrayList<>();
        dfs(root, tmp, res);
        return res;
    }
    
    private static void dfs(TreeNode node, List<Integer> tmp, List<String> res) {
        if (node == null) return;
        
        tmp.add(node.val);
        
        dfs(node.left, tmp, res);
        dfs(node.right, tmp, res);
        
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tmp.size(); i++) {
                if (i == tmp.size() - 1) sb.append(tmp.get(i));
                else sb.append(tmp.get(i) + "->");
            }
            res.add(sb.toString());
        }
        
        tmp.remove(tmp.size() - 1);
    }
}
