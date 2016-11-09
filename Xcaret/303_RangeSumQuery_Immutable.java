public class NumArray {
    /**
     *  Idea -> Binary Index Tree
     */
    private int[] bit = null;
     
    public NumArray(int[] nums) {
        int len = nums.length;
        bit = new int[len+1];
        for (int i = 0; i < len; i++) {
            update(i, nums[i]);
        }
    }

    public int sumRange(int i, int j) {
        if (i > j) return 0;
        int firstSum = getSum(i - 1);
        int secondSum = getSum(j);
        return secondSum - firstSum;
    }
    
    private void update(int index, int val) {
        index += 1;
        while (index < bit.length) {
            bit[index] += val;
            index += index & (-index);
        }
    }
    
    private int getSum(int index) {
        index += 1;
        int sum = 0;
        while (index > 0) {
            sum += bit[index];
            index -= index & (-index);
        }
        return sum;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
