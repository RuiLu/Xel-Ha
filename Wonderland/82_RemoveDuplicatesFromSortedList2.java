/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fakeHead = new ListNode(-1);
        ListNode fast = head, slow = fakeHead;
        slow.next = fast;
        while (fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }
            if (slow.next == fast) { // no duplicate
                slow = slow.next;
                fast = fast.next;
            } else { // has duplicate
                slow.next = fast.next;
                fast = slow.next;
            }
        }
        return fakeHead.next;
    }
}
