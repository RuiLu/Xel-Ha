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
     *  Idea -> Reverse the first half the LinkedList
     *          Then check is this LinkedList is palindrome
     *          We need to consider the odd length and the even length of the LinkedList
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        ListNode runner = head;
        ListNode iter = head;
        ListNode prev = null;
        ListNode next = null;
        
        while (runner != null && runner.next != null) {
            runner = runner.next.next;
            
            // reverse the former part
            next = iter.next;
            iter.next = prev;
            prev = iter;
            iter = next;
        }
        
        ListNode firstHead = prev;
        ListNode secondHead = null;
        
        // if runner != null, then the length of LinkedList is odd. Otherwise, it is even.
        if (runner != null) secondHead = iter.next;
        else secondHead = iter;
        
        while (firstHead != null && secondHead != null) {
            if (firstHead.val != secondHead.val) return false;
            firstHead = firstHead.next;
            secondHead = secondHead.next;
        }
        
        return true;
    }
}
