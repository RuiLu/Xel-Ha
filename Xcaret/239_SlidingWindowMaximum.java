public class Solution {
    /**
     *  Idea -> Using a Deque, which is double-end queue, we keep index in the queue.
     *  Time complexity -> O(n), because the property of Deque
     *  Space complexity -> O(k)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;
        
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // when the index is out of range k, poll it out from queue
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            
            // keep the index of largest element in the range
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            deque.offer(i);
            
            if (i >= k - 1) {
                res[index++] = nums[deque.peek()];
            }
        }
        
        return res;
    }
    
    /** 
     *  Idea -> Using a PriorityQueue to maintain the descending window
     *  Time complexity -> O(n^2)
     */ 
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;
        
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        
        for (int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }
        
        int count = 0;
        res[count++] = pq.peek();
        
        for (int i = k; i < nums.length; i++) {
            pq.remove(nums[i-k]);
            pq.offer(nums[i]);
            res[count++] = pq.peek();
        }
        
        return res;
    }
}
