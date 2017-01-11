public class Solution {
    /**
     *  (This method doesn't contain division, and complete in constant time)
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;
        
        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;
        
        for (int i = 1; i < len; i++) {
            res[i] = res[i-1]*nums[i-1];
        }
        
        int right = nums[len-1];
        for (int i = len-2; i >= 0; i--) {
            res[i] = res[i]*right;
            right *= nums[i];
        }
        
        return res;
    }
     
    /**
     *  (This method doesn't contain division operation.)
     *  Idea -> Generate two additional arrays.
     *          One is the product of all numbers to the left of the ith element in the input array, 
     *          Another one is the product of all numbers to the right of the element in the input array.
     * 
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;
        
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int[] res = new int[len];
        
        left[0] = 1;
        for (int i = 1; i < len; i++) left[i] = left[i-1]*nums[i-1];
        right[len-1] = 1;
        for (int i = len-2; i >= 0; i--) right[i] = right[i+1]*nums[i+1];
        
        for (int i = 0; i < len; i++) res[i] = left[i]*right[i];
        
        return res;
    }
    
    /**
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        
        int[] res = new int[nums.length];
        int zeroCount = 0;
        int zeroIdx = -1;
        int product = 1;
        
        for (int i = 0; i < nums.length; i++) {
            // count zeores, and record zero's index.
            if (nums[i] == 0) {
                zeroIdx = i;
                zeroCount++;
                // if there are 2 or more 0 in nums, all elements in res should be 0.
                if (zeroCount == 2) return res;
                continue;
            }
            // get product of all non-zero elements.
            product *= nums[i];
        }
        
        if (zeroIdx != -1) {
            res[zeroIdx] = product;
        } else {
            for (int i = 0; i < res.length; i++) {
                res[i] = product/nums[i];
            }
        }
        
        return res;
    }
}
