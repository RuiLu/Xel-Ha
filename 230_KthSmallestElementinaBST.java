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
     *  First -> Best -> Binary Search
     */
    public int kthSmallest(TreeNode root, int k) {
        int nodeNumbers = count(root.left);
        
        if (nodeNumbers >= k) return kthSmallest(root.left, k);
        else if (nodeNumbers + 1 < k) return kthSmallest(root.right, k - 1 - nodeNumbers);
        
        return root.val;
    }
    
    private int count(TreeNode node) {
        if (node == null) return 0;
        return 1 + count(node.left) + count(node.right);
    }
    
    /**
     *  Second -> DFS (inorder) -> recursion
     */
    // private int res = -1;
    // private int count = 0;
    
    // public int kthSmallest(TreeNode root, int k) {
    //     dfs(root, k);
    //     return res;
    // }
    
    // private void dfs(TreeNode node, int k) {
    //     if (node == null) return;
        
    //     dfs(node.left, k);
        
    //     count++;       
    //     if (k == count) res = node.val;
        
    //     dfs(node.right, k);
    // }
    
    /**
     *  Third -> DFS (inorder) -> iteration
     */
    // public int kthSmallest(TreeNode root, int k) {
    //     Stack<TreeNode> stack = new Stack<>();
        
    //     while (root != null) {
    //         stack.push(root);
    //         root = root.left;
    //     }
        
    //     while (k != 0) {
    //         k--;
    //         TreeNode node = stack.pop();
    //         if (k == 0) return node.val;
    //         TreeNode right = node.right;
    //         while (right != null) {
    //             stack.push(right);
    //             right = right.left;
    //         }
    //     }
        
    //     return -1;
    // }
}
