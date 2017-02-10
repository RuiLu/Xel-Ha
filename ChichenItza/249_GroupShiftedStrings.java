public class Solution {
    /**
     * Idea -> find rules
     * Time complexity -> O(nm), where n is the length of strings, m is the average length of string
     */
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if (strings == null || strings.length == 0) return res;
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strings) {
            if (s.length() == 0) continue;
            else if (s.length() == 1) {
                if (!map.containsKey("")) map.put("", new ArrayList<>());
                map.get("").add(s);
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i < s.length(); i++) {
                    int rule = (s.charAt(i)-'a') - (s.charAt(i-1)-'a');
                    /* be careful with the negative rule */
                    if (rule < 0) rule += 26;
                    sb.append(rule);
                }
                
                String rule = sb.toString();
                if (!map.containsKey(rule)) map.put(rule, new ArrayList<>());
                map.get(rule).add(s);
            }
        }
        
        for (String key : map.keySet()) res.add(map.get(key));
        
        return res;
    }
}
