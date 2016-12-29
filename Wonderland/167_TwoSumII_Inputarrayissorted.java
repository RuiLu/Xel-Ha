public class Solution {
    /**
     *  Two points
     *  Time complexity -> O(n)
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2) return new int[2];
        
        int[] res = new int[2];
        int idx1 = 0;
        int idx2 = numbers.length - 1;
        
        while (idx1 < idx2) {
            int sum = numbers[idx1] + numbers[idx2];
            if (sum == target) {
                res[0] = idx1 + 1;
                res[1] = idx2 + 1;
                break;
            } else if (sum > target) {
                idx2--;
            } else {
                idx1++;
            }
        }
        
        return res;
    }
}
