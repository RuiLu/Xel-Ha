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
     *  Idea, create seperate small list and big list at the same time, then connect them
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }   
        
        ListNode smallHead = new ListNode(-1);
        ListNode si = smallHead;
        ListNode bigHead = new ListNode(-1);
        ListNode bi = bigHead;
        
        /* create small list and big list at the same time */
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            if (temp.val < x) {
                si.next = temp;
                si = temp;
            } else {
                bi.next = temp;
                bi = temp;
            }
        }
        
        /* connect small list with big list */
        si.next = bigHead.next;
        bi.next = null;
        return smallHead.next;
    }
}
