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
     *  Idea -> Serialize: using dfs to preorder traverse tree, when meeting null, using "n" to store.
     *          Deserialize: using a queue to store each token, and using dfs again to build the tree.
     */
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) return sb.toString();
        dfsSerialize(root, sb);
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    private void dfsSerialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("n,");
            return;
        }
        sb.append(node.val+",");
        dfsSerialize(node.left, sb);
        dfsSerialize(node.right, sb);
    }    

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] tokens = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for (String token : tokens) queue.offer(token);
        return dfsDeserialize(queue);
    }
    
    private TreeNode dfsDeserialize(Queue<String> queue) {
        String token = queue.poll();
        if (token.equals("n")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(token));
        node.left = dfsDeserialize(queue);
        node.right = dfsDeserialize(queue);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
