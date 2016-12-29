public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        double mid = -1.0 * b / (2 * a);
        int i = 0;
        int[] res = new int[nums.length];
        
        for (; i < nums.length; i++) {
            if ((double)nums[i] > mid) break;    
        }
        
        int left = i - 1, right = i;
        if (a >= 0) {
            int count = 0;
            while (left >= 0 && right < nums.length) {
                if ((mid - (double)nums[left]) <= ((double)nums[right] - mid)) {
                    res[count++] = newValue(nums[left--], a, b, c);
                } else {
                    res[count++] = newValue(nums[right++], a, b, c);
                }
            }
            while (left < 0 && right < nums.length) res[count++] = newValue(nums[right++], a, b, c);
            while (left >= 0 && right >= nums.length) res[count++] = newValue(nums[left--], a, b, c);
        } else {
            int count = nums.length - 1;
            while (left >= 0 && right < nums.length) {
                if ((mid - (double)nums[left]) <= ((double)nums[right] - mid)) {
                    res[count--] = newValue(nums[left--], a, b, c);
                } else {
                    res[count--] = newValue(nums[right++], a, b, c);
                }
                
            }
            while (left < 0 && right < nums.length) res[count--] = newValue(nums[right++], a, b, c);
            while (left >= 0 && right >= nums.length) res[count--] = newValue(nums[left--], a, b, c);
        }
        
        return res;
    }
    
    private int newValue(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
