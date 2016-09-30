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
     *  Backtracking + Inorder Traversal
     *  Time complexity -> O(n), because we are traversing the whole tree
     *  @param root
     *  @param sum
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        List<Integer> list = new ArrayList<>();
        getPathSum(lists, list, root, sum);
        return lists;
    }
    
    /**
     *  @param lists
     *  @param list
     *  @param node
     *  @param target
     */
    private void getPathSum(List<List<Integer>> lists, List<Integer> list, TreeNode node, int target) {
        if (node == null) return;
        
        list.add(node.val);
        if (node.left == null && node.right == null && node.val == target) {
            lists.add(new ArrayList<>(list));
        }
        getPathSum(lists, list, node.left, target - node.val);
        getPathSum(lists, list, node.right, target - node.val);
        list.remove(list.size() - 1);
    }
}
