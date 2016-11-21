public class Solution {
    /**
     *  Idea -> keep a window whose size is k
     *  Time complexity -> O(n)
     *  Space complexity -> O(k)
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return false;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) return true;
            if (i - k >= 0) set.remove(nums[i-k]);
        }
        return false;
    }
}
