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
        if (head == null || head.next == null || k < 2) return head;
        
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        
        ListNode prev = fakeHead;
        ListNode tail = fakeHead;
        ListNode temp = null;
        int count = 0;
        
        while (true) {
            count = k;
            
            while (count > 0 && tail != null) {
                count--;
                tail = tail.next;
            }
            
            if (tail == null) break;
            
            head = prev.next;   // prepare for next round
            
            while (prev.next != tail) {
                temp = prev.next;
                prev.next = temp.next;
                
                temp.next = tail.next;
                tail.next = temp;
            }
            
            prev = head;
            tail = head;
        }
        
        return fakeHead.next;
    }
}
