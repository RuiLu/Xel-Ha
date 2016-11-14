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
     *  Idea -> first, get lenA and lenB, and calculate their difference
     *          second, iterate the longer list, make two lists have the same length from starting node
     *          third, iterate to find intersection
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        /* First, find lengths and difference */
        int lenA = 0;
        int lenB = 0;
        int diff = 0;
        ListNode iterA = headA;
        ListNode iterB = headB;
        
        while (iterA != null) {
            lenA++;
            iterA = iterA.next;
        }
        while (iterB != null) {
            lenB++;
            iterB = iterB.next;
        }
        
        diff = Math.abs(lenA - lenB);
        
        /* Second, move the longer LinkedList diff steps */
        while (diff-- > 0) {
            if (lenA > lenB) headA = headA.next;
            else headB = headB.next;
        }
        
        /* Third, find intersection one by one */
        while (headA != null && headB != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
    
    /**
     *  Idea -> First, connected one LinkedList as a circle,
     *          Then, find the intersection using runner and walker
     *          But we will modify the linked structure
     */
    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //     if (headA == null || headB == null) return null;
        
    //     /* 1. form a circle */
    //     ListNode iter = headA;
    //     while (iter.next != null) iter = iter.next;
    //     iter.next = headA;
        
    //     ListNode runner = headA.next;
    //     ListNode walker = headA;
        
    //     /* 2. walker and runner to find intersection */
    //     while (runner != walker) {
    //         runner = runner.next.next;
    //         walker = walker.next;
    //     }
        
    //     while (walker != headB && headB != null) {
    //         walker = walker.next;
    //         headB = headB.next;
    //     }
        
    //     return headB == null ? null : headB;
    // }
}
