public class Solution {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        
        int prev = lower;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < prev) continue;
            
            if (nums[i] == prev) {
                prev++;
                continue;
            }
            
            res.add(getRange(prev, nums[i] - 1));
            prev = nums[i] + 1;
        }
        
        if (prev <= upper) res.add(getRange(prev, upper));
        
        return res;
    }
    
    private String getRange(int start, int end) {
        return start == end ? String.valueOf(start) : String.format("%d->%d", start, end);
    }    
}
