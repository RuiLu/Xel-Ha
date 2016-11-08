public class Solution {
    /**
     *  Idea -> Binary Search, sometimes you need to sacrifice space to speed up
     *          We maintain a tmp array to store the longest increasing subsequence at every stage
     *          If the current element is bigger the the biggest element in tmp, then add it to the tail
     *          Else, we use binary search to find its position in tmp, then insert it into this position
     *  Time complexity -> O(nlogn)
     *  Space complexity -> O(n)
     */
    private static int findPos(int lo, int hi, int[] tmp, int num) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (tmp[mid] == num) return mid;
            else if (tmp[mid] > num) hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int len = nums.length;
        int[] tmp = new int[len];
        int max = 0;
        tmp[max] = nums[0];
        
        for (int i = 1; i < len; i++) {
            if (nums[i] > tmp[max]) {
                tmp[++max] = nums[i];
            } else {
                int pos = findPos(0, max, tmp, nums[i]);
                tmp[pos] = nums[i];
            }
        }
        
        return max + 1;
    }
    
    /**
     *  Idea -> Dynamic Programming.
     *          From 0 to len-1, check every element one by one.
     *          For example, we work on nums[3] = 5, then we need to check elements from 0 to 2,
     *          dp[i] = Math.max(dp[i], dp[j] + 1), where j >= 0 && j < i
     *  Time complexity -> O(n^2)
     *  Space complexity -> O(1)
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int maxLen = Integer.MIN_VALUE;
        int len = nums.length;
        int[] dp = new int[len];
        
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            maxLen = Math.max(maxLen, dp[i]);
        }
        
        return maxLen;
    }
}
