public class Solution {
    /**
     *  Two pointers.
     *  Time complexity -> O(n)
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        
        int lo = 0;
        int hi = numbers.length - 1;
        
        while (lo < hi) {
            int sum = numbers[lo] + numbers[hi];
            if (sum > target) {
                hi--;
            } else if (sum < target) {
                lo++;
            } else {
                res[0] = lo + 1;
                res[1] = hi + 1;
                break;
            }
        }
        
        return res;
    }
}
