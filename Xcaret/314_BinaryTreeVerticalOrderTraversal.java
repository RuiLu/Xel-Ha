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
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        
        int min = 0;
        int max = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        
        queue.offer(root);
        levels.offer(0);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int level = levels.poll();
            min = Math.min(min, level);
            max = Math.max(max, level);
            
            if (!map.containsKey(level)) map.put(level, new ArrayList<>());
            map.get(level).add(node.val);
            
            if (node.left != null) {
                queue.offer(node.left);
                levels.offer(level - 1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                levels.offer(level + 1);
            }
        }
        
        for (int i = min; i <= max; i++) lists.add(map.get(i));
        
        return lists;
    }
}
