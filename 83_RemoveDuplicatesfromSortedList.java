/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // First -> Iteration and Set
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        
        Set<Integer> set = new HashSet<>();
        ListNode iter = head, prev = null;
        
        while (iter != null) {
            if (!set.contains(iter.val)) {
                set.add(iter.val);
                prev = iter;
            } else {
                prev.next = iter.next;
            }
            
            iter = iter.next;
            
        }
        
        return head;
    }
    
    // Second -> Recursion
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
