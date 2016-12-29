/* Class of RandomListNode:
 * class RandomListNode {
 *      int label;
 *      RandomListNode next, random;
 *      RandomListNode(int x) { this.label = x; }
 * }
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        
        // First step -> duplicate each node right behind each node
        RandomListNode curr = head;
        RandomListNode next = null;
        
        while (curr != null) {
            next = curr.next;
            RandomListNode duplica = new RandomListNode(curr.label);
            curr.next = duplica;
            duplica.next = next;
            curr = next;
        }
        
        // Second step -> copy random pointer
        curr = head;
        
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        // Third step -> detach the copied list
        RandomListNode fakeHead = new RandomListNode(-1);
        RandomListNode copyIter = fakeHead;
        RandomListNode copy = null;
        curr = head;
        
        while (curr != null) {
            next = curr.next.next;
            
            // detach
            copy = curr.next;
            copyIter.next = copy;
            copyIter = copy;
            
            // linked original node
            curr.next = next;
            curr = next;
        }
        
        
        return fakeHead.next;
    }
}        

