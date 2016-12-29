
public class NumArray {
    
    /*
     * Brute Force
     */
    public int[] nums;
    
    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public int sumRange(int start, int end) {
        if (nums == null || nums.length == 0) return 0;
        if (start > end || end >= nums.length) return 0;
        
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i > end) break;
            if (i >= start) sum += nums[i];
        }
        
        return sum;
    }
    
    /*
     * Using Binary Index Tree
     * Time complexity is O(nlogn)
     */
    public int[] BIT;
    
    public NumArray(int[] nums) {
        BIT = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            update(BIT, nums.length, i, nums[i]);
        }
    }
    
    public int sumRange(int start, int end) {
        
        if (start > end) return 0;
        
        int firstSum = getSum(BIT, start - 1);
        int secondSum = getSum(BIT, end);
        
        return secondSum - firstSum;
    }
    
    // implement two operations for Binary Index Tree
    private void update(int[] BIT, int len, int index, int val) {
        
        index += 1;
        
        while (index <= len) {
            BIT[index] += val;
            index += index & (-index);
        }
        
    }
    
    private int getSum(int[] BIT, int index) {
        
        int sum = 0;
        index += 1;
        
        while (index > 0) {
            sum += BIT[index];
            index -= index & (-index);
        }
        
        return sum;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
