public class Solution {
    /**
     *  Bit manipulation
     *  Idea -> Do XOR operation one by one
     *          It's easy to understand once we turn number into binary format
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        
        for (int num : nums) {
            res = res ^ num;
        }
        
        return res;
    }
}
