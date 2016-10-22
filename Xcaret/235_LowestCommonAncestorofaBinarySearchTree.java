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
     *  Idea -> Check the level until find the result TreeNode
     *  Time complexity -> O(h), where h is the height of tree
     *  Space complexity -> O(1)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        
        if (pVal > qVal) {
            int tmp = pVal;
            pVal = qVal;
            qVal = tmp;
        }
        
        while (true) {
            if (root.val >= pVal && root.val <= qVal) {
                return root;
            }
            
            if (root.val > qVal) root = root.left;
            else if (root.val < pVal) root = root.right;
        }
    }
}
