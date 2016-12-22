import java.util.*;

public class Solution {
    /**
     *  Idea -> Using a Deque, which is double-end queue, we keep index in the queue.
     *  Time complexity -> O(n), because the property of Deque
     *  Space complexity -> O(k)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) return new int[0];
        
        int len = nums.length;
        int[] res = new int[len-k+1];
        int index = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < len; i++) {
            // maintain the window size
            while (!deque.isEmpty() && deque.peek() < i - k + 1) deque.poll();
            
            // when previous elements are smaller than the current element in the window
            // we should keep the index of the biggest element within the window at the head of queue
            // and keep index of the second biggest element following the biggest one's index.
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();
            deque.offer(i);
            
            if (i - k + 1 >= 0) res[index++] = nums[deque.peek()];
        }
        
        return res;
    }
}
