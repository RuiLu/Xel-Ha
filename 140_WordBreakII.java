public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return new ArrayList<String>();
        Map<String, List<String>> map = new HashMap<>();
        return dfs(s, wordDict, map);
    }
    
    private List<String> dfs(String s, Set<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) return map.get(s);
        
        List<String> res = new ArrayList<>();
        
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> next = dfs(s.substring(word.length()), wordDict, map);
                for (String str : next) {
                    res.add(word + (str == "" ? "" : " " + str));
                }
            }
        }
        
        map.put(s, res);
        return res;
    }
    
}
