public class Solution {
    // First -> easy thought, but with time complexity O(nlogn), space complexity -> O(1)
    // public int findKthLargest(int[] nums, int k) {
    //     Arrays.sort(nums);
    //     return nums[nums.length - k];
    // }
    
    // Second -> time complexity -> O(nlogk), space complexity -> O(k)
    // public int findKthLargest(int[] nums, int k) {
    //     PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //     for (int num : nums) {
    //         minHeap.offer(num);
    //         if (minHeap.size() > k) minHeap.poll();
    //     }
    //     return minHeap.peek();
    // }
    
    /**
     *  Third -> time complexity -> O(n), space complexity -> O(1)
     *  Using the same thought of quicksort
     *  However, time complexity of best occasion is O(N), while the worst complexity is O(N^2), how to guarantee it to O(N)?
     *  We can randomize the array, so to guarantee that time complexity is O(N).
     */    
    public int findKthLargest(int[] nums, int k) {
    
        // in order to guarantee O(n), need randomize
        shuffle(nums);
        
        k = nums.length - k;
        int lo = 0, hi = nums.length - 1;
        
        while (lo < hi) {
            int j = partition(nums, lo, hi);
            if (j > k) hi = j - 1;
            else if (j < k) lo = j + 1;
            else break;
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
    
    private void shuffle(int[] nums) {
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int r = random.nextInt(i + 1);
            swap(nums, i, r);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
}
