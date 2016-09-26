public class Solution {
    /**
     *  Time complexity -> O(n)
     */
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        
        boolean seenNumber = false;
        boolean seenNumberAfterE = true;
        boolean seenPoint = false;
        boolean seenE = false;
        
        s = s.trim();
        char[] sca = s.toCharArray();
        
        for (int i = 0; i < sca.length; i++) {
            if (Character.isDigit(sca[i])) {
                seenNumber = true;
                seenNumberAfterE = true;
            } else if (sca[i] == '.') {
                if (seenPoint || seenE) return false;
                seenPoint = true;
            } else if (sca[i] == 'e') {
                if (seenE || !seenNumber) return false;
                seenE = true;
                seenNumberAfterE = false; 
            } else if (sca[i] == '+' || sca[i] == '-') {
                if (i != 0 && sca[i-1] != 'e') return false;
            } else {
                return false;
            }
        }
        
        return seenNumber && seenNumberAfterE;
    }
}
