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
     *  Idea -> Merge sort (Divide and conquer).
     *  Time complexity -> O(nlogn)
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode fakeHead = new ListNode(-1);
        ListNode walker = head;
        ListNode runner = head.next;
        ListNode secondHead = null;
        
        // Divide the current list into two lists
        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }
        secondHead = walker.next;
        walker.next = null;
        
        // Sort two lists separately
        ListNode h1 = sortList(head);
        ListNode h2 = sortList(secondHead);
        
        // Merge two sorted lists
        int count = 0;
        ListNode iter = fakeHead;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                iter.next = h1;
                h1 = h1.next;
            } else {
                iter.next = h2;
                h2 = h2.next;
            }
            iter = iter.next;
        }
        
        if (h1 == null && h2 != null) iter.next = h2;
        if (h1 != null && h2 == null) iter.next = h1;
        
        return fakeHead.next;
    }
}
