public class Solution {
    /**
     *  Idea -> hard to describe, see comments
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        
        for (char ch : s.toCharArray()) {
            // if current character appears twice in a certain range, 
            // add one to count and remove this character from set
            if (set.contains(ch)) {
                count++;
                set.remove(ch);
            } else {    // if current character appears once in a certain range, add it into set
                set.add(ch);
            }
        }
        
        if (!set.isEmpty()) return count * 2 + 1;   // Non-empty set means the len of palindrome will be odd
        else return count * 2;  // Otherwise, we know all characters appear even number times.
    }
}
