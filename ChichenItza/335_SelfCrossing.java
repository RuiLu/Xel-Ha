public class Solution {
    /**
     *  Idea -> There are three scenarios that cause the self-crossing.
     *          1. First line crosses fourth line, second line crosses fifth line, ...
     *          2. Fifth line meets first line, and works for the lines after,
     *          3. Sixth line crosses first line, and works for the lines after.
     * 
     *  Time complexity -> O(n)
     */
    public boolean isSelfCrossing(int[] x) {
        if (x == null || x.length <= 3) return false;   
        
        for (int i = 3; i < x.length; i++) {
            if (x[i] >= x[i-2] && x[i-1] <= x[i-3]) 
                return true;
            if (i >= 4) {
                if (x[i] >= x[i-2]-x[i-4] && x[i-1] == x[i-3]) 
                    return true;
            }
            if (i >= 5) {
                /* We must ensure that x[i-2] >= x[i-4] to enable the sixth line to cross the first line. */
                if (x[i-1] <= x[i-3] && x[i-1] >= x[i-3]-x[i-5] && x[i] >= x[i-2]-x[i-4] && x[i-2] >= x[i-4]) 
                    return true;
            }
        }
        
        return false;
    }
}
