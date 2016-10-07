public class Solution {
    /**
     *  Bit manipulation
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int sum = 0;
        
        // pass 1 -> XOR all numbers in nums array
        for (int num : nums) {
            sum ^= num;
        }
        
        // get the last set bit
        int setBit = sum & (-sum);
        
        // pass2 -> find two unique element according set bit
        for (int num : nums) {
            if ((num & setBit) == 0) {    // set bit is not set
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        
        return res;
    }
    
    /**
     *  Using a set, so space complexity is not constant
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) set.remove(num);
            else set.add(num);
        }
        int i = 0;
        for (int num : set) res[i++] = num;
        return res;
    }
}
