/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null || (head.next == null && head.val == val)) return null;
        
        ListNode prev = null;
        ListNode fakeHead = new ListNode(-1);
        
        prev = fakeHead;
        fakeHead.next = head;
        
        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
            } else {
                prev = head;
            }
            head = head.next;
        }
        
        return fakeHead.next;
    }
}
