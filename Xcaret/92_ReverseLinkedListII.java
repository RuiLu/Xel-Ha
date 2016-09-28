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
     *  Idea: 1. record the node before reverse and the node starts reverse. 
     *        2. reverse the order of nodes between m and n, exclusive
     *        3. when reaching n, do some little connections.
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n) return head;
        
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode curr = head;
        ListNode prev = fakeHead;
        ListNode reverseHead = null;
        ListNode beforeReverse = null;
        int count = 1;
        
        while (curr != null) {
            ListNode next = curr.next;
            if (count > m && count < n) {
                curr.next = prev;
                prev = curr;
                curr = next;
            } else {
                if (count == m) {
                    beforeReverse = prev;
                    reverseHead = curr;
                } else if (count == n) {
                    beforeReverse.next = curr;
                    reverseHead.next = next;
                    curr.next = prev;
                    break;
                }
            
                prev = curr;
                curr = next;
                
            }
            count++;
        }
        
        return fakeHead.next;
    }
}
