public class NumArray {
    /**
     * Idea -> Binary Index Tree
     * Time complexity -> O(nlogn) for NumArray
     *                    O(logn) for sumRange and update
     */
    private int[] BIT = null;
    private int[] nums = null;
    
    private void updateBIT(int index, int val) {
        index += 1;
        
        while (index <= nums.length) {
            BIT[index] += val;
            index += index & (-index);
        }
    }
    
    private int getSum(int index) {
        int res = 0;
        index += 1;
        
        while (index > 0) {
            res += BIT[index];
            index -= index & (-index);
        }
        
        return res;
    }
    
    public NumArray(int[] nums) {
        int len = nums.length;
        this.nums = nums;
        this.BIT = new int[len+1];
        
        for (int i = 0; i < len; i++) {
            updateBIT(i, nums[i]);
        }
    }

    void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        int index = i + 1;
        
        while (index <= nums.length) {
            BIT[index] += diff;
            index += index & (-index);
        }
    }

    public int sumRange(int i, int j) {
        if (i > j) return 0;
        
        int firstSum = getSum(i - 1);
        int secondSum = getSum(j);
        
        return secondSum - firstSum;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
