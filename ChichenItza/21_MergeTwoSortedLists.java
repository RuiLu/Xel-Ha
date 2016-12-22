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
     *  Idea -> Maintain a fakeHead
     *  Time complexity -> O(m+n)
     *  Space complexity -> O(1)
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        
        ListNode fakeHead = new ListNode(-1);
        ListNode iter = fakeHead;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                iter.next = l1;
                l1 = l1.next;
            } else {
                iter.next = l2;
                l2 = l2.next;
            }
            iter = iter.next;
        }
        
        if (l1 == null) iter.next = l2;
        if (l2 == null) iter.next = l1;
        
        return fakeHead.next;
    }
}
