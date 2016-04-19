// 1. Binary search
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] temp = new int[len];
        temp[0] = nums[0];
        int max = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > temp[max-1]) {
                temp[max] = nums[i];
                max++;
            } else {
                int pos = findPosToReplace(temp, 0, max - 1, nums[i]);
                temp[pos] = nums[i];
            }
        }
        return max;
    }
    
    public int findPosToReplace(int[] temp, int low, int high, int x) {
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (temp[mid] == x) {
                return mid;
            } else if (temp[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}

// 2. DP
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int max = 1;
        for (int i = 0; i < nums.length; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
