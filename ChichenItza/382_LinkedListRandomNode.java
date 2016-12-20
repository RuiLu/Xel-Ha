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
     *  Idea -> Still Reservoir Sampling 
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    private ListNode head;
    private Random rand;
        
    public Solution(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int res = 0;
        int count = 0;
        ListNode iter = head;
        while (iter != null) {
            if (rand.nextInt(++count) == 0) res = iter.val;
            iter = iter.next;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
