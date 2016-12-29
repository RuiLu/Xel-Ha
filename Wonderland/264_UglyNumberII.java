/**
 *  Prime factor -> 质因子
 *  Ugly number can be only obtained by various kinds of arithmetic operations between 2, 3, and 5.
 */
public class Solution {
    /**
     *  Time complexity -> O(3n) = O(n)
     *  Space complexity -> O(n)
     */
    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        
        int[] ugly = new int[n];
        int[] idx = new int[3];
        int[] val = {1, 1, 1};
        int[] primes = {2, 3, 5};
        
        int next = 1;
        
        for (int i = 0; i < n; i++) {
            ugly[i] = next;
            
            next = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j++) {
                if (val[j] == ugly[i]) val[j] = ugly[idx[j]++] * primes[j];
                next = Math.min(next, val[j]);
            }
        }
        
        return ugly[n - 1];
    }
    
    /**
     *  Time complexity -> O(n * logk), k is the size of priority queue
     *  Space complexity -> O(n + ...)
     */
    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        
        // Ascending order, which is default 
        // So PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b) does the same thing, however, here is Long
        // * return value of lambda expression can only be Integer!
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        pq.offer((long)1);
        
        for (int i = 1; i < n; i++) {
            long tmp = pq.poll();
            
            // take the duplicate values out
            while (!pq.isEmpty() && pq.peek() == tmp) pq.poll();
            
            pq.offer(tmp * 2);
            pq.offer(tmp * 3);
            pq.offer(tmp * 5);
        }
        
        return pq.poll().intValue();
    }
}
