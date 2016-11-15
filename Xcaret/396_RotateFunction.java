public class Solution {
    /**
     *  Idea -> Math...
     *          next_sum = curr_sum + total - len * A[i], where i is from 0 to len-1
     *  Time complexity -> O(n)
     */
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) return 0;
        
        int max = Integer.MIN_VALUE;
        int len = A.length;
        int begin = 0;
        int total = 0;
        
        for (int i = 0; i < len; i++) {
            begin += i * A[i];
            total += A[i];
        }
        
        max = Math.max(max, begin);
        
        for (int i = len - 1; i >= 0; i--) {
            begin = begin + total - len * A[i];
            max = Math.max(max, begin);
        }
        
        return max;
    }
}
