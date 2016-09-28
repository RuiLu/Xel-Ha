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
     *  By using the following method, we keep the last node of duplicated nodes.
     *  Time complexity -> O(n)
     *  In place.
     */ 
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode fast = head;
        ListNode slow = fakeHead;
        
        while (fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }
            slow.next = fast;
            slow = fast;
            fast = fast.next;
        }
        
        return fakeHead.next;
    }
}
