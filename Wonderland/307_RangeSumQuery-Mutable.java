/*
 * Easy one, using Binary Index Tree
 */
public class NumArray {

    public int[] nums;
    public int[] BIT;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.BIT = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            updateBIT(nums.length, i, nums[i]);
        }
    }

    void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        int k = i + 1;
        while (k <= nums.length) {
            BIT[k] += diff;
            k += k & (-k);
        } 
    }

    public int sumRange(int i, int j) {
       if (i > j) return 0;
       int firstSum = getSum(i-1);
       int secondSum = getSum(j);
       return secondSum - firstSum;
    }
    
    private void updateBIT(int n, int index, int val) {
        index += 1;
        while (index <= n) {
            BIT[index] += val;
            index += index & (-index);
        }
    }
    
    private int getSum(int index) {
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
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
