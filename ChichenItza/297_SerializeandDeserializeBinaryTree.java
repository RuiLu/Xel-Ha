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

    private void dfsSerialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val + ",");
        dfsSerialize(node.left, sb);
        dfsSerialize(node.right, sb);
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        dfsSerialize(root, sb);
        return sb.substring(0, sb.length() - 1);
    }
    
    private TreeNode dfsDeserialize(Queue<String> queue) {
        String token = queue.poll();
        if (token.equals("null")) return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(token));
        root.left = dfsDeserialize(queue);
        root.right = dfsDeserialize(queue);
        
        return root;
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        
        Queue<String> queue = new LinkedList<>();
        String[] tokens = data.split(",");
        for (String token : tokens) queue.offer(token);
        
        return dfsDeserialize(queue);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
