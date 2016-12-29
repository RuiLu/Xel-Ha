public class Solution {
    /**
     *  Moore voting algorithm, O(n), O(1) for space complexity
     *  Find reference here -> http://www.cs.utexas.edu/~moore/best-ideas/mjrty/index.html
     */
    public int majorityElement(int[] nums) {
        int count = 0, res = 0;
        for (int num : nums) {
            if (count == 0) res = num;
            
            if (res == num) count++;
            else count--;
        }
        return res;
    }
    
    /**
     *  Sorting, O(nlogn).
     *  However, it is much faster than the method using Map.
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    
    /**
     *  Map, O(n), for both time and space compleixty
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int limit = nums.length / 2;
        for (int num : nums) {
            if (!map.containsKey(num)) map.put(num, 1);
            else map.put(num, map.get(num) + 1);
            if (map.get(num) > limit) return num;
        }
        return 0;
    }
}
