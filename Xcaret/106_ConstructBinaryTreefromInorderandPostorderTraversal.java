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
     *  Almost the same method of 105, just do it in opposite way
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(postorder, inorder, postorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode buildTree(int[] postorder, int[] inorder, int postIdx, int start, int end) {
        if (start > end) return null;
        
        TreeNode root = new TreeNode(postorder[postIdx]);
        int inorderIdx = findInorderIdx(inorder, postorder[postIdx], start, end);
        int rightSubTreeSize = end - inorderIdx;
        root.right = buildTree(postorder, inorder, postIdx - 1, inorderIdx + 1, end);
        root.left = buildTree(postorder, inorder, postIdx - rightSubTreeSize - 1, start, inorderIdx - 1);
        
        return root;
    }
    
    private int findInorderIdx(int[] inorder, int key, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == key) return i;
        }
        return -1;
    }
}
