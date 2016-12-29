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
     *  Second -> binary search
     *  Time complexity -> O(logn)
     */
    public int closestValue(TreeNode root, double target) {
        
        double minDiff = Double.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        
        while (root != null) {
            if ((double)root.val == target) return root.val;
            
            double diff = Math.abs((double)root.val - target);
            if (diff <= minDiff) {
                minDiff = diff;
                res = root.val;
            }
            
            if ((double)root.val < target) root = root.right;
            else root = root.left;
        }
        
        return res;
    } 
    
    /**
     *  First -> easiest way
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public int closestValue(TreeNode root, double target) {
        List<Integer> list = new ArrayList<>();
        dfs(list, root);
        for (int i = 0; i < list.size(); i++) {
            int curr = list.get(i);
            if ((double)curr == target) return curr;
            if ((double)curr > target) {
                if (i == 0) return curr;
                else {
                    int prev = list.get(i - 1);
                    return Math.abs(target - (double)prev) <= Math.abs(target - (double)curr) ? prev : curr;
                }
            }
        }
        return list.get(list.size() - 1);
    }
    
    private void dfs(List<Integer> list, TreeNode node) {
        if (node == null) return;
        dfs(list, node.left);
        list.add(node.val);
        dfs(list, node.right);
    }
}
