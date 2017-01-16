package Quantcast.first;

import java.util.*;

class Node {
	int val;		
	Node left;
	Node right;
	int count;		// record the number of the same values
	int leftCount; 	// record the number of values smaller than its value.
	
	public Node(int val) {
		this.val = val;
		left = null;
		right = null;
		count = 1;
		leftCount = 0;
	}
}

public class GetNumberRankinDataStream {

	private static Node root = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String command = sc.nextLine();
			String[] tokens = command.split("\\s");
			if (tokens[0].equals("insert")) {
				insertToBST(Integer.parseInt(tokens[1]));
			} else if (tokens[0].equals("rank")) {
				int rank = findRank(Integer.parseInt(tokens[1]));
				if (rank == -1) System.out.println("There is no " + tokens[1] + " in BST.");
				else System.out.println("The rank of " + tokens[1] + " is " + rank + ".");
			} else if (tokens[0].equals("exit")) {
				break;
			} else if (tokens[0].equals("print")) {
				Node curr = root;
				print(curr);
				System.out.println();
			}
		}
		if (sc != null) sc.close();
	}

	/**
	 * Maintain a BST structure.
	 * Time complexity -> O(logn)
	 * @param val
	 */
	private static void insertToBST(int val) {
		/* We should first determine if root exists. */
		if (root == null) {
			root = new Node(val);
			return;
		}
		
		Node iter = root;
		/* Maintain the parent node for current node. */
		Node parent = null;
		
		if (iter == null) {
			iter = new Node(val);
			return;
		}
		
		while (true) {
			parent = iter;
			if (val == iter.val) {
				iter.count++;
				return;
			} else if (val > iter.val) {
				iter = iter.right;
				/* If current node has node right subtree, 
				 * then use parent node to create a new root node for its right subtree. */
				if (iter == null) {
					parent.right = new Node(val);
					return;
				}
			} else {
				iter.leftCount++;
				iter = iter.left;
				/* If current node has node left subtree, 
				 * then use parent node to create a new root node for its left subtree. */
				if (iter == null) {
					parent.left = new Node(val);
					return;
				}
			}
		}
	}
	
	/**
	 * Time complexity -> O(logn)
	 * @param val
	 * @return
	 */
	private static int findRank(int val) {
		Node iter = root;
		int rank = 0;
		while (iter != null) {
			if (val == iter.val) return rank+iter.leftCount+1;
			else if (val < iter.val) iter = iter.left;
			else {
				/* When moving to right subtree, 
				 * we should add current node's count and leftCount to rank  */
				rank += iter.count+iter.leftCount;
				iter = iter.right;
			}
		}
		return -1;
	}
	
	private static void print(Node curr) {
		if (curr == null) return;
		print(curr.left);
		System.out.print(curr.val + " ");
		print(curr.right);
	}
	
}

