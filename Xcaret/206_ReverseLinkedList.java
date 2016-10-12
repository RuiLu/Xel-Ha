/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}
