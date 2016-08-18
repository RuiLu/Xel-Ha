public class Solution {
    public double myPow(double x, int n) {
        double res = 1.0;
        long absN = Math.abs((long)n);
        while (absN > 0) {
            if ((absN & 1) == 1) res *= x;  // absN % 2 == 1;
            absN >>= 1;                     // absN /= 2;
            x *= x;
        }
        return n < 1 ? 1/res : res;
    }
}
