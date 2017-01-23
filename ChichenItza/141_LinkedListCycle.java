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
     * Idea -> Two pointers, walker and runner.
     *         If the linked list has cycle, walker and runner will point at some point
     * Time complexity -> O(n)
     * Space complexity -> O(1)
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        
        ListNode walker = head;
        ListNode runner = head.next;
        
        while (runner != null && runner.next != null) {
            if (walker == runner) return true;
            walker = walker.next;
            runner = runner.next.next;
        }
        
        return false;
    }
}
