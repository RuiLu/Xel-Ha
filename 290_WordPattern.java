public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || pattern.length() == 0) return false;
        
        String[] tokens = str.split(" ");
        if (pattern.length() != tokens.length) return false;
        
        Map<Character, String> map = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (!map.containsKey(ch)) {
                if (map.containsValue(tokens[i])) return false;
                map.put(ch, tokens[i]);
            } else {
                if (!map.get(ch).equals(tokens[i])) return false;
            } 
        }
        
        return true;
    }
}
