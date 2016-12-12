public class Solution {
    /**
     *  Idea -> When we find a number i, flip position i-1 to negative.
     *          Then go over the array again to find which element is not negative, 
     *          its position i + 1 is missing number.
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for (int num : nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] < 0) continue;
            nums[index] = -nums[index];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) list.add(i + 1);
        }
        return list;
    }
}
