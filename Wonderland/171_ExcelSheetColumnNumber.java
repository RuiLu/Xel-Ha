public class Solution {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int res = 0;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            res += (s.charAt(i) - 'A' + 1) * Math.pow(26, count++);
        }
        
        return res;
    }
}
