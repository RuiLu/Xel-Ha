/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     *  Idea -> Find the difference length, diff, between lenA and lenB.
     *          Move forward the ListNode with longer length diff steps, so the two remaining lists have the same length.
     *          Finally, compare two ListNodes one by one to find intersection.
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        // first get lengths of list A and list B
        int lenA = 0;
        int lenB = 0;
        ListNode iter = headA;
        while (iter != null) {
            lenA++;
            iter = iter.next;
        }
        iter = headB;
        while (iter != null) {
            lenB++;
            iter = iter.next;
        }
        
        // get the length difference diff, move the longer list diff steps
        if (lenA > lenB) {
            while (lenA-- > lenB) headA = headA.next;
        } else if (lenA < lenB) {
            while (lenB-- > lenA) headB = headB.next;
        }
        
        while (headA != null && headB != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
}
