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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        
        ListNode prev = fakeHead;
        ListNode curr = head;
        ListNode next = null;
        
        while (curr != null) {
            next = curr.next;
            
            if (curr.val == val) {
                prev.next = next;    
            } else {
                prev = curr;
            }
            
            curr = next;
        }
        
        return fakeHead.next;
    }
}
