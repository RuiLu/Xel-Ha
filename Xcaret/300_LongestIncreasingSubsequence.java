public class Solution {
    /**
     *  Idea -> Binary Search, sometimes you need to sacrifice space to speed up
     *          We maintain a tmp array to store the longest increasing subsequence at every stage
     *          If the current element is bigger the the biggest element in tmp, then add it to the tail
     *          Else, we use binary search to find its position in tmp, then insert it into this position
     *  Time complexity -> O(nlogn)
     *  Space complexity -> O(n)
     */
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
                int pos = findPos(tmp, max, nums[i]);
                tmp[pos] = nums[i];
            }
        }
        
        return max + 1;
    }
    
    private static int findPos(int[] tmp, int hi, int val) {
        int lo = 0;
        
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (tmp[mid] == val) return mid;
            else if (tmp[mid] > val) hi = mid - 1;
            else lo = mid + 1;
        }
        
        return lo;
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
        
        int len = nums.length;
        int[] dp = new int[len];
        int maxLen = 1;
        
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < len; i++) {
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
