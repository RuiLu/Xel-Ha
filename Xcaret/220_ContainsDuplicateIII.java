public class Solution {
    /**
     *  Idea -> Binary Search Tree, using a TreeSet
     *  Time complexity -> O(nlogk)
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1 || k < 1 || t < 0) return false;
        TreeSet<Integer> tset = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer floor = tset.ceiling(nums[i] - t);
            Integer ceiling = tset.floor(nums[i] + t);
            if ((floor != null && floor <= nums[i]) || (ceiling != null && ceiling >= nums[i])) {
                return true;
            }
            tset.add(nums[i]);
            if (i >= k) tset.remove(nums[i-k]);
        }
        return false;
    }
    
    /**
     *  Time Limit Exceeded
     *  Idea -> Take the advantage of sliding window
     *  Time complexity -> O(nt)
     *  Space complexity -> O(K)
     */
    // public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    //     if (nums == null || nums.length <= 1 || t < 0) return false;
    //     Set<Integer> set = new HashSet<Integer>();
    //     t = Math.abs(t);
    //     for (int i = 0; i < nums.length; i++) {
    //         if (i > k) set.remove(nums[i-k-1]);
    //         for (int j = nums[i] - t; j <= nums[i] + t; j++) {
    //             if (set.contains(j)) return true;
    //         }
    //         set.add(nums[i]);
    //     }
    //     return false;
    // }
}
