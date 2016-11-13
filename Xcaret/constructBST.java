/**
 *	- You're given an array of integers
 *	- You're asked to construct a binary search tree from this array
 *	- Please create your BST class such that it supports two operations:
 * 	  exists(k) and successor(k) in logarithmic time
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;
	
	public TreeNode() {}
	
	public TreeNode(int val) {
		this.val = val;
	}
}

class MyBST {
	
	Set<Integer> set = new HashSet<>();
	int[] arr = null;
	
	public MyBST(int[] arr) {
		this.arr = arr;
		Arrays.sort(arr);
		for (int num : arr) set.add(num);
	}
	
	public TreeNode construct() {
		int lo = 0;
		int hi = arr.length - 1;
		return constructBST(lo, hi);
	}
	
	private TreeNode constructBST(int lo, int hi) {
		if (lo > hi) return null;
		
		int mid = (lo + hi) / 2;
		TreeNode root = new TreeNode(arr[mid]);
		
		root.left = constructBST(lo, mid - 1);
		root.right = constructBST(mid + 1, hi);
		
		return root;
	}
	
	public boolean exists(int k) {
		return set.contains(k);
	}
	
	public int successor(int k) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == k) {
				return i == arr.length -  1 ? -1 : arr[i+1];
			}
		}
		return -1;
	}
}

public class constructBST {
		public static void main(String[] args) {
			int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
			MyBST mb = new MyBST(arr);
			TreeNode root = mb.construct();
			dfs(root);
			System.out.println("\n" + mb.exists(11));
			System.out.println("successor -> " + mb.successor(10));
		}
		
		private static void dfs(TreeNode node) {
			if (node == null) return;
			dfs(node.left);
			System.out.print(node.val + "->");
			dfs(node.right);
		}
}

