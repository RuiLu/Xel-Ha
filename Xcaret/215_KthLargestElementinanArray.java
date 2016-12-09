public class Solution {
    /**
     *  Idea -> Using the same thought as quicksort, Divide and Conquer
     *  Time complexity -> O(n)
     *  However, time complexity of best occasion is O(N), while the worst complexity is O(N^2), how to guarantee it to O(N)?
     *  We can randomize the array, so to guarantee that time complexity is O(N).
     */
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    } 
    
    private void shuffle(int[] nums) {
        Random rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            int r = rand.nextInt(i + 1);
            swap(nums, i, r);
        }
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
     
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) return 0;
        
        /* In order to make the array totally random, we need to shuffle it first */
        shuffle(nums);
            
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
    
    /**
     *  Idea -> Using a PriorityQueue to sort number.
     *  Time complexity -> O(nlogn)
     *  Space complexity -> O(n)
     */
    // public int findKthLargest(int[] nums, int k) {
    //     if (nums == null || nums.length == 0 || k > nums.length) return 0;
        
    //     int res = 0;
        
    //     PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
    //     for (int num : nums) pq.offer(num);
    //     while (k-- > 0) res = pq.poll();
        
    //     return res;
    // }
}
