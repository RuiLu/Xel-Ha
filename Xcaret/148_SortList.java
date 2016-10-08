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
    
    private ListNode mergeSort(ListNode start, ListNode end) {
        if (start == end) return start;
        
        ListNode runner = start;
        ListNode walker = start;
        
        // first -> find the middle node of the list
        while (runner != end && runner.next != end) {
            runner = runner.next.next;
            walker = walker.next;
        }
        
        // second -> divide the list into two parts
        ListNode prev = walker;
        walker = walker.next;
        prev.next = null;
        
        // third -> the returned results are sorted already
        ListNode aList = mergeSort(start, prev);
        ListNode bList = mergeSort(walker, end);
        
        // fourth -> combine these two sorted list into one sorted list
        ListNode fakeHead = new ListNode(-1);
        ListNode iter = fakeHead;
        
        while (aList != null && bList != null) {
            if (aList.val < bList.val) {
                iter.next = aList;
                aList = aList.next;
            } else {
                iter.next = bList;
                bList = bList.next;
            }
            iter = iter.next;
        }
            
        if (aList == null) iter.next = bList;
        if (bList == null) iter.next = aList;
        
        return fakeHead.next;
    }
}
