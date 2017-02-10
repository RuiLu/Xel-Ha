public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null || pattern.length() == 0 || str.length() == 0) return false;
        
        String[] tokens = str.trim().split("\\s+");
        
        if (tokens.length != pattern.length()) return false;
        
        /* Set is used for checking whether the string is used or not */
        Set<String> set = new HashSet<>();
        Map<Character, String> map = new HashMap<>();
        int index = 0;
        
        for (char ch : pattern.toCharArray()) {
            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(tokens[index++])) return false;
            } else {
                if (!set.add(tokens[index])) return false;
                map.put(ch, tokens[index++]);
            }
        }
        
        return true;
    }
}
