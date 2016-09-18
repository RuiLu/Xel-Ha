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
     *  Need a carry
     *  One pass
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        else if (l1 == null) return l2;
        else if (l2 == null) return l1;
        
        ListNode fakeHead = new ListNode(-1);
        ListNode iter = fakeHead;
        int carry = 0;
        
        while (l1 != null || l2 != null) {
            int sum  = carry;
            
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            ListNode next = new ListNode(sum % 10);
            carry = sum / 10;
            
            iter.next = next;
            iter = next;
        }
        
        /* We must deal with the last carry! */
        if (carry != 0) iter.next = new ListNode(carry);
        
        return fakeHead.next;
    }
}
