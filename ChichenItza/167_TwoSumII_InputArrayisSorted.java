public class Solution {
    /**
     * Time complexity -> O(n)
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) return numbers;
        
        int[] res = new int[2];
        int lo = 0;
        int hi = numbers.length-1;
        
        while (lo < hi) {
            int sum = numbers[lo]+numbers[hi];
            if (sum == target) {
                res[0] = lo+1;
                res[1] = hi+1;
                break;
            } else if (sum > target) {
                hi--;
            } else {
                lo++;
            }
        }
        
        return res;
    }
}
