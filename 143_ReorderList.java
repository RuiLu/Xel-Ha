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
     *  Two pointer, cut original list into two lists, and reverse the second part, finally, insert
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        // 1. cut 
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode aHead = head;
        ListNode bHead = slow.next;
        slow.next = null;
        
        // 2. reverse
        ListNode curr = bHead;
        ListNode next = curr.next;
        ListNode prev = null;
        while (next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        bHead = curr;
        
        // 3. merge
        while (aHead != null && bHead != null) {
            next = aHead.next;
            aHead.next = bHead;
            aHead = next;
            next = bHead.next;
            bHead.next = aHead;
            bHead = next;
        }
    }
}
