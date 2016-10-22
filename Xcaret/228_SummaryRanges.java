public class Solution {
    /**
     *  Time complexity -> O(n)
     *  Space compleity -> O(1)
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        if (nums == null || nums.length == 0) return list;
        
        
        int begin = 0;
        int i = 0;
        while (++i < nums.length) {
            if (nums[i] - nums[i-1] == 1) continue;
            if (begin == i - 1) {
                list.add(Integer.toString(nums[begin]));
            } else {
                list.add(nums[begin] + "->" + nums[i-1]);
            }
            begin = i;
        }
        list.add((begin == i - 1 ? Integer.toString(nums[begin]) : nums[begin] + "->" + nums[i-1]));
        
        return list;
    }
}
