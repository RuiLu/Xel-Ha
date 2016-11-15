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
     *  One pass
     *  Constant space 
     *  Reference -> https://discuss.leetcode.com/topic/5604/share-my-java-solution-with-comments-in-line
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        ListNode tail = fakeHead;
        ListNode temp = null;
        
        
        while (true) {
            int count = k;
            
            while (tail != null && count > 0) {
                count--;
                tail = tail.next;
            }
            
            if (tail == null) break;
            
            head = prev.next;
            
            while (prev.next != tail) {
                temp = prev.next;
                prev.next = prev.next.next;
                
                temp.next = tail.next;
                tail.next = temp;
            }
            
            prev = head;
            tail = head;
        }
        
        return fakeHead.next;
    }
}
