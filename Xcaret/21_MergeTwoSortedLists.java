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
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode fakeHead = new ListNode(-1);
        ListNode iter = fakeHead;
        
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                iter.next = l2;
                break;
            }
            if (l2 == null) {
                iter.next = l1;
                break;
            }
            
            if (l1.val <= l2.val) {
                iter.next = l1;
                l1 = l1.next;
            } else {
                iter.next = l2;
                l2 = l2.next;
            }
            
            iter = iter.next;
        }
        
        return fakeHead.next;
    }
}
