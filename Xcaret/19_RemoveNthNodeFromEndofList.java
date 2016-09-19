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
     *  Second try -> using one pass
     *  Idea -> the difference between fastNode and slowNode
     *  Reference -> https://discuss.leetcode.com/topic/42339/java-solution-1ms-%E5%AE%B9%E6%98%93%E7%90%86%E8%A7%A3/2
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode fast = fakeHead;
        ListNode slow = fakeHead;
        
        while (fast.next != null) {
            if (n <= 0) slow = slow.next;
            fast = fast.next;
            n--;
        }
        
        if (slow.next != null) slow.next = slow.next.next;
        
        return fakeHead.next;
    } 
    
    /**
     *  Frist try -> using two passes
     *  Time complexity -> O(n)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        
        while (head != null) {
            len++;
            head = head.next;
        }
        
        int target = len - n + 1;
        int count = 1;
        ListNode prev = fakeHead;
        head = fakeHead.next;
        
        while (count++ != target) {
            prev = head;
            head = head.next;
        }
        
        prev.next = head == null ? null : head.next;
        
        return fakeHead.next;
    }
}
