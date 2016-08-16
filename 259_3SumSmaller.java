/**
 *  First sort the array, and use two pointers to do traversal.
 *  The trick here is once we found one, then doing <res += right - left>, 
 *  which saves time that takes from moving right pointer, because results are known.
 */
public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        if (nums == null || nums.length <= 2) return res;
        
        Arrays.sort(nums);
        int len = nums.length;
        
        // No need to de-duplicate
        for (int i = 0; i < len - 2; i++) {
            int left = i + 1, right = len - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < target) {
                    res += right - left; //Important!
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return res;
    }
}
