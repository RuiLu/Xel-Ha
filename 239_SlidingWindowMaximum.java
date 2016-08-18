public class Solution {
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
