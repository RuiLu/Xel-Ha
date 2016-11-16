public class Solution {

    private Map<Integer, List<Integer>> map;
    private Random rand;
    
    public Solution(int[] nums) {
        map = new HashMap<>();
        rand = new Random();
        
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) map.put(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        if (!map.containsKey(target)) return 0;
        int r = rand.nextInt(map.get(target).size());
        return map.get(target).get(r);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
