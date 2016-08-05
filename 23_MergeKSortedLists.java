/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        
        ListNode fakeNode = new ListNode(-1);
        ListNode curr = fakeNode;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> (a.val - b.val));
        
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) continue;
            pq.offer(lists[i]);
        }
        
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            if (node.next != null) pq.offer(node.next);
            curr = curr.next;
        }
        
        return fakeNode.next;
    }
}
