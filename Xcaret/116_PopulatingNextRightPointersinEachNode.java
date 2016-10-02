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
     *  Iteration
     *  Time complexity -> O(n)
     */
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        
        while (root.left != null) {
            TreeLinkNode iter = root;
            while (iter != null) {
                iter.left.next = iter.right;
                if (iter.next != null) iter.right.next = iter.next.left;
                iter = iter.next;
            }
            root = root.left;
        }
    }
    
    /**
     *  BFS
     *  Time complexity -> O(n)
     */
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        int currNum = 1;
        int nextNum = 0;
        
        while (!queue.isEmpty()) {
            TreeLinkNode node = queue.poll();
            currNum--;
            
            if (node.left != null) {
                queue.offer(node.left);
                nextNum++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextNum++;
            }
            
            if (currNum != 0) {
                node.next = queue.peek();
            } else {
                currNum = nextNum;
                nextNum = 0;
            }
        }
    }
}
