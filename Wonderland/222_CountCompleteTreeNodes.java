tion for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 1. DFS -> TLE
    // private int count = 0;
    
    // public int countNodes(TreeNode root) {
    //     dfs(root);
    //     return count;
    // }
    
    // private void dfs(TreeNode node) {
    //     if (node == null) return;
    //     dfs(node.left);
    //     count++;
    //     dfs(node.right);
    // }
    
    // 2. Recursion -> calculate the height, easy to understand, suitable for every tree
    public enum Direction {
        LEFT, RIGHT
    }
    
    public int countNodes(TreeNode root) {
        int leftHeight = getHeight(root, Direction.LEFT);
        int rightHeight = getHeight(root, Direction.RIGHT);
        if (leftHeight == rightHeight) return (1 << leftHeight) - 1;
        else return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    private int getHeight(TreeNode node, Direction direction) {
        int height = 0;
        while (node != null) {
            height++;
            switch(direction) {
                case LEFT:
                    node = node.left;
                    break;
                case RIGHT:
                    node = node.right;
                    break;
            }
        }
        return height;
    }
    
    
    // 3. Binary Search -> using the property of complete tree
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return 1;
        
        int height = 0;
        int nodeSum = 0;
        TreeNode curr = root;
        while (curr.left != null) {
            nodeSum += (1 << height);
            height++;
            curr = curr.left;
        }
        
        return nodeSum + countLastLevel(root, height);
    }
    
    private int countLastLevel(TreeNode node, int height) {
        if (height == 1) {
            if (node.right != null) return 2;
            else if (node.left != null) return 1;
            else return 0;
        }
        
        TreeNode midNode = node.left;
        int currHeight = 1;
        
        while (currHeight < height) {
            currHeight++;
            midNode = midNode.right;
        }
        
        if (midNode == null) return countLastLevel(node.left, height - 1);
        else return (1 << (height - 1)) + countLastLevel(node.right, height - 1);
    }
    
}
