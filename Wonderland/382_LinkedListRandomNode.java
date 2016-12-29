/*
 * Reservoir Sampling
 */
public class Solution {

    /** @param head The linked list's head. Note that the head is guanranteed to be not null, so it contains at least one node. */
    private ListNode head = null;
    private Random randomGenerator = null;
    
    public Solution(ListNode head) {
        this.head = head;
        randomGenerator = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode result = null;
        ListNode iter = head;
        
        for (int n = 1; iter != null; n++) {
            if (randomGenerator.nextInt(n) == 0) result = iter;
            iter = iter.next;
        }
        
        return result.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
