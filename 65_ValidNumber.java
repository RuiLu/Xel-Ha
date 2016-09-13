public class Solution {
    /**
     *  All we need is some flags
     *  Reference -> https://discuss.leetcode.com/topic/9490/clear-java-solution-with-ifs
     * 
     *  Time complexity -> O(n)
     */
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        
        s = s.trim();
        
        boolean seenPoint = false;
        boolean seenE = false;
        boolean seenNumber = false;
        boolean seenNumberAfterE = true;
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr >= '0' && curr <= '9') {
                seenNumber = true;
                seenNumberAfterE = true;
            } else if (curr == '.') {
                if (seenPoint || seenE) return false;       
                seenPoint = true;
            } else if (curr == 'e') {
                if (seenE || !seenNumber) return false;
                seenE = true;
                seenNumberAfterE = false;
            } else if (curr == '+' || curr == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
            } else {
                return false;
            }
        }
        
        return seenNumber && seenNumberAfterE;
    }
}
