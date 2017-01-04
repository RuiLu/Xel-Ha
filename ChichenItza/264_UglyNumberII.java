public class Solution {
    /**
     *  Idea -> We can split the subsequence to three groups as below:
     *          (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
     *          (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
     *          (3) 1×5, 2×5, 3×5, 4×5, 5×5, …
     *          We can find that every subsequence is the ugly-sequence itself multiply 2, 3, 5.
     *          Every step we choose the smallest one, and move this one afterward, including number with same value.
     * 
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public int nthUglyNumber(int n) {
        if (n < 0) return 0;
        
        int[] ugly = new int[n];
        int[] indices = {0, 0, 0};
        int[] primes = {2, 3, 5};
        int[] values = {1, 1, 1};
        int next = 1;
        
        for (int i = 0; i < n; i++) {
            ugly[i] = next;
            next = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j++) {
                if (values[j] == ugly[i]) values[j] = ugly[indices[j]++] * primes[j];
                next = Math.min(next, values[j]);
            }
        }
        
        return ugly[n-1];
    }
}
