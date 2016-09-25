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
     *  In place.
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        
        int len = 0;
        ListNode iter = head;
        ListNode prev = null;
        ListNode newHead = null;
        
        while (iter != null) {
            len++;
            iter = iter.next;
        }
        
        k = k % len;
        if (k == 0) return head;
        k = len - k;
        iter = head;
        
        while (k-- > 0) {
            prev = iter;
            iter = iter.next;
        }
        
        newHead = iter;
        prev.next = null;
        
        while (iter.next != null) {
            iter = iter.next;
        }
        
        iter.next = head;
        
        return newHead;
    }
}
