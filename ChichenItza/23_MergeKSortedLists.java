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
     *  Idea -> Maintain a PriorityQueue
     *  Time complexity -> O(nlogk), where n is the total node in lists, k is the length of lists
     *  Space complexity -> O(k) 
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        ListNode fakeHead = new ListNode(-1);
        ListNode iter = fakeHead;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);  
        // PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
        //     public int compare(ListNode node1, ListNode node2) {
        //         return node1.val - node2.val;
        //     }
        // });
        
        for (ListNode node : lists) {
            if (node != null) pq.offer(node);
        }
        
        while (!pq.isEmpty()) {
            ListNode next = pq.poll();
            iter.next = next;
            iter = iter.next;
            
            if (next.next != null) {
                pq.offer(next.next);
            }
        }
        
        return fakeHead.next;
    }
}
