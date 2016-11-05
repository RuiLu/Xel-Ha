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
     *  Idea -> First get all elements in a list in ascending order,
     *          then find the cloest element,
     *          then use two pointers to tracking down the closest k element.
     *          Note that we should avoid Integer Overflow.
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    private static void dfs(TreeNode node, List<Long> list) {
        if (node == null) return;
        dfs(node.left, list);
        list.add((long)node.val);
        dfs(node.right, list);
    }
     
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        List<Long> list = new ArrayList<>();
        dfs(root, list);
        
        int index = -1;
        
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) * 1.0 == target) {
                index = i;
                break;
            }
            if (list.get(i) * 1.0 > target) {
                if (i > 0) {
                    double diff1 = Math.abs(list.get(i - 1) * 1.0 - target);
                    double diff2 = Math.abs(list.get(i) * 1.0 - target);
                    if (diff1 > diff2) index = i;
                    else index = i - 1;
                } else {
                    index = i;
                }
                break;
            }
            
            index = i;
        } 
        
        res.add(list.get(index).intValue());
        int left = index - 1;
        int right = index + 1;
        
        while (res.size() < k) {
            if (left >= 0 && right < list.size()) {
                double diff1 = Math.abs(target - list.get(left) * 1.0);
                double diff2 = Math.abs(list.get(right) * 1.0 - target);
                if (diff1 > diff2) {
                    res.add(list.get(right++).intValue());
                } else {
                    res.add(list.get(left--).intValue());
                }
            } else if (left < 0) {
                res.add(list.get(right++).intValue());
            } else if (right >= list.size()) {
                res.add(list.get(left--).intValue());
            }
        }
        
        return res;
    }
}
