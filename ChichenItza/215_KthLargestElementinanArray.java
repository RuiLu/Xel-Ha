public class Solution {
    /**
     *  Idea -> Use the same thought of quicksort, Divide and conquer.
     *  Time complexity -> O(n)
     *  Space complexity ->
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) return 0;
        
        int lo = 0;
        int hi = nums.length - 1;
        k = nums.length - k;
        
        while (lo <= hi) {
            int j = partition(nums, lo, hi);
            if (j == k) return nums[k];
            else if (j > k) hi = j - 1;
            else lo = j + 1;
        }
        
        return nums[k];
    }
    
    private int partition(int[] nums, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        
        while (true) {
            while (i < hi && nums[lo] > nums[++i]);
            while (j > lo && nums[lo] < nums[--j]);
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        
        return j;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    /**
     *  Idea -> Using MinHeap
     *  Time complexity -> O(nlogk)
     *  Space complexity -> O(k)
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            if (pq.size() > k) pq.poll();
        }
        
        return pq.peek();
    }
}
