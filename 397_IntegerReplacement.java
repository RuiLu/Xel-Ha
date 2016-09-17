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
            
            count++;
            
            if ((iter & 1) == 0) {
                iter >>= 1;
                continue;
            }
            
            /**
             *  If still don't understant why, can simply take 3 as an example 
             *  3 -> 1. 3 -> 2 -> 1
             *       2. 3 -> 4 -> 2 -> 1
             *  Remerber consider about binary 
             */
            if ((iter & 2) == 2) {
                iter++;
            } else {
                iter--;
            }
        }
        
        return count;
    }
}
