public class NumArray {
    /**
     *  Idea -> Create a sum-up array 
     */
    private int[] arr; 
     
    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) return;
        arr = new int[nums.length+1];
        for (int i = 1; i <= nums.length; i++) {
            arr[i] = arr[i-1]+nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        if (i > j) return 0;
        int sum1 = arr[j+1];
        int sum2 = arr[i];
        return sum1-sum2;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
