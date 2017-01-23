public class Solution {
    /**
     *  Idea -> Use the same thought of quicksort, Divide and conquer.
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return -1;
        
        /* First of all, randonize the array, avoid the worst situation */
        shuffle(nums);
        
        int lo = 0;
        int hi = nums.length-1;
        /* change the rank, make it fit for acending order */
        k = nums.length-k;
        
        while (lo <= hi) {
            int j = partition(nums, lo, hi);
            if (j == k) return nums[j];
            else if (j > k) hi = j-1;
            else lo = j+1;
        }
        
        return -1;
    }
    
    /**
     *  Choose the element on lo as pivot, then find the ranking of the pivot.
     *  Elements on the left of pivot should be less than pivot. Otherwise, bigger than pivot.
     */
    private int partition(int[] nums, int lo, int hi) {
        int i = lo;
        int j = hi+1;
        
        while (true) {
            while (i < hi && nums[lo] > nums[++i]);
            while (lo < j && nums[lo] < nums[--j]);
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
    
    private void shuffle(int[] nums) {
        Random rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            int r = rand.nextInt(i+1);
            swap(nums, i, r);
        }
    }
    
    /**
     *  Idea -> Using MinHeap
     *  Time complexity -> O(nlogk)
     *  Space complexity -> O(k)
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return -1;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            if (pq.size() > k) pq.poll();
        }
        
        return pq.peek();
    }
}
