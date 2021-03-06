public class Solution {
    /**
     *  Using a Map
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{0, 0};
        }
        
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                res[0] = map.get(nums[i]); 
                res[1] = i;
                break;
            }
            
            map.put(target - nums[i], i);
        }
        
        return res;
    }
}
