/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    /**
     *  Idea -> Serialize: Preorder traversa tree to create a string, for example 3,1,2,5,4,6
     *          Deserialize: first element within lo and hi is root, then we can divide the array into tree parts:
     *                       3 ->root. 1, 2 -> left subtree. 5, 4, 6 -> right subtree 
     */
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        StringBuilder sb = new StringBuilder();
        dfsSerialize(root, sb);
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
    
    private void dfsSerialize(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.val + ",");
        dfsSerialize(node.left, sb);
        dfsSerialize(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] tokens = data.split(",");
        int[] nums = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            nums[i] = Integer.parseInt(tokens[i]);
        }
        return dfsDeserialize(nums, 0, nums.length - 1);
    }
    
    private TreeNode dfsDeserialize(int[] nums, int lo, int hi) {
        if (lo > hi) return null;
        if (lo == hi) return new TreeNode(nums[lo]);
        
        TreeNode root = new TreeNode(nums[lo]);
        
        int leftChild = nums[lo];
        int mid = lo + 1;
        for (; mid <= hi; mid++) {
            if (nums[mid] > leftChild) break;
        }
        
        root.left = dfsDeserialize(nums, lo + 1, mid - 1);
        root.right = dfsDeserialize(nums, mid, hi);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
