public class Solution {
    /**
     *  Using Map 
     *  Time complexity -> O(n), where n is the length of magazine
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) return false;
        if (ransomNote.length() == 0) return true;
        if (ransomNote.length() > magazine.length()) return false;
        
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : magazine.toCharArray()) {
            if (!map.containsKey(ch)) map.put(ch, 0);
            map.put(ch, map.get(ch) + 1);
        }
        
        for (char ch : ransomNote.toCharArray()) {
            if (!map.containsKey(ch)) return false;
            map.put(ch, map.get(ch) - 1);
            if (map.get(ch) < 0) return false;
        }
        
        return true;
    }
    
    /**
     *  Or we can use a char array to represent Map, which runs faster
     */ 
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] counts = new int[26];
        
        for (char ch : magazine.toCharArray()) {
            counts[ch - 'a']++;
        }
        for (char ch : ransomNote.toCharArray()) {
            if (--counts[ch - 'a'] < 0) return false;
        }
        
        return true;
    }
}
