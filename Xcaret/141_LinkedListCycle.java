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
     *  Two pointers, runner and walker
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        
        ListNode runner = head;
        ListNode walker = head;
        
        while (runner != null && runner.next != null) {
            runner = runner.next.next;
            walker = walker.next;
            if (runner == walker) return true;
        }
        
        return false;
    }
}
