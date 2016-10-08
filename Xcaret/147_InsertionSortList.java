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
     *  Insertion sort
     *  Time complexity -> O(n^2)
     *  Space complexity -> O(1)
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode fakeHead = new ListNode(Integer.MIN_VALUE);
        fakeHead.next = head;
        ListNode iter = head;
        ListNode prev = fakeHead;
       
        while (iter != null) {
            ListNode next = iter.next;
            
            ListNode fakeIter = fakeHead;
            ListNode fakePrev = null;
            while (fakeIter != iter) {
                if (fakePrev != null && fakeIter.val > iter.val) {
                    fakePrev.next = iter;
                    iter.next = fakeIter;
                    prev.next = next;
                    break;
                }
                fakePrev = fakeIter;
                fakeIter = fakeIter.next;
            }
            
            // we change prev iff we don't need to do insertion sort this round
            if (fakeIter == iter) prev = iter;
            iter = next;
        }
        
        return fakeHead.next;
    }
}
