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
     *  First -> BFS
     */
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        
        int currNum = 1;
        int nextNum = 0;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeLinkNode curr = queue.poll();
            
            currNum--;
            
            if (curr.left != null) {
                queue.offer(curr.left);
                nextNum++;
            }
            if (curr.right != null) {
                queue.offer(curr.right);
                nextNum++;
            }
            
            if (currNum != 0) {
                curr.next = queue.peek();
            } else {
                curr.next = null;
                currNum = nextNum;
                nextNum = 0;
            }
        }
    }
    
    /**
     *  Second -> Iteration
     */
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        
        while (root.left != null) {
            TreeLinkNode temp = root;
            while (temp != null) {
                temp.left.next = temp.right;
                if (temp.next != null) temp.right.next = temp.next.left;
                temp = temp.next;
            }
            root = root.left;
        }
    }

} 
