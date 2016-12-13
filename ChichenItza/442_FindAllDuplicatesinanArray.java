public class Solution {
    /**
     *  Idea -> When we find a number i, flip the number on position i-1 to negative.
     *          So we find another number j, if the number on position j-1 is negative, then j is duplicated number.
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        if (nums == null || nums.length <= 1) return list;
        
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) list.add(Math.abs(nums[i]));
            else nums[index] = -nums[index];
        }
        
        return list;
    }
}
