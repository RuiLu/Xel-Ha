public class Solution {
    /**
     *  Idea -> Using a Map, key is pattern, value is an ArrayList storing strings meeting this pattern
     *  Time complexity -> O(n)
     */
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if (strings == null || strings.length == 0) return res;
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String string : strings) {
            StringBuilder sb = new StringBuilder();  
            for (int i = string.length() - 1; i > 0; i--) {
                int diff = (string.charAt(i) - 'a') - (string.charAt(i - 1) - 'a');
                if (diff < 0) diff += 26;
                sb.append(diff);
            }
            if (!map.containsKey(sb.toString())) map.put(sb.toString(), new ArrayList<>());
            map.get(sb.toString()).add(string);
        }
        
        for (String key : map.keySet()) res.add(map.get(key));
        
        return res;
    }
}
