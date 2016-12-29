/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 *  PriorityQueue is so helpful!
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        ListNode fakeHead = new ListNode(-1);
        ListNode prev = fakeHead;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
        
        for (ListNode node : lists) {
            if (node == null) continue;
            pq.offer(node);
        }
        
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            prev.next = curr;
            prev = curr;
            if (curr.next != null) pq.offer(curr.next);
        }
        
        return fakeHead.next;
    }
}
