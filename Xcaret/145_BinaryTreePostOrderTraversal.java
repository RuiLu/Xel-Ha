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
     *  Iteration, with a stack
     *  Idea -> start from right to left, insert a value at the head of list
     *  Reference -> https://discuss.leetcode.com/topic/30632/preorder-inorder-and-postorder-iteratively-summarization
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        
        Stack<TreeNode> stack = new Stack<>();
        
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                res.add(0, root.val);
                root = root.right;
            } else {
                TreeNode node = stack.pop();
                root = node.left;
            }
        }
        
        return res;
    }
    
    /**
     *  DFS, recursion, which is trivial
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        dfs(list, root);
        return list;
    }
    
    private void dfs(List<Integer> list, TreeNode node) {
        if (node == null) return;
    
        dfs(list, node.left);
        dfs(list, node.right);
        list.add(node.val);
    }
}
