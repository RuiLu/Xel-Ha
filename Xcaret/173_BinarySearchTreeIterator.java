/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    /**
     *  Using a stack, which stores TreeNode from left sub tree.
     *  Time complexity -> 1. hasNext() -> O(1) 
     *                     2. next() -> O(1) average
     *  Space complexity -> O(h)
     */
    private Stack<TreeNode> stack = null;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode curr = stack.pop();
        TreeNode temp = curr.right;
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
        return curr.val;
    }
    
    /**
     *  Time complxity -> O(1) for both
     *  Space complexity -> O(n), where n is the total number of TreeNodes
     */
    // private List<Integer> list = null;
    // private Iterator<Integer> it = null;
    
    // public BSTIterator(TreeNode root) {
    //     list = new ArrayList<>();
    //     dfs(root);
    //     it = list.iterator();
    // }
    
    // private void dfs(TreeNode node) {
    //     if (node == null) return;
    //     dfs(node.left);
    //     list.add(node.val);
    //     dfs(node.right);
    // }

    // /** @return whether we have a next smallest number */
    // public boolean hasNext() {
    //     return it.hasNext();
    // }

    // /** @return the next smallest number */
    // public int next() {
    //     return it.next();
    // }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
