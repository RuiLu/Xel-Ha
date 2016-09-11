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
     *  BFS
     *  No need for TreeMap, only need HashMap
     *  Using two queue, one for TreeNode and one for column number
     *  Reference -> https://discuss.leetcode.com/topic/31954/5ms-java-clean-solution
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        /* Key is column number */
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        int min = 0;
        int max = 0;
        
        nodes.offer(root);
        cols.offer(0);
        
        while (!nodes.isEmpty()) {
            TreeNode curr = nodes.poll();
            int col = cols.poll();
            
            if (!map.containsKey(col)) map.put(col, new ArrayList<>());
            map.get(col).add(curr.val);
            
            if (curr.left != null) {
                nodes.offer(curr.left);
                cols.offer(col - 1);
                min = Math.min(min, col - 1);
            }
            if (curr.right != null) {
                nodes.offer(curr.right);
                cols.offer(col + 1);
                max = Math.max(max, col + 1);
            }
        }
        
        for (int i = min; i <= max; i++) res.add(map.get(i));
        
        return res;
    } 


    /**
     *  Using TreeMap
     *  Time complexity -> O(nlogn), where n is the total number of tree nodes
     *  Space complexity -> O(n)
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        Map<Integer, TreeMap<Integer, ArrayList<Integer>>> tmap = new TreeMap<>();
        int row = 0;
        int col = 0;
        
        dfsHelper(root, tmap, row, col);
        
        for (Map.Entry<Integer, TreeMap<Integer, ArrayList<Integer>>> outEntry : tmap.entrySet()) {
            List<Integer> tmp = new ArrayList<>();
            TreeMap<Integer, ArrayList<Integer>> map = outEntry.getValue();
            for (ArrayList<Integer> list : map.values()) {
                for (int val : list) tmp.add(val);
            }
            res.add(tmp);
        }
        
        return res;
    }
    
    /* Preorder traverse. Actually, any order traverse will work, since we use TreeMap here */
    private void dfsHelper(TreeNode node, Map<Integer, TreeMap<Integer, ArrayList<Integer>>> tmap, int row, int col) {
        if (node == null) return;
        
        if (!tmap.containsKey(col)) tmap.put(col, new TreeMap<Integer, ArrayList<Integer>>());
        if (!tmap.get(col).containsKey(row)) tmap.get(col).put(row, new ArrayList<Integer>());
        tmap.get(col).get(row).add(node.val);
        
        dfsHelper(node.left, tmap, row + 1, col - 1);
        dfsHelper(node.right, tmap, row + 1, col + 1);
    }
}
