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
     *  Idea -> 1. Divide the list into two part
     *          2. Reverse the latter part
     *          3. Insert
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        ListNode walker = head;
        ListNode runner = head;
       
        // 1. find the middle point, and break it
        while (runner != null && runner.next != null) {
            runner = runner.next.next;
            walker = walker.next;
        }
        
        ListNode firstHead = head;
        ListNode secondHead = walker.next;
        walker.next = null;
        
        // 2. reverse the latter part of list
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = secondHead;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        secondHead = prev;
        
        // 3. insert;
        ListNode firstNext = null;
        ListNode secondNext = null;
        
        while (firstHead != null && secondHead != null) {
            firstNext = firstHead.next;
            secondNext = secondHead.next;
            
            firstHead.next = secondHead;
            secondHead.next = firstNext;
            
            firstHead = firstNext;
            secondHead = secondNext;
        }
    }
}
