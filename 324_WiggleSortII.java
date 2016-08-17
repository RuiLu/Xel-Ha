/**
 *  Refered from -> https://discuss.leetcode.com/topic/41464/step-by-step-explanation-of-index-mapping-in-java/2
 *  In fact, i'm not so clear about the second step...
 */
public class Solution {
    public void wiggleSort(int[] nums) {
    
        
        
        // 1. get the median
        int len = nums.length;
        int median = findKthLargest(nums, (len + 1) / 2);
    
        // 2. complicate work...
        int left = 0, right = nums.length - 1, i = 0;
        while (i <= right) {
            if (nums[mapIndex(i, len)] > median) {
                swap(nums, mapIndex(left++, len), mapIndex(i++, len));
            } else if (nums[mapIndex(i, len)] < median) {
                swap(nums, mapIndex(right--, len), mapIndex(i, len));
            } else {
                i++;
            }
        }
    }
    
    private int mapIndex(int index, int len) {
        return (1 + 2 * index) % (len | 1);
    }
    
    private int findKthLargest(int[] nums, int k) {
        // randomize the array
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
            while (i < hi && nums[lo] < nums[++i]);
            while (j > lo && nums[lo] > nums[--j]);
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
