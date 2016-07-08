/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m > n) return head;
        
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode curr = head;
        ListNode prev = fakeHead;
        ListNode next = null;
        ListNode stopHere = null;
        ListNode reverseHead = null;
        ListNode reverseTail = null; 
        
        int count = 1;
        
        while (curr != null) {
            if (count >= m && count <= n) {
                if (count == m) {
                    stopHere = prev;
                    reverseHead = curr;
                }
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                if (count == n) {
                    reverseTail = prev;
                    break;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
            count++;
        }
        
        stopHere.next = reverseTail;
        reverseHead.next = curr;
        return fakeHead.next;
    }
}

// public class Solution {
//     public ListNode reverseBetween(ListNode head, int m, int n) { 
//         if (head == null || m > n) return head;
        
//         ListNode fakeHead = new ListNode(-1);
//         fakeHead.next = head;
//         ListNode pre = fakeHead;
        
//         for (int i = 0; i < m - 1; i++) {
//             pre = pre.next;
//         }
        
//         ListNode start = pre.next;
//         ListNode tail = start.next;
        
//         for (int i = 0; i < n - m; i++) {
//             start.next = tail.next;
//             tail.next = pre.next;
//             pre.next = tail;
//             tail = start.next;
//         }
        
//         return fakeHead.next;
//     }
// }
