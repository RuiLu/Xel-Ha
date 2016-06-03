public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) return true;
            if (nums[m] > nums[r]) {
                if (nums[m] < target || nums[r] >= target) l = m + 1;
                else r = m - 1;
            } else if (nums[m] == nums[r]) {
                r--;
            } else {
                if (nums[m] < target && nums[r] >= target) l = m + 1;
                else r = m - 1;
            }
        }
        return false;
    }
}
