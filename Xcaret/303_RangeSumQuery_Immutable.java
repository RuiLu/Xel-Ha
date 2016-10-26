public class NumArray {
    /**
     *  Idea -> Binary Index Tree
     */
    private int[] BIT = null; 
     
    private void update(int index, int len, int val) {
        index += 1;
        
        while (index <= len) {
            BIT[index] += val;
            index += (index) & (-index);
        }
    } 
     
    private int getSum(int index) {
        int sum = 0;
        index += 1;
        
        while (index > 0) {
            sum += BIT[index];
            index -= (index) & (-index);
        }
        
        return sum;
    }
     
    public NumArray(int[] nums) {
        int len = nums.length;
        BIT = new int[len+1];
        for (int i = 0; i < nums.length; i++) {
            update(i, len, nums[i]);
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
// numArray.sumRange(1, 2);
