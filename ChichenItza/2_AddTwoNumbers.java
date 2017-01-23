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
     *  Idea -> Be careful with the carry.
     *  Time complexity -> O(n)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;
        
        int carry = 0;
        ListNode fakeHead = new ListNode(-1);
        ListNode iter = fakeHead;
        
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            
            int sum = val1+val2+carry;
            carry = sum/10;
            
            iter.next = new ListNode(sum%10);
            iter = iter.next;
        }
        
        if (carry != 0) iter.next = new ListNode(carry);
        
        return fakeHead.next;
    }
}
