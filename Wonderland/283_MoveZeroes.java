public class Solution {
    /**
     *  Second, Insert Index
     *  Process ->
     *  1. 0 - 1 - 0 - 3 - 12
     *  2. 1 - 1 - 0 - 3 - 12
     *  3. 1 - 3 - 0 - 3 - 12
     *  4. 1 - 3 - 12 - 3 - 0
     *  5. 1 - 3 - 12 - 0 - 0
     *  
     *  Time -> O(n)
     *  Space -> O(1)
     */
    public void moveZeroes(int[] nums) {
        int insertIndex = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) nums[insertIndex++] = nums[i];
        }
        
        while (insertIndex < nums.length) nums[insertIndex++] = 0;
    }
    
    /**
     *  First, Swap
     *  Process ->
     *  1. 0 - 1 - 0 - 3 - 12
     *  2. 1 - 0 - 0 - 3 - 12
     *  3. 1 - 3 - 0 - 0 - 12
     *  4. 1 - 3 - 12 - 0 - 0
     * 
     *  Time complexity -> O(n^2)
     *  Space complexity -> O(1), but need extra function
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        
        int firstZeroIndex = -1;
        int firstNonZeroIndex = -1;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                firstZeroIndex = i;
                int j = i;
                while (j < nums.length && nums[j] == 0) j++;
                if (j < nums.length) {
                    /* Swap */
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }
}
