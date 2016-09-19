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
     *  Using a PriorityQueue
     *  Let's assume n is the total number of nodes, k is the length of lists
     *  So, time complexity -> O(nlogk)
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode fakeHead = new ListNode(-1);
        ListNode iter = fakeHead;
        
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) pq.offer(lists[i]);
        }
        
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            
            iter.next = curr;
            iter = curr;
            
            if (curr.next != null) {
                pq.offer(curr.next);
            }
        }
        
        return fakeHead.next;
    }
}
