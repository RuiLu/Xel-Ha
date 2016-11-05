public class Solution {
    /**
     *  Idea -> p[] -> posts array, w[] -> number of ways to paint
     *  1. p[n] == p[n-1] -> so p[n] can choose k colors, however, should make sure p[n] != p[n-2], so w[n] = w[n-2] * (k-1)
     *  2. p[n] != p[n-1] -> so p[n] can choose k - 1 colors, so w[n] = w[n-1] * (k-1)
     *  Therefore, we can summarize the above situations to one conclusion -> w[n] = (w[n-1] + w[n-2]) * (k-1)
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public int numWays(int n, int k) {
        if (n == 0  || (n >= 3 && k == 1)) return 0;
        
        int[] w = new int[n+1];
        w[0] = 0;
        w[1] = k;
        
        if (n == 1) return w[n];
        
        w[2] = k * k;
        if (n == 2) return w[n];
        
        for (int i = 3; i <= n; i++) {
            w[i] = (w[i-1] + w[i-2]) * (k - 1);
        }
        
        return w[n];
    }
}
