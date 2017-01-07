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
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        List<Integer> tmp = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        /* Two helper variables */
        int currNum = 1;
        int nextNum = 0;
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            currNum--;
            tmp.add(node.val);
            
            if (node.left != null) {
                queue.offer(node.left);
                nextNum++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextNum++;
            }
            
            /* Current level has been done traversing. */
            if (currNum == 0) {
                currNum = nextNum;
                nextNum = 0;
                res.add(new ArrayList<>(tmp));
                tmp.clear();
            }
        }
        
        return res;
    }
}
