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
     *  Idea -> Use BFS to keep vertical order.
     *          Use two queues, one for TreeNode and another for level.
     *          We can use HashMap instead of TreeMap when we record the minimal and maximal levels.
     *  Time complexity -> O(n)
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        int min = 0;
        int max = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> tree = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();
        
        tree.offer(root);
        level.offer(0);
        
        while (!tree.isEmpty()) {
            TreeNode curr = tree.poll();
            int lvl = level.poll();
            
            min = Math.min(min, lvl);
            max = Math.max(max, lvl);
            
            if (!map.containsKey(lvl)) map.put(lvl, new ArrayList<>());
            map.get(lvl).add(curr.val);
            
            if (curr.left != null) {
                tree.offer(curr.left);
                level.offer(lvl - 1);
            }
            if (curr.right != null) {
                tree.offer(curr.right);
                level.offer(lvl + 1);
            }
        }
        
        for (int i = min; i <= max; i++) res.add(map.get(i));
        return res;
    }
}
