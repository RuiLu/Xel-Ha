public class Solution {
    /**
     *  Idea -> Let's assume p[n] is the color nth post, w[n] is is number of ways to paint nth post.
     *          So we have two situations:
     *          1. p[n] == p[n-1] -> w[n] = w[n-1]*k, in this case, we can know that p[n-2] != p[n-1],
     *                               therefore, we can treat it as w[n] = w[n-2]*(k-1).
     *          2. p[n] != p[n-1] -> w[n] = w[n-1]*(k-1).
     *          So, w[n] = (w[n-1] + w[n-2]) * (k-1).
     * 
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int numWays(int n, int k) {
        if ((n == 0 || k == 0) || (n >= 3 && k == 1)) return 0;
        
        int w1 = k;
        int w2 = k*k;
        int w3;
        
        if (n == 1) return w1;
        if (n == 2) return w2;
        
        for (int i = 3; i <= n; i++) {
            w3 = (w1+w2) * (k-1);
            w1 = w2;
            w2 = w3;
        }
        
        return w2;
    }
}
