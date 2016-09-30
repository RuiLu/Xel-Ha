/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     *  DFS + two pointers
     *  Time complexity -> O(nlogn), n for the two pointers, logn for the traversal down to leaves
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return buildTree(head, null);
    } 
    
    private TreeNode buildTree(ListNode head, ListNode tail) {
        if (head == tail) return null;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        TreeNode root = new TreeNode(slow.val);
        root.left = buildTree(head, slow);
        root.right = buildTree(slow.next, tail);
        return root;
    }
    
    /**
     *  Turn linkedlist into arraylist
     *  Time complexity -> O(2n) -> TLE...
     *  Space complexity -> O(h+n)
     */
    // public TreeNode sortedListToBST(ListNode head) {
    //     if (head == null) return null;
    //     List<Integer> list = new ArrayList<>();
    //     while (head != null) {
    //         list.add(head.val);
    //         head = head.next;
    //     }
    //     return buildBST(list, 0, list.size() - 1);
    // }
    
    // private TreeNode buildBST (List<Integer> list, int lo, int hi) {
    //     if (lo > hi) return null;
        
    //     int mid = (lo + hi) / 2;
    //     TreeNode root = new TreeNode(list.get(mid));
    //     root.left = buildBST(list, lo, mid - 1);
    //     root.right = buildBST(list, mid + 1, hi);
        
    //     return root;
    // }
}
