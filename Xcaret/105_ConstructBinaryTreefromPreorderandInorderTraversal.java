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
     *  Divide and Conquer
     *  Idea -> 1. find the root from preorder array (always the next).
     *          2. find the index of the corresponding node in inorder array
     *          3. then we get the nodes from left-subtree and right-subtree
     *          4. do it all over again until we get to leaves
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0);
    }
    
    private TreeNode buildTree(int[] preorder, int[] inorder, int start, int end, int preIdx) {
        if (start > end) return null;
        
        TreeNode root = new TreeNode(preorder[preIdx]);
        int inorderIdx = findInorderIdx(inorder, preorder[preIdx], start, end);
        int leftSubTreeSize = inorderIdx - start;
        root.left = buildTree(preorder, inorder, start, inorderIdx - 1, preIdx + 1);
        root.right = buildTree(preorder, inorder, inorderIdx + 1, end, preIdx + leftSubTreeSize + 1);
        
        return root;
    }
    
    private int findInorderIdx(int[] inorder, int key, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == key) return i;
        }
        return -1;
    }
}
