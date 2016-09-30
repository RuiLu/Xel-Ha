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
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        zigzagTraversal(root, 0, result);
        return result;
    }
    
    private void zigzagTraversal(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) return;
        
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        
        if (level % 2 == 0) {
            result.get(level).add(node.val);
        } else {
            result.get(level).add(0, node.val);
        }
        
        zigzagTraversal(node.left, level + 1, result);
        zigzagTraversal(node.right, level + 1, result);
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
        List<Integer> tmp = new ArrayList<>();
        Stack<TreeNode> curr = new Stack<>();
        Stack<TreeNode> next = new Stack<>();
        curr.push(root);
        
        while (!curr.isEmpty()) {
            TreeNode node = curr.pop();
            tmp.add(node.val);
            
            if (toRight) {
                if (node.right != null) next.push(node.right);
                if (node.left != null) next.push(node.left);
            } else {
                if (node.left != null) next.push(node.left);
                if (node.right != null) next.push(node.right);
            }
            
            if (curr.isEmpty()) {
                curr = (Stack<TreeNode>)next.clone();
                next.clear();
                res.add(new ArrayList<>(tmp));
                tmp.clear();
                toRight = !toRight;
            }
        }
        
        return res;
    }
}
