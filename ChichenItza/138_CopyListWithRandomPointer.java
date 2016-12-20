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
     *  Idea -> 1. Copy each node
     *          2. Copy random pointer   
     *          3. Detach the original list and the duplicate list
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;
        
        RandomListNode curr = head;
        RandomListNode next = null;
        
        // 1. copy the original list.
        while (curr != null) {
            next = curr.next;
            RandomListNode newNode = new RandomListNode(curr.label);
            curr.next = newNode;
            newNode.next = next;
            curr = next;
        }
        
        // 2. copy random pointer
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        // 3. detach
        curr = head;
        RandomListNode fakeHead = new RandomListNode(-1);
        RandomListNode iter = fakeHead;
        while (curr != null) {
            iter.next = curr.next;
            iter = iter.next;
            
            curr.next = iter.next;
            curr = iter.next;
        }
        
        return fakeHead.next;
    }
}
