public class Solution {

    /**
     *  Using queue -> O(n)
     *  poll(), peek(), offer() -> O(1)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;
        
        int len = nums.length;
        int[] res = new int[len - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        int index = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // remove the number out of range k, starting from i 
            while (!queue.isEmpty() && queue.peek() < (i - k + 1)) {
                queue.poll();
            }
            
            // keep the index of largest element in the window
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            
            queue.offer(i);
            
            if (i >= k - 1) {
                res[index++] = nums[queue.peek()];
            }
        }
        
        return res;
    }

    /**
     *  Using heap -> O(nlogn)
     */ 
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;
        
        int len = nums.length;
        int[] res = new int[len - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }
        res[0] = pq.peek();
        for (int i = 1; i < len - k + 1; i++) {
            pq.remove(nums[i - 1]);
            pq.offer(nums[i + k - 1]);
            res[i] = pq.peek();
        }
        
        return res;
    }
}
