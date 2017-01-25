/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * Idea -> 1. Create a duplicate node right after each node
     *         2. Copy the random pointer, be careful with the random pointer for duplicated node
     *         3. Then detach the original list.
     * Time complexity -> O(n)
     * Space complexity -> O(1)
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        
        RandomListNode fakeHead = new RandomListNode(-1);
        fakeHead.next = head;
        RandomListNode iter = fakeHead;
        RandomListNode curr = head;
        RandomListNode next = null;
        
        /* pass 1 -> copy each original ListNode, and place new node right after the copied node */
        while (curr != null) {
            next = curr.next;
            
            RandomListNode newNode = new RandomListNode(curr.label);
            curr.next = newNode;
            newNode.next = next;
            
            curr = next;
        }
        
        /* pass 2 -> copy random pointer for every new node */
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        /* pass 3 -> detach original nodes and new nodes */
        curr = head;
        while (curr != null) {
            iter.next = curr.next;
            iter = iter.next;
            
            next = curr.next.next;
            curr.next = next;
            curr = next;
        }
        
        return fakeHead.next;
    }
}
