/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = first.next;
            ListNode next = head.next.next;
            
            prev.next = second;
            second.next = first;
            first.next = next;
            
            head = next;
            prev = first;
        }
        
        return fakeHead.next;
    }
}
