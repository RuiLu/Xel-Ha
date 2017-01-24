public class Solution {
    /**
     *  Idea -> Use the same thought of quicksort, Divide and conquer.
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) return 0;
        
        /* shuffle the original array first in order to avoid the worst case for quickselect */
        shuffle(nums);
        
        int len = nums.length;
        int lo = 0; 
        int hi = len-1;
        /* because we find target element from arrays in acending order */
        k = len-k;
        
        while (lo <= hi) {
            int j = partition(nums, lo, hi);
            if (j == k) return nums[j];
            else if (j > k) hi = j-1;
            else lo = j+1;
        }
        
        return nums[lo];
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    private void shuffle(int[] nums) {
        Random rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            int r = rand.nextInt(i+1);
            swap(nums, i, r);
        }
    }
    
    private int partition(int[] nums, int lo, int hi) {
        int i = lo;
        int j = hi+1;
        
        while (true) {
            while (i < hi && nums[lo] > nums[++i]);
            while (j > lo && nums[lo] < nums[--j]);
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        
        return j;
    }
    
    /**
     *  Idea -> Using MinHeap
     *  Time complexity -> O(nlogk)
     *  Space complexity -> O(k)
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) pq.poll();
        }
        
        return pq.peek();
    }
}
