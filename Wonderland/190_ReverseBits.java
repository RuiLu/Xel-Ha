public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        long res = 0;
        int index = 31;
        
        while (n != 0) {
            res += Math.pow(2, index) * (n & 1);
            n = n >>> 1;
            index--;
        }
        
        return (int)res;
    }
}
