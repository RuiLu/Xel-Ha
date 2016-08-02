/*
 * Using DP, calculate the number of combination sum for each number from 1 to target
 */
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        
        Arrays.sort(nums);
        int[] result = new int[target + 1];
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num > i) {
                    break;
                } else if (num == i) {
                    result[i] += 1;
                } else {
                    result[i] += result[i - num];
                }
            } 
        }
        
        return result[target];
    }
}
