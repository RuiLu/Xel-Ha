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
     *  Second try -> avoid to use extra space
     *  Idea -> Maintaining three variables 
     *       -> 1. nextHead - start point for next level traversal
     *       -> 2. prev - the previous node of iter
     *       -> 3. iter - used for traversing next pointer
     *  
     *  Reference -> https://discuss.leetcode.com/topic/1106/o-1-space-o-n-complexity-iterative-solution
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        
        while (root != null) {
            TreeLinkNode iter = root;
            TreeLinkNode nextHead = null;
            TreeLinkNode prev = null;
            
            while (iter != null) {
                if (iter.left != null) {
                    if (prev != null) prev.next = iter.left;
                    else nextHead = iter.left;
                    prev = iter.left;
                }
                if (iter.right != null) {
                    if (prev != null) prev.next = iter.right;
                    else nextHead = iter.right;
                    prev = iter.right;
                }
                iter = iter.next;
            }
            
            root = nextHead;
        }
    } 
     
    /**
     *  First try -> BFS, but with extra space
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.offer(root);
        int currLevel = 1;
        int nextLevel = 0;
        
        while (!queue.isEmpty()) {
            TreeLinkNode node = queue.poll();
            currLevel--;
            
            if (node.left != null) {
                queue.offer(node.left);
                nextLevel++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextLevel++;
            }
            
            if (currLevel == 0) {
                currLevel = nextLevel;
                nextLevel = 0;
            } else {
                if (!queue.isEmpty()) {
                    node.next = queue.peek();
                }
            }
        }
    } 
}
