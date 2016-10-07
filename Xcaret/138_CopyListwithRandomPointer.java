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
     *  Idea -> Create a duplicate node right after each node
     *          Then detach the original list.
     *          Pay attention to the random pointer for duplicated node
     *  Time complexity -> O(3n) ~ O(n)
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;
        
        RandomListNode fakeHead = new RandomListNode(-1);
        fakeHead.next = head;
        RandomListNode curr = head;
        RandomListNode next = null;
        
        // pass 1 -> create duplicate node for each node
        while (curr != null) {
            RandomListNode duplicate = new RandomListNode(curr.label);
            next = curr.next;
            curr.next = duplicate;
            duplicate.next = next;
            curr = next;
        }
        
        // pass 2 -> assign random pointer to duplicate node. 
        curr = head;
        while (curr != null) {
            if (curr.random != null) {  // we need to check if random is null
                curr.next.random = curr.random.next;    
            }
            curr = curr.next.next;
        }
        
        // pass 3 -> detach the original list and duplicate list. Meanwhile, maintain original structure
        RandomListNode copyIter = fakeHead;
        RandomListNode copy = null;
        curr = head;
        fakeHead.next = curr.next;
        while (curr != null) {
            next = curr.next.next;
            
            // iterate the copy node
            copy = curr.next;
            copyIter.next = copy;
            copyIter = copy;
            
            // detach and recover
            curr.next = next;
            curr = next;
        }
        
        return fakeHead.next;
    }
}
