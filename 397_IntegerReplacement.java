public class Solution {
    /**
     *  Bit manipulation is always a problem...
     *  Reference -> https://discuss.leetcode.com/topic/58919/4ms-java-solution
     */
    public int integerReplacement(int n) {
        int count = 0;
        long iter = n;
        
        while (iter != 1) {
            if (iter == 3) return count + 2;
            if ((iter & 1) == 0) {
                count++;
                iter >>= 1;
                continue;
            }
            
            if ((iter & 2) == 2) {
                iter++;
                count++;
            } else {
                iter--;
                count++;
            }
        }
        
        
        return count;
    }
}
