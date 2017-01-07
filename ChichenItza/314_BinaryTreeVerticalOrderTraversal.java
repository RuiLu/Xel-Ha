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
     *  Idea -> See comments. 
     *          Note we cannot use DFS here, because we need to keep order from top to bottom.
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        int max = 0;
        int min = 0;
        
        /* HashMap, Key is index of column, Value is an ArrayList storing elements' values */
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        /* Two queues, one for TreeNode, one for column index */
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        
        /* Do bfs */
        queue.offer(root);
        index.offer(0);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int idx = index.poll();
            
            /* Update max and min indices */
            max = Math.max(max, idx);
            min = Math.min(min, idx);
            
            /* Update HashMap */
            if (!map.containsKey(idx)) map.put(idx, new ArrayList<>());
            map.get(idx).add(node.val);
            
            if (node.left != null) {
                queue.offer(node.left);
                index.offer(idx+1);
            } 
            if (node.right != null) {
                queue.offer(node.right);
                index.offer(idx-1);
            }
        }
        
        /* Assign elements in HashMao into res */
        for (int i = max; i >= min; i--) res.add(map.get(i));
        
        return res;
    }
}
