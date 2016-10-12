public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        if (n == 0) return n;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += (n & 1);
            n >>= 1;
        }
        return res;
    }
}
