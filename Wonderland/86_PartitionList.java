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
     *  In one pass
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        
        ListNode smallHead = new ListNode(-1);
        ListNode bigHead = new ListNode(-1);
        ListNode n1 = smallHead, n2 = bigHead;
        
        while (head != null) {
            if (head.val < x) {
                n1.next = head;
                n1 = n1.next;
            } else {
                n2.next = head;
                n2 = n2.next;
            }
            head = head.next;
        }
        
        n1.next = bigHead.next;
        n2.next = null;
        
        return smallHead.next;
    }
    
    /**
     *  In two runs
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    // public ListNode partition(ListNode head, int x) {
    //     if (head == null || head.next == null) return head;
        
    //     ListNode fakeHead = new ListNode(-1);
    //     ListNode curr = fakeHead;
    //     ListNode iter = head;
        
    //     while (iter != null) {
    //         if (iter.val < x) {
    //             curr.next = new ListNode(iter.val);
    //             curr = curr.next;
    //         }
    //         iter = iter.next;
    //      }
         
    //      while (head != null) {
    //          if (head.val >= x) {
    //              curr.next = new ListNode(head.val);
    //              curr = curr.next;
    //          }
    //          head = head.next;
    //      }
         
    //      return fakeHead.next;
    // }
}
