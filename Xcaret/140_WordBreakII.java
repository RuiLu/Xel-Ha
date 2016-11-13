public class Solution {
    /**
     *  Backtracking based on memorized DFS (map)
     *  Time complexity -> O(len(wordDict) ^ len(s/minWordLen))
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict.size() == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        return helper(s, wordDict, map);
    }
    
    private List<String> helper(String s, Set<String> wordDict, Map<String, List<String>> map) {
        List<String> res = new ArrayList<>();
        
        if (s.equals("")) {
            res.add("");
            return res;
        }
        
        if (map.containsKey(s)) return map.get(s);
        
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> next = helper(s.substring(word.length()), wordDict, map);
                for (String str : next) {
                    res.add(word + (str.equals("") ? "" : " " + str));
                }
            }
        }
        
        map.put(s, res);
        return res;
    }
}
