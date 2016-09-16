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
     *  Second -> Only need one pass, need inner class
     *  Reference -> https://discuss.leetcode.com/topic/36995/share-my-o-n-java-code-with-brief-explanation-and-comments
     *  Time complexity -> O(n)
     */
    class Node{
        int size;
        int lower;
        int upper;
        
        public Node(int size, int lower, int upper) {
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }
    
    int max = Integer.MIN_VALUE;
    
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        
        helper(root);
        
        return max == Integer.MIN_VALUE ? 0 : max;
    } 
    
    private Node helper(TreeNode node) {
        if (node == null) {
            return new Node(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        
        Node left = helper(node.left);
        Node right = helper(node.right);
        
        if (left.size == -1 || right.size == -1 || node.val <= left.upper || node.val >= right.lower) {
            return new Node(-1, 0, 0);
        }
        
        int size = 1 + left.size + right.size;
        max = Math.max(max, size);
        return new Node(size, Math.min(node.val, left.lower), Math.max(node.val, right.upper));
    }
    
    /**
     *  First -> Traverse tree(BFS), check every node, then count
     *  Time complexity -> O(nm)
     */
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            int[] count = new int[1];
            if (isBST(node, Integer.MAX_VALUE, Integer.MIN_VALUE, count)) {
                max = Math.max(max, count[0]);
            }
            
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        
        return max == Integer.MIN_VALUE ? 0 : max;
    }
    
    /* Time complexity -> O(m), where m is the number of nodes rooted from node */
    private boolean isBST(TreeNode node, int max, int min, int[] count) {
        if (node == null) return true;
        
        count[0]++;
        
        if (node.val >= max || node.val <= min) return false;
        
        return isBST(node.left, Math.min(node.val, max), min, count) && 
              isBST(node.right, max, Math.max(min, node.val), count);
    }
}
