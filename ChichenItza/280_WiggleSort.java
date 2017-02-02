public class Solution {
    /**
     * Idea -> Go over the nums array once, 
     * Time complexity -> O(n)
     */
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        
        for (int i = 0; i < nums.length; i++) {
            /* element on even position should be smaller than or equal to its previous element,
             * element on odd position should be bigger than or equal to its previous element */
            if (i%2 == 0) {
                if (i > 0 && nums[i-1] < nums[i]) swap(nums, i-1, i);
            } else {
                if (nums[i-1] > nums[i]) swap(nums, i-1, i);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    /**
     * Idea -> With help of MaxHeap and MinHeap
     * Time complexity -> O(nlogn)
     */
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);
        
        for (int num : nums) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
            if (maxHeap.size() < minHeap.size()) maxHeap.offer(minHeap.poll());
        }
        
        int idx = 0;
        while (idx < nums.length) {
            if (!maxHeap.isEmpty()) nums[idx++] = maxHeap.poll();
            if (!minHeap.isEmpty()) nums[idx++] = minHeap.poll();
        }
    }
}
