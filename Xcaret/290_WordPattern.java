public class Solution {
    /**
     *  Idea -> Use a Map to record Character-String pairs
     *          Use a Set to determine whether this string is matched before
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || pattern.length() == 0 || str == null || str.length() == 0) return false;
        
        Map<Character, String> map = new HashMap<>();
        Set<String> used = new HashSet<>();
        String[] tokens = str.split(" ");
        
        if (pattern.length() != tokens.length) return false;
        
        for (int i = 0; i < pattern.length(); i++) {
            char curr = pattern.charAt(i);
            String word = tokens[i];
            
            if (!map.containsKey(curr)) {
                if (!used.contains(word)) {
                    map.put(curr, word);
                    used.add(word);
                } else {
                    return false;
                }
            } else {
                if (!map.get(curr).equals(word)) return false;
            }
        }
        
        return true;
    }
}
