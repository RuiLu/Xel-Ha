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
            if (Character.isDigit(curr)) {
                seenNumber = true;
                seenNumberAfterE = true;
            } else if (curr == '.') {
                if (seenE || seenPoint) return false;
                seenPoint = true;
            } else if (curr == 'e') {
                if (seenE || !seenNumber) return false;
                seenNumberAfterE = false;
                seenE = true;
            } else if (curr == '+' || curr == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
            } else {
                return false;
            }
        }
        
        return seenNumber && seenNumberAfterE;
    }
}
