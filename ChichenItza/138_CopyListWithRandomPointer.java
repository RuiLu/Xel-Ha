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
        
        /*
         * First, create a copied duplicate node for each original node
         */
        while (curr != null) {
            next = curr.next;
            RandomListNode copy = new RandomListNode(curr.label);
            curr.next = copy;
            copy.next = next;
            curr = next;
        }
        
        /*
         * Second, assign random pointer to each copied node
         */
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        /*
         * Third, detach copied nodes with original nodes.
         */
        curr = head;
        RandomListNode fakeHead = new RandomListNode(-1);
        RandomListNode iter = fakeHead;
        while (curr != null) {
            iter.next = curr.next;
            iter = iter.next;
            curr.next = iter.next;
            curr = curr.next;
        }
        
        return fakeHead.next;
    }
}
