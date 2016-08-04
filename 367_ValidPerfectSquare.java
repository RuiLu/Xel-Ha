public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 1) return false;
        long low = 1, high = num;
        long nums = (long)num;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * mid == nums) return true;
            else if (mid * mid > nums) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
}
