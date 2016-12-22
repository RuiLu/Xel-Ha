package Amazon.OA2;

import java.util.*;

/*
 *	Given node 
 */
class Node {
	int val;
	ArrayList<Node> children;
	
	public Node(int val) {
		this.val = val;
		this.children = new ArrayList<Node>();
	}
}

/*
 * 	Self-defined class, used to return children count and total sum of children
 */
class SumCount {
	int sum;
	int count;
	
	public SumCount(int sum, int count) {
		this.sum = sum;
		this.count = count;
	}
}

public class CompanyTree {
	
	/* global variables for keeping maximal average value and its corresponding node */
	private static double maxAve = Double.MIN_VALUE;
	private static Node result = null;
	
	/**
	 * Use DFS here
	 * @param root
	 * @return
	 */
	public static Node getNode(Node root) {
		if (root == null) return null;
		dfs(root);
		return result;
	}
	
	public static SumCount dfs(Node node) {
		/* first, take out the leave node */
		if (node.children == null || node.children.size() == 0) {
			return new SumCount(node.val, 1);
		}
		
		/* then, do DFS to all its children node */
		int sum = node.val;
		int count = 1;
		for (Node child : node.children) {
			SumCount sc = dfs(child);
			sum += sc.sum;
			count += sc.count;
		}
		
		/* update global variables if needed */
		double ave = sum / (count * 1.0);
		if (ave > maxAve) {
			maxAve = ave;
			result = node;
		}
		
		return new SumCount(sum, count);
	}
	
	public static void main(String[] args) {
        Node root = new Node(1);
        Node l21 = new Node(2);
        Node l22 = new Node(3);
        Node l23 = new Node(4);
        Node l31 = new Node(5);
        Node l32 = new Node(5);
        Node l33 = new Node(5);
        Node l34 = new Node(5);
        Node l35 = new Node(5);
        Node l36 = new Node(5);

        l21.children.add(l31);
        l21.children.add(l32);

        l22.children.add(l33);
        l22.children.add(l34);

        l23.children.add(l35);
        l23.children.add(l36);

        root.children.add(l21);
        root.children.add(l22);
        root.children.add(l23);

        Node res = getNode(root);
        System.out.println(res.val + " " + maxAve);
	}
}

