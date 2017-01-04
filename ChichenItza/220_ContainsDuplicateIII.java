public class Solution {
    /**
     *  Idea -> Binary search tree, uses the property of TreeSet.
     *  Time complexity -> O(nlogn)
     */ 
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k < 1 || t < 0) return false;
        
        TreeSet<Long> tset = new TreeSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            Long floor = tset.ceiling((long) nums[i] - t);
            Long ceiling = tset.floor((long) nums[i] + t);
            if ((floor != null && floor <= (long) nums[i]) || (ceiling != null && ceiling >= (long) nums[i])) {
                return true;
            }
            tset.add((long) nums[i]);
            if (i-k >= 0) tset.remove((long) nums[i-k]);
        }
        
        return false;
    }
    
    /**
     *  Idea -> Bucket sort.
     *          Tricky part is how to calculate the bucket id:
     *          1. calculate remappedNum by subtracting Integer.MIN_VALUE,
     *             we use Long here in order to avoid overflow
     *          2. divide remappedNum by (t+1) to obtain the bucket id.
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k < 1 || t < 0) return false;
        
        HashMap<Long, Long> map = new HashMap<>();
        long w = (long) t + 1;
        
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long id = remappedNum / w;
            if (map.containsKey(id) ||
                (map.containsKey(id-1) && remappedNum-map.get(id-1) <= t) ||
                (map.containsKey(id+1) && map.get(id+1)-remappedNum <= t)) {
                return true;        
            }
            map.put(id, remappedNum);
            if (i-k >= 0) {
                remappedNum = (long) nums[i-k] - Integer.MIN_VALUE;
                id = remappedNum / w;
                map.remove(id);
            }
        }
        
        return false;
    } 
    
}
