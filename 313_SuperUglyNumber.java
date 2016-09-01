public class Solution {
    /**
     *  Reference -> https://discuss.leetcode.com/topic/34841/java-three-methods-23ms-36-ms-58ms-with-heap-performance-explained
     *  Time complexity -> O(kn)
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];
        
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, primes[j] * ugly[idx[j]]);
            }
            
            ugly[i] = min;
            
            for (int j = 0; j < primes.length; j++) {
                if (primes[j] * ugly[idx[j]] <= ugly[i]) idx[j]++;
            }
        }
        
        return ugly[n - 1];
    }
    
    /**
     *  Avoid redundant multiplication
     *  Time complexity -> O(kn)
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];
        int[] val = new int[primes.length];
        
        Arrays.fill(val, 1);
        int next = 1;
        
        for (int i = 0; i < n; i++) {
            ugly[i] = next;
            
            next = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                if (val[j] == ugly[i]) val[j] = ugly[idx[j]++] * primes[j];
                next = Math.min(next, val[j]);
            }
        }
        
        return ugly[n - 1];
    }
}
