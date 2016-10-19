public class Solution {
    /**
     *  Idea -> 黑人问号???
     *  Time complexity -> O(n)
     *  Time complexity -> O(n)
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) return false;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) return true;
        }
        return false;
    }
    
}
