/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     *  First solution: Iteration
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        while (root.left != null) {
            TreeLinkNode iter = root;
            while (iter.next != null) {
                iter.left.next = iter.right;
                iter.right.next = iter.next.left;
                iter = iter.next;
            }
            iter.left.next = iter.right;
            root = root.left;
        }
    }
    
    /**
     *  Second solution: Recursion
     */
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }
}
