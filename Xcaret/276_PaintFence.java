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
        if ((n == 0 || k == 0) || (n >= 3 && k == 1)) return 0;
        
        int w1 = k;
        int w2 = k * k;
        int w3;
        
        if (n == 1) return w1;
        if (n == 2) return w2;
        
        for (int i = 3; i <= n; i++) {
            w3 = (w1 + w2) * (k - 1);
            w1 = w2;
            w2 = w3;
        }
        
        return w2;
    }
}
