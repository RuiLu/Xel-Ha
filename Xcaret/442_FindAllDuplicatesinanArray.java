public class Solution {
    /**
     *  Idea -> Without extra space.
     *          When we find a number i, flip the number at position i-1 to negative.
     *          If the number i at position i-1 is already negative, then i appears twice.
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        if (nums == null || nums.length <= 1) return list;
        
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                list.add(Math.abs(nums[i]));
            }
            nums[index] = -nums[index];
        }
        
        return list;
    }
     
    /**
     *  Idea -> Use extra space
     *  Time complexity -> O(n)
     *  Space complexitu -> O(n)
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        if (nums == null || nums.length <= 1) return list;

        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (!set.add(num)) list.add(num);
        }
        
        return list;
    }
}
