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
     *  DFS
     *  Time complexity -> O(n)
     *  Space complexity -> O(1), in space
     */
    public ListNode plusOne(ListNode head) {
        if (dfs(head) == 0) return head;
        ListNode newHead = new ListNode(1);
        newHead.next = head;
        return newHead;
    }
    
    private int dfs(ListNode node) {
        // when reaching the end, return 1 means plus 1
        if (node == null) return 1;
        
        int carry = dfs(node.next);
        
        if (carry == 0) return 0;
        
        int num = node.val;
        node.val = (num + carry) % 10;
        return (num + carry) / 10;
    }
    
    /**
     *  Naive
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     *  Because we use ArrayList here, and iterate many times, so cost a lot of time
     */
    // public ListNode plusOne(ListNode head) {
    //     List<Integer> list = new ArrayList<>();
    //     ListNode iter = head;
    //     while (iter != null) {
    //         list.add(iter.val);
    //         iter = iter.next;
    //     }
        
    //     int i = list.size() - 1;
    //     for (; i >= 0; i--) {
    //         int num = list.get(i);
    //         if (num == 9) {
    //             list.set(i, 0);
    //         } else {
    //             list.set(i, num + 1);
    //             break;
    //         }
    //     }
        
    //     ListNode newHead = null;
    //     if (i == -1) {
    //         newHead = new ListNode(1);
    //         newHead.next = head;
    //     } else {
    //         newHead = head;
    //     }
        
    //     for (i = 0; i < list.size(); i++) {
    //         head.val = list.get(i);
    //         head = head.next;
    //     }
        
    //     return newHead;
    // }
}
