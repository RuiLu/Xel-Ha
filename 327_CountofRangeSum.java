public class Solution {
    /**
     *  Divide and Conquer
     *  
     *  Time complexity -> O(nlogn)
     * 
     *  Reference -> https://discuss.leetcode.com/topic/33738/share-my-solution/2
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        
        return countWithMergeSort(sums, 0, n + 1, lower, upper);
    }
    
    private int countWithMergeSort(long[] sums, int start, int end, int lower, int upper) {
        if (end - start <= 1) return 0;
        
        int mid = (start + end) / 2;
        // Divide
        int count = countWithMergeSort(sums, start, mid, lower, upper) +
                    countWithMergeSort(sums, mid, end, lower, upper);
        
        // j -> for the upper bound; k -> for the lower bound; t -> for merging
        int j = mid, k = mid, t = mid;
        long[] cache = new long[end - start];
        for (int i = start, r = 0; i < mid; i++, r++) {
            while (j < end && sums[j] - sums[i] <= upper) j++;
            while (k < end && sums[k] - sums[i] < lower) k++;
            
            // prepare for merging, sums[i] acts as pivot
            while (t < end && sums[t] < sums[i]) cache[r++] = sums[t++];
            cache[r] = sums[i];
            
            count += j - k;
        }
        
        // Merge, after this step, sums from start to end is fully sorted.
        System.arraycopy(cache, 0, sums, start, t - start);
        return count;
    }
}
