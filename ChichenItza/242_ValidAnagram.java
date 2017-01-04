public class Solution {
    /**
     *  Idea -> Nothing to say.
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length())
            return false;
        
        int[] counts = new int[26];
        for (char ch : s.toCharArray()) counts[ch-'a']++;
        for (char ch : t.toCharArray()) counts[ch-'a']--;
        for (int count : counts) if (count != 0) return false;
        
        return true;
    }
}
