public class Solution {
    /**
     *  Idea -> Binary Search Tree, using a TreeSet
     *          TreeSet(Red-Black tree) can act as a Binary Search Tree in this case
     *  Time complexity -> O(nlogk)
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0 || nums == null || nums.length == 0) return false;
        TreeSet<Long> tset = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long floor = tset.ceiling((long)nums[i] - t);
            Long ceiling = tset.floor((long)nums[i] + t);
            if ((floor != null && floor <= (long)nums[i]) || (ceiling != null && ceiling >= (long)nums[i])) {
                return true;
            }
            tset.add((long)nums[i]);
            if (i - k >= 0) tset.remove((long)nums[i-k]);
        }
        return false;
    }
    
    /**
     *  Idea -> Bucket sort
     *          For Java, it has a bit of problem because in java -3 / 5 = 0 unlike in python -3 / 5 = -1. We can use a              functiongetID to work around this.
     *  Time complexity -> O(n)
     */
    private long getId(long i, long w) {
        return i < 0 ? (i + 1) / w - 1 : i / w;
    } 
     
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0 || nums == null || nums.length == 0) return false;
        
        HashMap<Long, Long> map = new HashMap<>();
        long w = (long)t + 1;
     
        for (int i = 0; i < nums.length; i++) {
            long id = getId(nums[i], w); 
            System.out.println(id);
            if (map.containsKey(id)) {
                return true;
            } else if (map.containsKey(id - 1) && Math.abs(map.get(id - 1) - nums[i]) < w) {
                return true;
            } else if (map.containsKey(id + 1) && Math.abs(map.get(id + 1) - nums[i]) < w) {
                return true;
            }
            
            map.put(id, (long)nums[i]);
            if (i >= k) map.remove(getId(nums[i-k], w));
        }
        return false;
    }
}
