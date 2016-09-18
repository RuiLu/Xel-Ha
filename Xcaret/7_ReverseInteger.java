public class Solution {
    /**
     *  Pay attention to overflow
     *  If overflow, the new result will not equal to the previous result
     */
    public int reverse(int x) {
        boolean negative = false;
        if (x < 0) negative = true;
        
        x = negative ? -x : x;
        int res = 0;
        
        while (x != 0) {
            int remainder = x % 10;
            int newRes = res * 10 + remainder;
            
            if ((newRes - remainder) / 10 != res) return 0; 
            
            res = newRes;
            x /= 10;
        }
        
        return negative ? -res : res;
    }
}
