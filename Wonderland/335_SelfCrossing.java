/**
 * Pure math
 */
public class Solution {
    public boolean isSelfCrossing(int[] x) {
        if (x == null || x.length < 4) return false;
        
        int len = x.length;
        
        for (int i = 0; i < len - 3; i++) {
            if (x[i] >= x[i+2] && x[i+1] <= x[i+3]) return true;
            if (i >= 1) {
                if (x[i+2] == x[i] && x[i-1] + x[i+3] >= x[i+1]) return true;
            }
            if (i >= 2) {
                if (x[i+1] >= x[i-1] && x[i+3] + x[i-1] >= x[i+1] && x[i+2] + x[i-2] >= x[i] && x[i+2] <= x[i]) return true;
            }
        }
        
        return false;
    }
}
