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
    public List<Integer> rightSideView(TreeNode root) {
        // 1. BFS, 3ms
        // List<Integer> res = new ArrayList<>();
        // if (root == null) return res;
        
        // LinkedList<TreeNode> queue = new LinkedList<>();
        // queue.add(root);
        // int currNum = 1;
        // int nextNum = 0;
        
        // while (!queue.isEmpty()) {
        //     TreeNode node = queue.poll();
        //     currNum--;
            
        //     if (node.left != null) {
        //         queue.add(node.left);
        //         nextNum++;
        //     }
        //     if (node.right != null) {
        //         queue.add(node.right);
        //         nextNum++;
        //     }
            
        //     if (currNum == 0) {
        //         res.add(node.val);
        //         currNum = nextNum;
        //         nextNum = 0;
        //     }
        // }
        // return res;
        
        // 2. recursive, 1ms
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        
        helper(root, res, 1);
        return res;
    }
    
    public void helper(TreeNode node, List<Integer> res, int level) {
        if (node == null)
            return;
        // Only add one value at each level
        if (res.size() < level)
            res.add(node.val);
        // Does DFS at right branch
        helper(node.right, res, level + 1);
        helper(node.left, res, level + 1);
    }
}
