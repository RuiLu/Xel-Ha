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
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     *  
     *  Idea -> Connect 1->3, 2->4, 3->5, 4->6 ..., then connect oddTail to evenHead
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        
        ListNode evenHead = head.next;
        
        ListNode oddIter = head;
        ListNode evenIter = head.next;
        
        while (true) {
            if (oddIter.next == null || oddIter.next.next == null) break;
            oddIter.next = oddIter.next.next;
            oddIter = oddIter.next;
            if (evenIter.next == null || evenIter.next.next == null) break;
            evenIter.next = evenIter.next.next;
            evenIter = evenIter.next;
        }
        
        oddIter.next = evenHead;
        evenIter.next = null;
        
        return head;        
    }
}
