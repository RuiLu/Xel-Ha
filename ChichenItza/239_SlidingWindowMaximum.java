public class Solution {
    /**
     *  Idea -> Using a Deque, which is double-end queue, we keep index in the queue.
     *  Time complexity -> O(n), because the property of Deque
     *  Space complexity -> O(k)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        
        int len = nums.length - k + 1;
        int[] res = new int[len];
        int count = 0;
        Deque<Integer> queue = new ArrayDeque<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            // maintain the window size
            while (!queue.isEmpty() && i - k + 1 > queue.peek()) queue.poll();
            
            // when previous elements are smaller than the current element in the window
            // we should keep the index of the biggest element within the window at the head of queue
            // and keep index of the second biggest element following the biggest one's index.
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) queue.pollLast();
            queue.offer(i);
            
            if (i + 1 >= k) res[count++] = nums[queue.peek()];
        }
        
        return res;
    }
}
