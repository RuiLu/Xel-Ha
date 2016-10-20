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
     *  Idea -> Binary Search, using the property of complete binary tree
     */
    private int countLastLevel(TreeNode node, int height) {
        if (height == 1) {
            if (node.right != null) return 2;
            else if (node.left != null) return 1;
            else return 0;
        }
        
        TreeNode mid = node.left;
        int currHeight = 1;
        
        while (currHeight < height) {
            currHeight++;
            mid = mid.right;
        }
        
        if (mid == null) return countLastLevel(node.left, height - 1);
        else return (1 << (height - 1)) + countLastLevel(node.right, height - 1);
    }
 
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return 1;
        
        int nodeSum = 0;
        int height = 0;
        TreeNode node = root;
        
        while (node.left != null) {
            nodeSum += 1 << height;
            height++;
            node = node.left;
        }
        
        return nodeSum + countLastLevel(root, height);
    }
}
