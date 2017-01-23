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
     *  Use pre-order process to do serialization work.
     */
    private void dfsSerialize(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.val+",");
        dfsSerialize(node.left, sb);
        dfsSerialize(node.right, sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        dfsSerialize(root, sb);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    /**
     *  The classic way to construct a BST, using divide and conquer
     */
    private TreeNode dfsDeserialize(String[] tokens, int lo, int hi) {
        if (lo > hi) return null;
        if (lo == hi) return new TreeNode(Integer.parseInt(tokens[lo]));
        
        TreeNode root = new TreeNode(Integer.parseInt(tokens[lo]));
        
        int mid = lo+1;
        while (mid <= hi && Integer.parseInt(tokens[lo]) > Integer.parseInt(tokens[mid])) mid++;
        
        root.left = dfsDeserialize(tokens, lo+1, mid-1);
        root.right = dfsDeserialize(tokens, mid, hi);
        
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] tokens = data.split(",");
        return dfsDeserialize(tokens, 0, tokens.length-1);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
