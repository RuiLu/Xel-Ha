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
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        
        TreeLinkNode head = null;
        TreeLinkNode prev = null;
        TreeLinkNode iter = root;
        
        while (iter != null) {
            while (iter != null) {
                // left child
                if (iter.left != null) {
                    if (prev != null) {
                        prev.next = iter.left;
                    } else {
                        head = iter.left;
                    }
                    prev = iter.left;
                }
                
                // right child
                if (iter.right != null) {
                    if (prev != null) {
                        prev.next = iter.right;
                    } else {
                        head = iter.right;
                    }
                    prev = iter.right;
                }
                
                // move iter to next
                iter = iter.next;
            }
            
            iter = head;
            head = null;
            prev = null;
        }
    } 
     
    /**
     *  First try -> BFS, but with extra space
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    // public void connect(TreeLinkNode root) {
    //     if (root == null) return;
        
    //     Queue<TreeLinkNode> queue = new LinkedList<>();
    //     queue.offer(root);
    //     int currNum = 1;
    //     int nextNum = 0;
        
    //     while (!queue.isEmpty()) {
    //         TreeLinkNode node = queue.poll();
    //         currNum--;
            
    //         if (node.left != null) {
    //             queue.offer(node.left);
    //             nextNum++;
    //         }
    //         if (node.right != null) {
    //             queue.offer(node.right);
    //             nextNum++;
    //         }
            
    //         if (currNum != 0) {
    //             node.next = queue.peek();
    //         } else {
    //             currNum = nextNum;
    //             nextNum = 0;
    //         }
    //     }
    // } 
}
