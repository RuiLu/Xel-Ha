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
     *  DFS
     *  Idea -> Odd level, scan from right to left, so we can insert a new value into the head of list
     *          Even level, scan from left to right, so insert a new value into the tail of list
     *  Time complexity -> O(n), where n is the todal number of nodes
     *  Space complexity -> O(h), where h is height of tree
     *  
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, res, 0);
        return res;
    }
    
    private void dfs(TreeNode node, List<List<Integer>> res, int level) {
        if (node == null) return;
        
        if (level >= res.size()) res.add(new ArrayList<>());
        
        if (level % 2 == 0) {
            res.get(level).add(node.val);
        } else {
            res.get(level).add(0, node.val);
        }
        
        dfs(node.left, res, level + 1);
        dfs(node.right, res, level + 1);
    }
    
    /**
     *  BFS with an indicator and an stack (FILO)
     *  We are not using Queue here as normal binary tree level order traversal.
     *  Because Zigzag requires the feature of First in Last out
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
    
        boolean toRight = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> tmp = new ArrayList<>();
        int currLevel = 1;
        int nextLevel = 0;
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            currLevel--;
            
            if (!toRight) tmp.add(node.val);
            else tmp.add(0, node.val);
            
            if (node.left != null) {
                queue.offer(node.left);
                nextLevel++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextLevel++;
            }
            
            if (currLevel == 0) {
                toRight = !toRight;
                res.add(new ArrayList<>(tmp));
                tmp = new ArrayList<>();
                currLevel = nextLevel;
                nextLevel = 0;
            }
        }
        
        return res;
    }
}
