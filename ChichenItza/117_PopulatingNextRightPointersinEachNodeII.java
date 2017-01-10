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
     *  First solution: Iteration, but need to record the starting node of next level
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public void connect(TreeLinkNode root) {
        TreeLinkNode nextHead = root;
        while (nextHead != null) {
            TreeLinkNode iter = nextHead;   // assign the head otained from last level to iteration node
            TreeLinkNode prev = null;       // prev node store the previous node of current node in the same level
            nextHead = null;               // reset nextHead to null before traversing every level
            
            while (iter != null) {
                if (iter.left != null) {
                    if (nextHead == null) nextHead = iter.left;
                    if (prev != null) prev.next = iter.left;
                    prev = iter.left;
                }
                if (iter.right != null) {
                    if (nextHead == null) nextHead = iter.right;
                    if (prev != null) prev.next = iter.right;
                    prev = iter.right;
                }
                iter = iter.next;
            }
        }
    }
    
    /**
     *  Second solution: BFS, use a Deque to obtain peekLast() method.
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        
        Deque<TreeLinkNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int currNum = 1;
        int nextNum = 0;
        
        while (!queue.isEmpty()) {
            TreeLinkNode node = queue.pollFirst();
            currNum--;
            
            if (node.left != null) {
                if (nextNum != 0) queue.peekLast().next = node.left;
                queue.offer(node.left);
                nextNum++;
            }
            if (node.right != null) {
                if (nextNum != 0) queue.peekLast().next = node.right;
                queue.offer(node.right);
                nextNum++;
            }
            
            if (currNum == 0) {
                currNum = nextNum;
                nextNum = 0;
            }
        }
    }
}
