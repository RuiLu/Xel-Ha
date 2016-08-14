/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 *  DFS
 */
public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) return null;
        StringBuilder sb = new StringBuilder();
        dfs_serialize(root, sb);
        return sb.toString().substring(0, sb.length() - 1);
    }
    
    private void dfs_serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }
        
        sb.append(node.val + ",");
        dfs_serialize(node.left, sb);
        dfs_serialize(node.right, sb);
    }
   
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        
        String[] tokens = data.split(",");
        LinkedList<String> list = new LinkedList<>();
        
        for (int i = 0; i < tokens.length; i++) {
            list.offer(tokens[i]);
        }
        
        return dfs_deserialize(list);
    }
    
    private TreeNode dfs_deserialize(LinkedList<String> list) {
        if (list.isEmpty()) return null;
        
        String curr = list.poll();
        
        if (curr.equals("null")) return null;
        
        TreeNode node = new TreeNode(Integer.parseInt(curr));
        node.left = dfs_deserialize(list);
        node.right = dfs_deserialize(list);
        
        return node;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
