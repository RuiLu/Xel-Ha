public class Solution {
    /**
     *  Idea -> Using a Deque, which is double-end queue, we keep index in the queue.
     *  Time complexity -> O(n), because the property of Deque
     *  Space complexity -> O(k)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;
        
        Deque<Integer> queue = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // when the window is sliding away
            while (!queue.isEmpty() && i - k + 1 > queue.peek()) {
                queue.poll();
            }
            
            // when previous elements are smaller than the current element in the window
            while (!queue.isEmpty() && nums[queue.peek()] < nums[i]) {
                queue.poll();
            }
            
            queue.offer(i);
            
            if (i + 1 >= k) {
                res[index++] = nums[queue.peek()];
            }
        }
        
        return res;
    }
    
    /** 
     *  Idea -> Using a PriorityQueue to maintain the descending window
     *  Time complexity -> O(n^2)
     */ 
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     if (nums == null || nums.length == 0) return nums;
        
    //     int[] res = new int[nums.length - k + 1];
    //     PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        
    //     for (int i = 0; i < k; i++) {
    //         pq.offer(nums[i]);
    //     }
        
    //     int count = 0;
    //     res[count++] = pq.peek();
        
    //     for (int i = k; i < nums.length; i++) {
    //         pq.remove(nums[i-k]);
    //         pq.offer(nums[i]);
    //         res[count++] = pq.peek();
    //     }
        
    //     return res;
    // }
}
