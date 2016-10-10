public class Solution {
    /**
     *  Idea -> No tricky method, just solve this problem into two steps: 1. first; 2. middle; 3. end
     *          When dealing with middle part, pay attention to the Integer overflow
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            list.add(getRange(lower, upper));
            return list;
        }
        
        int len = nums.length;
        
        // Start
        if (lower < nums[0]) {
            list.add(getRange(lower, nums[0] - 1));
        }
        
        // Middle. Pay attention to the Integer overflow and elements in array might be duplicated
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] == nums[i+1] || nums[i+1] - nums[i] == 1) continue;
            else list.add(getRange(nums[i] + 1, nums[i+1] - 1));
        }
        
        // End
        if (upper > nums[len-1]) {
            list.add(getRange(nums[len-1] + 1, upper));
        }
        
        return list;
    }
    
    private String getRange(int lower, int upper) {
        StringBuilder sb = new StringBuilder();
        sb.append((lower == upper ? lower : lower + "->" + upper));
        return sb.toString();
    }
}
