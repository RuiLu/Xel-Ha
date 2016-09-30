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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        List<Integer> tmp = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currNum = 1;
        int nextNum = 0;
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            tmp.add(node.val);
            currNum--;
            
            if (node.left != null) {
                queue.offer(node.left);
                nextNum++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextNum++;
            }
            
            if (currNum == 0) {
                res.add(0, new ArrayList<>(tmp));
                tmp.clear();
                currNum = nextNum;
                nextNum = 0;
            }
        }
        
        return res;
    }
}
