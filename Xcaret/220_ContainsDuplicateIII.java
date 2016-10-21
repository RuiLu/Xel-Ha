public class Solution {
    /**
     *  Idea -> Binary Search Tree, using a TreeSet
     *  Time complexity -> O(nlogk)
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0 || nums == null || nums.length <= 1) return false;
        
        TreeSet<Integer> tset = new TreeSet<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            Integer floor = tset.ceiling(nums[i] - t);
            Integer ceiling = tset.floor(nums[i] + t);
            
            if ((floor != null && nums[i] >= floor) || (ceiling != null && nums[i] <= ceiling)) {
                return true;
            }
            
            tset.add(nums[i]);
            if (i >= k) tset.remove(nums[i-k]);    
        }
        
        return false;
    }
}
