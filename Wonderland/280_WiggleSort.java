public class Solution {
    
    // First -> Use minHeap and maxHeap
    // Time complexity -> O(nlogn)
    // Space complexity -> O(n)
    public void wiggleSort(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int num : nums) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }
        
        int len = minHeap.size();
        
        for (int i = 0; i < len; i++) {
            nums[2 * i] = maxHeap.poll();
            nums[2 * i + 1] = minHeap.poll();
        }
        
        if (maxHeap.size() != 0) nums[nums.length - 1] = maxHeap.poll();
    }
    
    // Second -> In space
    // Time complexity -> O(n)
    // No space complexity
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 1) {
                if (nums[i] < nums[i-1]) swap(nums, i);
            } else if (i > 0 && nums[i] > nums[i-1]) swap(nums, i);
        }
    }
    
    private void swap(int[] nums, int i) {
        int tmp = nums[i-1];
        nums[i-1] = nums[i];
        nums[i] = tmp;
    }
}
