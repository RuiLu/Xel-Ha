public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        
        if (nums == null || nums.length == 0) return res;
        if (nums.length == 1) {
            res.add(nums[0] + "");
            return res;
        }
        
        int start = nums[0], end = nums[0];
        
        for (int i = 0; i < nums.length - 1; i++) {
            start = nums[i];
            while (i < nums.length - 1 && nums[i + 1] - nums[i] == 1) {
                i++;
            }
            end = nums[i];
            
            res.add(getRange(start, end));
        }
        
        if (end != nums[nums.length - 1]) res.add(nums[nums.length - 1] + "");
        
        return res;
    }
    
    private String getRange(int start, int end) {
        return start == end ? start + "" : start + "->" + end;
    }
}
