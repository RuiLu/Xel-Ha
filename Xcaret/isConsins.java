import java.util.LinkedList;
import java.util.Queue;

public class IsConsins {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.right = new TreeNode(3);
//		root.left.left = new TreeNode(4);
//		root.left.right = new TreeNode(5);
//		root.right.left = new TreeNode(6);
//		root.right.right = new TreeNode(7);
//		root.left.left.left = new TreeNode(8);
//		root.left.left.right = new TreeNode(9);
//		root.left.right.left = new TreeNode(10);
//		root.left.right.right = new TreeNode(11);
//		root.right.left.left = new TreeNode(12);
//		root.right.left.right = new TreeNode(13);
//		root.right.right.left = new TreeNode(14);
//		root.right.right.right = new TreeNode(15);
		
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
		
//		TreeNode a = new TreeNode(8);
//		TreeNode b = new TreeNode(9);
//		System.out.println(isConsins(root, root.left.left.left, root.left.left.right));
        
        TreeNode a, b;
        a = root.left.left;
        b = root.right;
        System.out.println(isConsins(root, a, b));
	}
	
	    public static boolean isConsins(TreeNode root, TreeNode a, TreeNode b) {
	        if (root == null) return false; 
	        
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        queue.offer(root);
	        int currLevel = 1;
	        int nextLevel = 0;
	        boolean foundA = false;
	        boolean foundB = false;
	        
	        while (!queue.isEmpty()) {
	            TreeNode node = queue.poll();
	            currLevel--;
	            int indicator = 0;
	            
	            if (node.left != null) {
	                if (node.left == a) {
	                	indicator++;
	                	foundA = true;
	                }
	                if (node.left == b) {
	                	indicator++;
	                	foundB = true;
	                }
	                queue.offer(node.left);
	                nextLevel++;    
	            }
	            if (node.right != null) {
	            	if (node.right == a) {
	                	indicator++;
	                	foundA = true;
	                }
	                if (node.right == b) {
	                	indicator++;
	                	foundB = true;
	                }
	                queue.offer(node.right);
	                nextLevel++;
	            } 
	            
	            if (indicator == 2) return false;
	            if (currLevel == 0) {
	                if (foundA && foundB) return true;    // return result
	                foundA = false;
	                foundB = false;
	                currLevel = nextLevel;
	                nextLevel = 0;
	            }
	        }
	        
	        return false;
	    }    
	
}

