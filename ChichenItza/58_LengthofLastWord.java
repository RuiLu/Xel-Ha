public class Solution {
    /**
     *  Idea -> Nothing to say
     *  Time complexity -> O(last-word-length)
     */
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        s = s.trim();
        int count = 0;
        for (int i = s.length() - 1; i >= 0 && s.charAt(i) != ' '; i--) {
            count++;
        }
        return count;
    }
}
