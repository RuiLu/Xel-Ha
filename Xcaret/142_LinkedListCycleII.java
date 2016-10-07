/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     *  Idea -> Two pointers, once runner meets with walker, let head and walker keep the same path,
     *          the meeting point is the result, if there is one
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        
        ListNode runner = head;
        ListNode walker = head;
        
        while (runner != null && runner.next != null) {
            runner = runner.next.next;
            walker = walker.next;
            if (walker == runner) {
                while (head != walker) {
                    head = head.next;
                    walker = walker.next;
                }   
                return walker;
            }
        }
        
        return null;
    }
}
