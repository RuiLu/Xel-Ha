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
     *  Obviously, BFS
     *  Time complexity -> O(n), where n is the total number of nodes in this tree
     *  Space complexity -> O(n)
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currNum = 1;
        int nextNum = 0;
        List<Integer> row = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            row.add(node.val);
            currNum--;
            
            if (node.left != null) {
                nextNum++;
                queue.offer(node.left);
            }
            if (node.right != null) {
                nextNum++;
                queue.offer(node.right);
            }
            
            if (currNum == 0) {
                res.add(new ArrayList<>(row));
                row.clear();
                currNum = nextNum;
                nextNum = 0;
            }
        }
        
        return res;
    }
}
