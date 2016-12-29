public class Solution {
    public int[] singleNumber(int[] nums) {
        // 1. Using set, space complecity is not constant
        Set<Integer> set = new HashSet<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) set.remove(nums[i]);
            else set.add(nums[i]);
        }
        Object[] o = set.toArray();
        res[0] = (int)o[0];
        res[1] = (int)o[1];
        return res;
        
        // 2. Bit manipulation
        int result = nums[0];
        int[] res = new int[2];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        int lowbit = result & (-result);
        for (int i = 0; i < nums.length; i++) {
            if ((lowbit & nums[i]) == 0) res[0] ^= nums[i];
            else res[1] ^= nums[i];
        }
        return res;
    }
}
