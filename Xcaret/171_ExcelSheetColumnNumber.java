public class Solution {
    public int titleToNumber(String s) {
        /**
         *  Time complexity -> O(n)
         *  Space complexity -> O(1)
         */
        if (s == null || s.length() == 0) return 0;
        
        char[] sca = s.toCharArray();
        int res = 0;
        
        for (int i = 0; i < sca.length; i++) {
            int value = sca[i] - 'A' + 1;
            res = res * 26 + value;
        }
        
        return res;
    }
}
