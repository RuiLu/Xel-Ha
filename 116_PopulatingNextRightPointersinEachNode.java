/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 1. DFS
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
    
    // 2. BFS
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        int currNum = 1;
        int nextNum = 0;
        while (!queue.isEmpty()) {
            TreeLinkNode node = queue.poll();
            currNum--;
            if (node.left != null) {
                queue.add(node.left);
                nextNum++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextNum++;
            }
            if (currNum == 0) {
                node.next = null;
                currNum = nextNum;
                nextNum = 0;
            } else {
                node.next = queue.peek();
            }
        }
    }
}
