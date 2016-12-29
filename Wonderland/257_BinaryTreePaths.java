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
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new ArrayList<String>();
        
        List<String> res = new ArrayList<String>();
        List<String> tmp = new ArrayList<String>();
        
        dfs(root, res, tmp);
        
        return res;
    }
    
    private void dfs(TreeNode node, List<String> res, List<String> tmp) {
        if (node == null) return;
    
        tmp.add(Integer.toString(node.val));
        
        dfs(node.left, res, tmp);
        dfs(node.right, res, tmp);
        
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tmp.size(); i++) {
                if (i == (tmp.size() - 1)) {
                    sb.append(tmp.get(i));
                } else {
                    sb.append(tmp.get(i) + "->");
                }
            }
            res.add(sb.toString());        
        }
    
        tmp.remove(tmp.size() - 1);
     }
}
