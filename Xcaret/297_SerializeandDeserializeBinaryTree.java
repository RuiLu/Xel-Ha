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
    private void dfsSerialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("n,");
            return;
        }
        
        sb.append(node.val + ",");
        dfsSerialize(node.left, sb);
        dfsSerialize(node.right, sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsSerialize(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private TreeNode dfsBuildTree(Deque<String> queue) {
        String curr = queue.poll();
        if (curr.equals("n")) return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(curr));
        root.left = dfsBuildTree(queue);
        root.right = dfsBuildTree(queue);
        
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        
        String[] tokens = data.split(",");
        Deque<String> queue = new ArrayDeque<String>();
        for (String token : tokens) queue.offer(token);
        
        return dfsBuildTree(queue);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
