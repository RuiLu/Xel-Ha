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
     *  Idea -> Seperate one LinkedList int two LinkedLists -> odd and even, then combine them.
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode odd = oddHead;
        ListNode even = evenHead;
        
        while (odd.next != null && odd.next.next != null) {
            /* odd */
            ListNode next = odd.next.next;
            odd.next = next;
            odd = next;
            
            /* even */
            next = odd.next;
            even.next = next;
            even = next;
        }
        
        odd.next = evenHead;
        return oddHead;
    }
}
