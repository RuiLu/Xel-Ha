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
     *  We can use BFS
     */
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        
        int currNum = 1;
        int nextNum = 0;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        
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
                node.next = null;
                currNum = nextNum;
                nextNum = 0;
            }
        }
    }
}
