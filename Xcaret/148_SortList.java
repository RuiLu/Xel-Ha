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
     *  Merge sort.
     *  Time complexity -> O(nlogn)
     *  Space complexity -> O(1)
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        return mergeSort(head, null);
    }
    
    private ListNode mergeSort(ListNode begin, ListNode end) {
        if (begin == end) return begin;
        
        ListNode fakeHead = new ListNode(-1);
        ListNode runner = begin;
        ListNode walker = begin;
        
        // 1. find the middle point
        while (runner != end && runner.next != end) {
            runner = runner.next.next;
            walker = walker.next;
        }
        
        // 2. detach, create two lists
        ListNode prev = walker;
        walker = walker.next;
        prev.next = null;
        
        // 3. have two lists sorted and return their heads
        ListNode aHead = mergeSort(begin, prev);
        ListNode bHead = mergeSort(walker, end);
        
        // 4. combine these two sorted lists into one sorted list;
        ListNode iter = fakeHead;
        while (aHead != null && bHead != null) {
            if (aHead.val < bHead.val) {
                iter.next = aHead;
                aHead = aHead.next;
            } else {
                iter.next = bHead;
                bHead = bHead.next;
            }
            iter = iter.next;
        }
        
        if (aHead == null) iter.next = bHead;
        if (bHead == null) iter.next = aHead;
        
        return fakeHead.next;
    }
}
