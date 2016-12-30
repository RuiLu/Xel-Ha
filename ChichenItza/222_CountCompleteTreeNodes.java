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
     *  Idea -> Recursion
     */
    private enum Direction {
        LEFT, RIGHT;
    } 
     
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root, Direction.LEFT);   
        int rightHeight = getHeight(root, Direction.RIGHT);
        // If leftHeight is equal to rightHeight, then calculate total node number directly
        // Otherwise, do countNodes to left subtree and right subtree recursively.
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
    
    /**
     *  Idea -> Binary search
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return 1;
        
        int height = 0;
        int nodeSum = 0;
        TreeNode node = root;
        
        // calculate the total node number above the last level
        while (node.left != null) {
            nodeSum += (1 << height);
            height++;
            node = node.left;
        }
        
        return nodeSum + countLastLevel(root, height);
    }
    
    private int countLastLevel(TreeNode node, int height) {
        if (height == 1) {
            if (node.right != null) return 2;
            else if (node.left != null) return 1;
            else return 0;
        }
        
        int currHeight = 1;
        TreeNode curr = node.left;
        
        // binary search to see if the middle node is null or not
        while (currHeight < height) {
            currHeight++;
            curr = curr.right;
        }
        
        if (curr == null) return countLastLevel(node.left, height - 1);
        else return (1 << (height - 1)) + countLastLevel(node.right, height - 1);
    }
}
