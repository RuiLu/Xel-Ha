public class Solution {
    /**
     *  Idea -> count each character's appearing time
     *  Time complexity -> O(n)
     *  Time complexity -> O(n)
     */
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() <= 1) return true;
        
        Map<Character, Integer> map = new HashMap<>();
        int oddCount = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) map.put(s.charAt(i), 0);
            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            oddCount += map.get(s.charAt(i)) % 2 == 0 ? -1 : 1;
        }
        
        return oddCount == 1 || oddCount == 0;
    }
}
