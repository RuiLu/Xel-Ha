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
     * Idea -> See comments.
     * Time complexity -> O(n)
     * Space complexity -> O(1)
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        ListNode walker = head;
        ListNode runner = head;
        ListNode prev = null;
        ListNode next;
        ListNode firstHead = null;
        ListNode secondHead = null;
        
        /* Find the middle node and reverse the first half list. */
        while (runner != null && runner.next != null) {
            runner = runner.next.next;
            
            /* Reverse */
            next = walker.next;
            walker.next = prev;
            prev = walker;
            walker = next;
        }
        
        /* Assign heads for former half and latter half lists. */
        if (runner == null) secondHead = walker;
        else if (runner.next == null) secondHead = walker.next;
        firstHead = prev;
        
        /* Check if the original list is palindrome. */
        while (firstHead != null || secondHead != null) {
            if (firstHead.val != secondHead.val) return false;
            firstHead = firstHead.next;
            secondHead = secondHead.next;
        }
        
        return true;
    }
}
